package batch.service.dto;

public class StorageTransferDTO extends SerialJobDTO {
  public StorageTransferDTO() {
    super("service.StorageTransferService","localToHDFS");
    this.setjob("global-transform");
  }
}
