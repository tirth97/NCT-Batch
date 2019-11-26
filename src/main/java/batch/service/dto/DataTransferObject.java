package batch.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author wilson.v@husky.neu.edu
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataTransferObject {
    // unique job token
    private String token;
    // name of the job
    private String job;
    // name of the jar
    private String jar;
    // class name from jar Null if no class name required
    private String className;

    // determine if the current job is an MR Job
    private boolean mapReduceJob;

    public DataTransferObject(){
        mapReduceJob = true;
    }

    public DataTransferObject(String job,String jar,String className){
        this();
        this.job = job;
        this.jar = jar;
        this.className = className;
    }
    
    /**
     * returns true if the current job is an MR JOB else false
     */
    @JsonIgnore
    public boolean isMRJob(){
        return mapReduceJob;
    }

    /**
     * method to state that the current job is not an MR Job.
     */
    public void unsetMRJob(){
        mapReduceJob = false;
    }


    public void setToken(String token){
        this.token = token;
    }

    public void setjob(String job){
        this.job = job;
    }

    public void setJar(String jar){
        this.jar = jar;
    }

    public void setClassName(String className){
        this.className = className;
    }

    public String getToken(){
        return this.token;
    }

    public String getJob(){
        return this.job;
    }

    public String getJar(){
        return this.jar;
    }

    public String getClassName(){
        return this.className;
    }

    // this function is meant to be overidden in all subclasses 
    // TODO make this abstract; make class abstract
    // TechDebt : figure out Jackson and how to serialize/deserialize  abstract classes
    @JsonIgnore
    public String [] getCommandParameters(){
        return null;
    }
}