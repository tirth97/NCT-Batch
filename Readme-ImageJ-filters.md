# NCTracer + ImageJ Filters
This file tells you how the ImageJ filters, e.g., Gaussian 3D, FFT Bandpass and Thresholder are wrpped into MapReduce jobs and how NCTracer pass parameters to these batch jobs. 

## Integrate ImageJ filters into MapReduce jobs

### Gaussian 3D
This filter applies to ```ImagePlus``` object, which is the ImageJ format for 2D/3D images.

### FFT Bandpass
 - When running FFTFilter, a JAVA dialog will pop up for the users to type in the parameters. 
 However, this does not work for NCTracer, as we do not all go into each worker machine and type in these parameters. 
 (In NCTracer, users type in the parameters on a web dialog, before the batch filter is actually executed.) 
 - So, I hacked the code, implementing my own version of FFTFilter --- called ```ImageJFFTFilter```. It is in the package "sequential" under ```NCT-DB-MR``` project. 
 - With ```sequential.ImageJFFTFilter```, the filter parameters can be set directly without a dialog popped up at job runtime. 
 (Basically, I went through the original code, removing the dialog popping code and also making changes so that the filter parameters can be set directly without the dialog.)

### Threshold
This filter applies to one 2D image at a time. 
For 3D images (stored as a stack of 2D image slices), the filter needs to be called on each slice.
The following code does the trick. 
```
for (int slice = 1; slice <= zDim; slice++) {
    imgPlus.setSlice(slice);
    IJ.setAutoThreshold(imgPlus, "Huang dark");
    IJ.run(imgPlus, "Threshold", "only");
}
```
 - Reference: https://stackoverflow.com/questions/30981006/imagej-plugin-java-auto-threshold-method-doesnt-work
 - Notice that we need to add ```" dark"``` after the threshold method ("Huang" in this example).
 Without " dark", the filtered images are "inverted", having white background.
 - The commented code also works, but I find it a bit confusing to read. 

## Pass parameters to the filters
Now the filtered images (tiles) are stored into the database. 
An "image_id" is required and it should be generated (incrementally) automatically by the database.
In ```MRExecuter.java```, for the filters, the program first calls ```BatchDAO.java``` service to insert and return an auto-generated ```image_id```.
Then the program will pass this ```image_id``` to the MapReduce job.

