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
public class ImageJGaussianDTO extends DataTransferObject{
	/** Input directories. */
	private final String ijfilterInput;
	/** Output directories. */
	private final String ijfilterOutput;
	/** Gaussian 3D filter parameters. */
	private final String gaussianSigmaX, gaussianSigmaY, gaussianSigmaZ;
	private final String imageID, imageName;

	public ImageJGaussianDTO() {
		super("imagej-gaussian","/image-filter/WholeImageFilterImageJ.jar","hadoop.wholefile.WholeImageFilterImageJ");
		this.ijfilterInput = null;
		this.ijfilterOutput = null;
		this.gaussianSigmaX = null;
		this.gaussianSigmaY = null;
		this.gaussianSigmaZ = null;
		this.imageID = null;
		this.imageName = null;
	}

	public ImageJGaussianDTO(final String inputDir, final String outputDir, final String sigmaX, final String sigmaY, final String sigmaZ) {
		super("imagej-gaussian","/image-filter/WholeImageFilterImageJ.jar","hadoop.wholefile.WholeImageFilterImageJ");
		this.ijfilterInput = inputDir;
		this.ijfilterOutput = outputDir;
		this.gaussianSigmaX = sigmaX;
		this.gaussianSigmaY = sigmaY;
		this.gaussianSigmaZ = sigmaZ;
		this.imageID = "0";
		this.imageName = "gaussian no name";
	}
	
	public ImageJGaussianDTO(final String inputDir, final String outputDir, final String sigmaX, final String sigmaY, final String sigmaZ, 
			final String imageID, final String imageName) {
		super("imagej-gaussian","/image-filter/WholeImageFilterImageJ.jar","hadoop.wholefile.WholeImageFilterImageJ");
		this.ijfilterInput = inputDir;
		this.ijfilterOutput = outputDir;
		this.gaussianSigmaX = sigmaX;
		this.gaussianSigmaY = sigmaY;
		this.gaussianSigmaZ = sigmaZ;
		this.imageID = imageID;
		this.imageName = imageName;
	}

	public String getInputDir() {
		return ijfilterInput;
	}

	public String getOutputDir() {
		return ijfilterOutput;
	}
	
	public String getSigmaX() {
		return gaussianSigmaX;
	}
	
	public String getSigmaY() {
		return gaussianSigmaY;
	}
	
	public String getSigmaZ() {
		return gaussianSigmaZ;
	}
	
	public String getImageID() {
		return imageID;
	}
	
	public String getImageName() {
		return imageName;
	}

	@Override
	public String toString() {
		return "ImageJGaussianDTO [ijfilterInput=" + ijfilterInput + ", ijfilterOutput=" + ijfilterOutput
				+ ", sigmaX=" + gaussianSigmaX + ", sigmaY=" + gaussianSigmaY + ", sigmaZ=" + gaussianSigmaZ + "]";
	}

	@Override
	public String[] getCommandParameters() {
		return new String[] { this.getInputDir(), this.getOutputDir(), this.getSigmaX(), this.getSigmaY(),
			this.getSigmaZ(), this.getImageID(), this.getImageName() };
	}
}
