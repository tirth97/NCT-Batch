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
 * Defines and contains Zoom Level job parameters.
 *
 * @author wilson.v@husky.neu.edu
 */
public class ZoomLevelDTO extends DataTransferObject {
   // input directory
    private  String inputDir;
    // output directory
    private  String outputDir;
    // global tile origin 
    private  String origin;
    // dimentions of input tiles
    private  String tileDim;
    // dummy tile pixel intensity
    private  String intensity;

    public ZoomLevelDTO(){
        super("zoom-level");
        this.inputDir = null;
        this.outputDir = null;
        this.origin = null;
        this.tileDim = null;
        this.intensity = null;
    }

    public ZoomLevelDTO(String inputDir, String outputDir,String origin,String tileDim,String intensity) {
        super("zoom-level");
        this.inputDir = inputDir;
        this.outputDir = outputDir;
        this.origin = origin;
        this.tileDim = tileDim;
        this.intensity = intensity;
    }

    public String getInputDir() {
        return inputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public String getOrigin() {
        return origin;
    }

    public String getTileDim() {
        return tileDim;
    }
    
    public String getIntensity() {
        return intensity;
    }

    @Override
    public String toString() {
        return "ZoomLevelDTO [" +
                "inputDir='" + inputDir + '\'' +
                ", outputDir='" + outputDir + '\'' +
                ", origin='" + origin + '\'' +
                ", tileDim='" + tileDim + '\'' +
                ", intensity='" + intensity + '\'' +
                ']';
    }
}
