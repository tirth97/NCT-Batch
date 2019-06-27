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
public class MatrixMultDTO extends DataTransferObject {

	/** Input directories. */
	private final String inputDir1;
	private final String inputDir2;
	/** Output directories. */
	private final String intermResultDir;
	private final String outputDir;
	/** properties file */
	private final String propFile;


	public MatrixMultDTO() {
		super("matrix-mult");
		this.inputDir1 = null;
		this.inputDir2 = null;
		this.intermResultDir = null;
		this.outputDir = null;
		this.propFile = null;
	}

	public MatrixMultDTO(final String inputDir1, final String inputDir2, 
			final String intermResultDir, final String outputDir, final String propFile) {
		super("matrix-mult");
		this.inputDir1 = inputDir1;
		this.inputDir2 = inputDir2;
		this.intermResultDir = intermResultDir;
		this.outputDir = outputDir;
		this.propFile = propFile;
	}

	public String getInputDir1() {
		return inputDir1;
	}

	public String getInputDir2() {
		return inputDir2;
	}
	
	public String getIntermResultDir() {
		return intermResultDir;
	}

	public String getOutputDir() {
		return outputDir;
	}
	
	public String getPropFile() {
		return propFile;
	}

	@Override
	public String toString() {
		return "MatrixMultDTO [inputDirs=" + inputDir1 + "," + inputDir2 
				+ ", outputDirs=" + intermResultDir + "," + outputDir
				+ ", propFile=" + propFile + "]";
	}
}
