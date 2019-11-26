package batch.service.dto;

public class InsertDatasetDTO extends SerialJobDTO {
  public InsertDatasetDTO(String datasetName, String path, String coordsPath, String tileDim) {
    super("service.RegistrationService","insertDataset");

    Object [] param = new Object[4];
    param[0] = datasetName;
    param[1] = path;
    param[2] = coordsPath;
    param[3] = tileDim;

    super.setParameters(param);
  }
}
