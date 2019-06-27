# NCTracer + Matlab Filters
This file tells you, in an example, how Matlab filters are wrpped into MapReduce jobs and how NCTracer pass parameters to these batch jobs. 

## Integrate Matlab filters into MapReduce jobs
Use the "library builder" in Matlab to build a jar file which contains the filters. Refer to ![Create a Java Package with MATLAB Code](https://www.mathworks.com/help/compiler_sdk/gs/create-a-java-application-with-matlab-code.html). 

Note that sometimes the matlab filter uses some mex files. In this case, these mex files need to be included in the jar. The reason is that the *Matlab Compiler Runtime (MCR)* does not provide these mex files. 

Include this jar file in a MapReduce program, such that each mapper can call the filter in it. 

### Build Gaussian3dT and Use It in Java
We use a simple Matlab filter "Gaussian" (smooth3 with 'gauss' option) as an example.
```
function IM=Gaussian3dT(I,sigma)
IM=smooth3(I,'gauss',sigma)
```
This filter takes in a byte array for ```I``` (in '''MWNumericArray''' format) and a double number ```sigma```. The JAVA code to call this function is 
```
// convert to MWNumericArray
byte[] pixels = ((DataBufferByte) bufImg.getRaster().getDataBuffer()).getData();
MWNumericArray mwPixels = MWNumericArray.newInstance(new int[]{xDim, yDim, zDim}, pixels, MWClassID.UINT8);
// apply filter
Class1 gaussian3dT = null;
byte[] pixRes = null;
Object[] matlabResult = null;
try {
    gaussian3dT = new Class1();
    matlabResult = gaussian3dT.Gaussian3dT(1, mwPixels, sigmaX);
    pixRes = ((MWNumericArray)matlabResult[0]).getByteData();
} catch (MWException e) {
    e.printStackTrace();
} finally {
    // Free native resources
    MWArray.disposeArray(mwPixels);
    MWArray.disposeArray(matlabResult);
    gaussian3dT.dispose();
}
```
 - The ```xDim, yDim, zDim``` define the size of a 3D image. Note that ```pixels``` is a 1-D array instead of 3-D. 
 - ```gaussian3dT.Gaussian3dT(1, mwPixels, sigmaX)``` calls the filter provided by the Matlab-built jar file. 
    + The parameter ```1``` is the number of output. In this case, the result is a byte array.
    + From the second argument are the input for the filter. You can add the same number of the input arguments as defined in the Matlab filter. In this case, we have two. 

## Setting the Environment Variable for the Computer Cluster
We use Hadoop. There are a few ways to set environment variables in Hadoop, as listed below. 

### Solution 1: Editing hadoop-env.sh: The following text is added.
```
export MATLAB_LIBRARY_PATH=/Applications/MATLAB/MATLAB_Runtime/v93/runtime/maci64:/Applications/MATLAB/MATLAB_Runtime/v93/sys/os/maci64:/Applications/MATLAB/MATLAB_Runtime/v93/bin/maci64
if["$DYLD_LIBRARY_PATH"];then
	export DYLD_LIBRARY_PATH=$MATLAB_LIBRARY_PATH:$DYLD_LIBRARY_PATH
else
	export DYLD_LIBRARY_PATH=$MATLAB_LIBRARY_PATH
fi
```
- Note the in macOS we set ***DYLD_LIBRARY_PATH***, but in Linux we should set ***LD_LIBRARY_PATH*** instead. 
- Also note that JAVA_HOME is set in hadoop-env.sh also and it should point to a java version compatible with the installed Matlab Compiler Runtime version. 
- Some MATLAB manuscript says to add some system libraries to DYLD_LIBRARY_PATH, but these system libraries may be old versions of JAVA, which are not compatible with the current version of MATLAB. So to be safe, just add the libraries inside the Matlab or MCR installation directory. 

### Solution 2: Editing core.xml: Add the following.
```
<property>
	<name>mapreduce.map.env</name>
	<value>
DYLD_LIBRARY_PATH=/Applications/MATLAB/MATLAB_Runtime/v93/runtime/maci64:/Applications/MATLAB/MATLAB_Runtime/v93/sys/os/maci64:/Applications/MATLAB/MATLAB_Runtime/v93/bin/maci64
	</value>
</property>
```
Note probably we only need to add the mapreduce.map.env property, not the mapreduce.map/java.opts or Djava.library.path, as the latter is for JAVA, while the Matlab libraries are native shared libraries which need to be included in DYLD_LIBRARY_PATH in macOS, or LD_LIBRARY_PATH in Linux.
