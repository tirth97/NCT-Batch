package batch.util;


/**
 * POJO class to construct JMS messages 
 * @author wilson.v@husky.neu.edu
 */
public class JMSMessage {
    // unique job ID token
    private String token;
    private String message;
    private statusValues status;

    public enum statusValues{
        ERROR,
        SUCCESS,
        UNKNOWN
    };

    public JMSMessage(){}

    public JMSMessage(String token, String message,statusValues status){
        this.token = token;
        this.message = message;
        this.status = status;
    }


    public statusValues getStatus(){
        return this.status;
    }

    public void setStatus(statusValues status){
        this.status = status;
    }

    public String getToken(){
        return this.token;
    }

    public String getMessage(){
        return this.message;
    }

    public void setToken(String token){
        this.token = token;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
}