package batch.service.dto;

public class RetileDTO extends DataTransferObject {
  // input directory for stack images
  private  String inputStackDir;
  // input directory
  private  String inputCsvDir;
  // output directory
  private  String outputDir;
  // dimensions of input tiles
  private  String tileDim;
  // dummy tile pixel intensity
  private  String intensity;

  public RetileDTO() {
    super("retiling");
    this.inputStackDir = null;
    this.inputCsvDir = null;
    this.outputDir = null;
    this.tileDim = null;
    this.intensity = null;
  }

  public RetileDTO(String inputStackDir, String inputCsvDir, String outputDir, String tileDim,
                   String intensity) {
    super("retiling");
    this.inputStackDir = inputStackDir;
    this.inputCsvDir = inputCsvDir;
    this.outputDir = outputDir;
    this.tileDim = tileDim;
    this.intensity = intensity;
  }

  public String getInputStackDir() {
    return inputStackDir;
  }

  public String getInputCsvDir() {
    return inputCsvDir;
  }

  public String getOutputDir() {
    return outputDir;
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
            "inputStackDir='" + inputStackDir + '\'' +
            ", inputCsvDir='" + inputCsvDir + '\'' +
            ", outputDir='" + outputDir + '\'' +
            ", tileDim='" + tileDim + '\'' +
            ", intensity='" + intensity + '\'' +
            ']';
  }
}
