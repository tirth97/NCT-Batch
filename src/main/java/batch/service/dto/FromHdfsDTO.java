package batch.service.dto;


public class FromHdfsDTO extends DataTransferObject{
    private String from;
    private String to;

    public FromHdfsDTO(){
        super("from-hdfs");
        this.from = null;
        this.to = null;
    }


    public FromHdfsDTO(String from, String to){
        this();
        this.from = from;
        this.to = to;
    }

    public String getFrom(){
        return this.from;
    }

    public String getTo(){
        return this.to;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FromHDFS [ from : ");
        sb.append(this.from);
        sb.append(", to : ");
        sb.append(this.to);
        sb.append(" ]");

        return sb.toString();
    }
}