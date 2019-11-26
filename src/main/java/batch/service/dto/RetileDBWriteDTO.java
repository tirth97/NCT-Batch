package batch.service.dto;

public class RetileDBWriteDTO extends SerialJobDTO{

    public RetileDBWriteDTO(String outputFilename,String tilePath,int x, int y, int z) {
        super("service.RegistrationService","writeRetileOutputToDB");
        
        Object [] param = new Object[5];
        param[0] = outputFilename;
        param[1] = tilePath;
        param[2] = x;
        param[3] = y;
        param[4] = z;

        super.setParameters(param);
    }

}
