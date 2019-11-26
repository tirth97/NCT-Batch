package batch.service.dto;

public class RetilingPrereqDTO extends SerialJobDTO{

    public RetilingPrereqDTO(String ftpStackInfoPath, String ftpResultsPath) {
        super("service.RegistrationService","retilingPrereqGenerator");
        this.setjob("retiling-prereq");
        Object [] param = new Object[2];
        param[0] = ftpStackInfoPath;
        param[1] = ftpResultsPath;
        super.setParameters(param);
    }

}
