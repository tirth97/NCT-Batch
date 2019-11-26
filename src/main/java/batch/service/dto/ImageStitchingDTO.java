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
 * Defines and contains image stitching job parameters.
 *
 * @author Paurav Patel
 */
public class ImageStitchingDTO extends DataTransferObject{
    /**
     * Input directory.
     */
    private final String inputDir;
    /**
     * Output directory.
     */
    private final String outputDir;
    /**
     * Image Stitching Params
     */
    private final String matchCalculatorClass;
    private final String offset;
    private final String gridDimension;
    private final String k;
    private final String epsilonRange;
    private final String nearestNeighborThresholdDistance;
    private final String nearestNeighborClass;
    private final String bin;

    public ImageStitchingDTO() {
        super("image-stitching","/image-stitching/image-stitching-mr.jar","neu.nctracer.driver.Driver");
        this.inputDir = null;
        this.outputDir = null;
        this.matchCalculatorClass = null;
        this.offset = null;
        this.gridDimension = null;
        this.k = null;
        this.epsilonRange = null;
        this.nearestNeighborThresholdDistance = null;
        this.nearestNeighborClass = null;
        this.bin = null;
    }

    public ImageStitchingDTO(String inputDir, String outputDir, String matchCalculatorClass, String offset,
                             String gridDimension, String k, String epsilonRange,
                             String nearestNeighborThresholdDistance, String nearestNeighborClass, String bin) {
        super("image-stitching","/image-stitching/image-stitching-mr.jar","neu.nctracer.driver.Driver");
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.matchCalculatorClass = matchCalculatorClass;
        this.offset = offset;
        this.gridDimension = gridDimension;
        this.k = k;
        this.epsilonRange = epsilonRange;
        this.nearestNeighborThresholdDistance = nearestNeighborThresholdDistance;
        this.nearestNeighborClass = nearestNeighborClass;
        this.bin = bin;
    }

    public String getInputDir() {
        return inputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public String getMatchCalculatorClass() {
        return matchCalculatorClass;
    }

    public String getOffset() {
        return offset;
    }

    public String getGridDimension() {
        return gridDimension;
    }

    public String getK() {
        return k;
    }

    public String getEpsilonRange() {
        return epsilonRange;
    }

    public String getNearestNeighborThresholdDistance() {
        return nearestNeighborThresholdDistance;
    }

    public String getNearestNeighborClass() {
        return nearestNeighborClass;
    }

    public String getBin() {
        return bin;
    }

    @Override
    public String toString() {
        return "ImageStitchingDTO [" +
                "inputDir='" + inputDir + '\'' +
                ", outputDir='" + outputDir + '\'' +
                ", matchCalculatorClass='" + matchCalculatorClass + '\'' +
                ", offset='" + offset + '\'' +
                ", gridDimension='" + gridDimension + '\'' +
                ", k='" + k + '\'' +
                ", epsilonRange='" + epsilonRange + '\'' +
                ", nearestNeighborThresholdDistance='" + nearestNeighborThresholdDistance + '\'' +
                ", nearestNeighborClass='" + nearestNeighborClass + '\'' +
                ", bin='" + bin + '\'' +
                ']';
    }

    @Override
    public String[] getCommandParameters() {
        return new String[] { this.getInputDir(), this.getOutputDir(), this.getMatchCalculatorClass(),
            this.getOffset(), this.getGridDimension(), this.getK(), this.getEpsilonRange(),
            this.getNearestNeighborThresholdDistance(), this.getNearestNeighborClass(), this.getBin() };
    }
}
