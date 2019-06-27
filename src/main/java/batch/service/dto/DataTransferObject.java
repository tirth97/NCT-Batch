package batch.service.dto;

import org.apache.htrace.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author wilson.v@husky.neu.edu
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTransferObject {
    // unique job token
    private String token;
    // name of the job
    private String job;

    public DataTransferObject(){}

    public DataTransferObject(String job){
        this.job = job;
    }

    public void setToken(String token){
        this.token = token;
    }

    public void setjob(String job){
        this.job = job;
    }

    public String getToken(){
        return this.token;
    }

    public String getJob(){
        return this.job;
    }
}