/*
	Copyright 2017 Northeastern University

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	  http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package batch.service.dto;

/**
 * Defines and contains matrix multiplication job parameters.
 * @author Rundong Li
 */
public class ImageJThresholdDTO extends DataTransferObject{
	/** Input directories. */
	private final String ijfilterInput;
	/** Output directories. */
	private final String ijfilterOutput;
	/** FFT bandpass filter parameters. */
	private final String thresholdMethod;
	private final String imageID, imageName;

	public ImageJThresholdDTO() {
		super("imagej-threshold","/image-filter/WholeImageIJThresholdWriteDB.jar","hadoop.wholefile.WholeImageIJThresholdDB");
		this.ijfilterInput = null;
		this.ijfilterOutput = null;
		this.thresholdMethod = null;
		this.imageID = null;
		this.imageName = null;
	}

	public ImageJThresholdDTO(final String inputDir, final String outputDir, final String thresholdMethod) {
		super("imagej-threshold","/image-filter/WholeImageIJThresholdWriteDB.jar","hadoop.wholefile.WholeImageIJThresholdDB");
		this.ijfilterInput = inputDir;
		this.ijfilterOutput = outputDir;
		this.thresholdMethod = thresholdMethod;
		this.imageID = "0";
		this.imageName = "fft-no-name";
	}

	public ImageJThresholdDTO(final String inputDir, final String outputDir, final String thresholdMethod, 
			final String imageID, final String imageName) {
		super("imagej-threshold","/image-filter/WholeImageIJThresholdWriteDB.jar","hadoop.wholefile.WholeImageIJThresholdDB");
		this.ijfilterInput = inputDir;
		this.ijfilterOutput = outputDir;
		this.thresholdMethod = thresholdMethod;
		this.imageID = imageID;
		this.imageName = imageName;
	}

	public String getInputDir() {
		return ijfilterInput;
	}

	public String getOutputDir() {
		return ijfilterOutput;
	}
	
	public String getThresholdMethod() {
		return thresholdMethod;
	}
	
	public String getImageID() {
		return imageID;
	}
	
	public String getImageName() {
		return imageName;
	}

	@Override
	public String toString() {
		return "ImageJFFTDTO [ijfilterInput=" + ijfilterInput + ", ijfilterOutput=" + ijfilterOutput
				+ ", thresholdMethod=" + thresholdMethod + "]";
	}

	@Override
	public String[] getCommandParameters() {
		return null;
	}
}
