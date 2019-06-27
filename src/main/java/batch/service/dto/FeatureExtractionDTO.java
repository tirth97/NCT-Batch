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
 * Defines and contains feature extraction job parameters.
 *
 * @author Paurav Patel
 */
public class FeatureExtractionDTO extends DataTransferObject{
    /**
     * Input directory.
     */
    private final String inputDir;
    /**
     * Output directory.
     */
    private final String outputDir;
    /**
     * Feature Extraction Params
     */
    private final String featureFilterClass;
    private final String featureNeighborhoodSize;
    private final String featureThreshold;
    private final String featureScalingFactor;

    public FeatureExtractionDTO() {
        super("feature-extraction");
        this.inputDir = null;
        this.outputDir = null;
        this.featureFilterClass = null;
        this.featureNeighborhoodSize = null;
        this.featureThreshold = null;
        this.featureScalingFactor = null;
    }


    public FeatureExtractionDTO(final String inputDir, final String outputDir, final String featureFilterClass,
                                final String featureNeighborhoodSize, final String featureScalingFactor, final String featureThreshold) {
        super("feature-extraction");
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.featureFilterClass = featureFilterClass;
        this.featureNeighborhoodSize = featureNeighborhoodSize;
        this.featureScalingFactor = featureScalingFactor;
        this.featureThreshold = featureScalingFactor;
    }

    public String getInputDir() {
        return inputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public String getFeatureFilterClass() {
        return featureFilterClass;
    }

    public String getFeatureNeighborhoodSize() {
        return featureNeighborhoodSize;
    }

    public String getFeatureScalingFactor() {
        return featureScalingFactor;
    }

    public String getFeatureThreshold() {
        return featureThreshold;
    }

    @Override
    public String toString() {
        return "FeatureExtractionDTO [" +
                "inputDir='" + inputDir + '\'' +
                ", outputDir='" + outputDir + '\'' +
                ", featureFilterClass='" + featureFilterClass + '\'' +
                ", featureNeighborhoodSize='" + featureNeighborhoodSize + '\'' +
                ", featureThreshold='" + featureThreshold + '\'' +
                ", featureScalingFactor='" + featureScalingFactor + '\'' +
                ']';
    }
}
