package batch.service.dto;

public class RetileDTO extends DataTransferObject {
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

  public RetileDTO() {
    super("retiling");
    this.inputDir = null;
    this.outputDir = null;
    this.origin = null;
    this.tileDim = null;
    this.intensity = null;
  }

  public RetileDTO(String inputDir, String outputDir, String origin, String tileDim, String intensity) {
    super("retiling");
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
    return "RetileDTO [" +
            "inputDir='" + inputDir + '\'' +
            ", outputDir='" + outputDir + '\'' +
            ", origin='" + origin + '\'' +
            ", tileDim='" + tileDim + '\'' +
            ", intensity='" + intensity + '\'' +
            ']';
  }
}
