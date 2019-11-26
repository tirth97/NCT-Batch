package batch.service.dto;

import java.util.Map;

public class StackOverlapsDTO extends SerialJobDTO{

    public StackOverlapsDTO(String ftpStackInfoPath, String ftpResultsPath,
                            Map<String, String> parameters) {
        super("service.RegistrationService","stackOverlaps");
        this.setjob("stack-overlaps");

        Object [] param = new Object[3];
        param[0] = ftpStackInfoPath;
        param[1] = ftpResultsPath;
        param[2] = parameters;

        super.setParameters(param);

        // input parameter is of type HashMap but method sets it as Map
        super.SetParameterClass(Map.class, 2);
    }
    
}
