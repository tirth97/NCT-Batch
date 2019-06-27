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
 * Defines and contains word count job parameters.
 * @author Joseph Sackett
 */
public class WordCountDTO extends DataTransferObject { 
	/** Input directory. */
	private final String inputDir;
	/** Output directory. */
	private final String outputDir;

	public WordCountDTO() {
		super("word-count");
		this.inputDir = null;
		this.outputDir = null;
	}

	public WordCountDTO(final String inputDir, final String outputDir) {
		super("word-count");
		this.inputDir = inputDir;
		this.outputDir = outputDir;
	}

	public String getInputDir() {
		return inputDir;
	}

	public String getOutputDir() {
		return outputDir;
	}

	@Override
	public String toString() {
		return "WordCountDTO [inputDir=" + inputDir + ", outputDir=" + outputDir + "]";
	}
}
