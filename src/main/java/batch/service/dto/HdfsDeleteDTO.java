package batch.service.dto;

public class HdfsDeleteDTO extends DataTransferObject {
  private String from;

  public HdfsDeleteDTO(){
    super("hdfs-delete","/hdfs-helper/hdfs-helper-all.jar",null);
    this.from = null;
  }

  public HdfsDeleteDTO(String from){
    this();
    this.from = from;
  }

  public String getFrom(){
    return this.from;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Delete HDFS [ from : ");
    sb.append(this.from);
    sb.append(" ]");

    return sb.toString();
  }

  @Override
  public String[] getCommandParameters() {
    return new String[] {"hdfsDelete",this.getFrom()};
  }
}
