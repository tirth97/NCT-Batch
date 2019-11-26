package batch.service.dto;

import java.util.Map;

/**
 * DTO class for running GlobalTransform serial job
 * @author wilson.v@husky.neu.edu
 */
public class GlobalTransformDTO extends SerialJobDTO{

    public GlobalTransformDTO(String ftpPath,String ftpOutputDir,String localOutputDir,
                              Map<String,String> parameters, Integer userID) {
        super("service.RegistrationService","globalTransform");
        this.setjob("global-transform");
        Object [] param = new Object[5];
        param[0] = ftpPath;
        param[1] = ftpOutputDir;
        param[2] = localOutputDir;
        param[3] = parameters;
        param[4] = userID;

        super.setParameters(param);
        
        // input parameter is of type HashMap but method sets it as Map
        super.SetParameterClass(Map.class, 3);
    }
    
    
}
