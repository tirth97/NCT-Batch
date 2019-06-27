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
public class MatlabGaussianDTO extends DataTransferObject{
	/** Input directories. */
	private final String filterInput;
	/** Output directories. */
	private final String filterOutput;
	/** Gaussian 3D filter parameters. */
	private final String gaussianSigmaX, gaussianSigmaY, gaussianSigmaZ;
	private final String imageName;

//	public MatlabGaussianDTO(final String inputDir, final String outputDir, final String sigmaX, final String sigmaY, final String sigmaZ) {
//		this.filterInput = inputDir;
//		this.filterOutput = outputDir;
//		this.gaussianSigmaX = sigmaX;
//		this.gaussianSigmaY = sigmaY;
//		this.gaussianSigmaZ = sigmaZ;
//		this.imageName = "gaussian no name";
//	}


public MatlabGaussianDTO() {
		super("matlab-gaussian");
		this.filterInput = null;
		this.filterOutput = null;
		this.gaussianSigmaX = null;
		this.gaussianSigmaY = null;
		this.gaussianSigmaZ = null;
		this.imageName = null;
	}
	
	public MatlabGaussianDTO(final String inputDir, final String outputDir, final String sigmaX, final String sigmaY, final String sigmaZ, 
			final String imageName) {
		super("matlab-gaussian");
		this.filterInput = inputDir;
		this.filterOutput = outputDir;
		this.gaussianSigmaX = sigmaX;
		this.gaussianSigmaY = sigmaY;
		this.gaussianSigmaZ = sigmaZ;
		this.imageName = imageName;
	}

	public String getInputDir() {
		return filterInput;
	}

	public String getOutputDir() {
		return filterOutput;
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
	
	public String getImageName() {
		return imageName;
	}

	@Override
	public String toString() {
		return "MatlabGaussianDTO [filterInput=" + filterInput + ", filterOutput=" + filterOutput
				+ ", sigmaX=" + gaussianSigmaX + ", sigmaY=" + gaussianSigmaY + ", sigmaZ=" + gaussianSigmaZ
				+ ", imageName=" + imageName + "]";
	}
}
