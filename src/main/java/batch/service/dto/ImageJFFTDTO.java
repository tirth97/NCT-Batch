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
public class ImageJFFTDTO extends DataTransferObject{
	/** Input directories. */
	private final String ijfilterInput;
	/** Output directories. */
	private final String ijfilterOutput;
	/** FFT bandpass filter parameters. */
	private final String fftLargeDia, fftSmallDia, fftChoices, fftTolDia, fftScalingDia, fftSaturateDia;
	private final String imageID, imageName;

	public ImageJFFTDTO() {
		super("imagej-fft","/image-filter/??.jar","hadoop.??");
		this.ijfilterInput = null;
		this.ijfilterOutput = null;
		this.fftLargeDia = null;
		this.fftSmallDia = null;
		this.fftChoices = null;
		this.fftTolDia = null;
		this.fftScalingDia = null;
		this.fftSaturateDia = null;
		this.imageID = null;
		this.imageName = null;
	}

	public ImageJFFTDTO(final String inputDir, final String outputDir, 
			final String largeDia, final String smallDia, final String choices, 
			final String tolDia, final String scalingDia, final String saturateDia) {
		super("imagej-fft","/image-filter/??.jar","hadoop.??");
		this.ijfilterInput = inputDir;
		this.ijfilterOutput = outputDir;
		this.fftLargeDia = largeDia;
		this.fftSmallDia = smallDia;
		this.fftChoices = choices;
		this.fftTolDia = tolDia;
		this.fftScalingDia = scalingDia;
		this.fftSaturateDia = saturateDia;
		this.imageID = "0";
		this.imageName = "fft-no-name";
	}

	public ImageJFFTDTO(final String inputDir, final String outputDir, 
			final String largeDia, final String smallDia, final String choices, 
			final String tolDia, final String scalingDia, final String saturateDia, 
			final String imageID, final String imageName) {
		super("imagej-fft","/image-filter/??.jar","hadoop.??");
		this.ijfilterInput = inputDir;
		this.ijfilterOutput = outputDir;
		this.fftLargeDia = largeDia;
		this.fftSmallDia = smallDia;
		this.fftChoices = choices;
		this.fftTolDia = tolDia;
		this.fftScalingDia = scalingDia;
		this.fftSaturateDia = saturateDia;
		this.imageID = imageID;
		this.imageName = imageName;
	}

	public String getInputDir() {
		return ijfilterInput;
	}

	public String getOutputDir() {
		return ijfilterOutput;
	}
	
	public String getLargeDia() {
		return fftLargeDia;
	}
	
	public String getSmallDia() {
		return fftSmallDia;
	}
	
	public String getChoices() {
		return fftChoices;
	}
	
	public String getTolDia() {
		return fftTolDia;
	}
	
	public String getScalingDia() {
		return fftScalingDia;
	}
	
	public String getSaturateDia() {
		return fftSaturateDia;
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
				+ ", largeDia=" + fftLargeDia + ", smallDia=" + fftSmallDia + ", choices=" + fftChoices
				+ ", toleranceDia=" + fftTolDia + ", scalingDia=" + fftScalingDia + ", saturateDia=" + fftSaturateDia + "]";
	}

	@Override
	public String[] getCommandParameters() {
		return new String[] { this.getInputDir(), this.getOutputDir(), this.getLargeDia(), this.getSmallDia(),
			this.getChoices(), this.getTolDia(), this.getScalingDia(), this.getSaturateDia()};
	}
}
