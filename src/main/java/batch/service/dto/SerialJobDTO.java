package batch.service.dto;

/**
 * SerialJobDTO : store information about serial jobs 
 * @author wilson.v@husky.neu.edu
 */
public class SerialJobDTO extends DataTransferObject{
    private String className;
    private String methodName;
    private Class<?>[] parameterClasses;
    private Object[] parameters;


    public SerialJobDTO(String className,String methodName){
        this.unsetMRJob();
        this.className = className;
        this.methodName = methodName;
        this.parameterClasses = null;
        this.parameters = null;
    }

    public void SetParameterClass(Class<?> cls,int index){
        if(index < parameterClasses.length){
            parameterClasses[index] = cls;
        }
    }

    public void setParameters(Object [] parameters){
        this.parameters = parameters;
        this.parameterClasses = new Class[parameters.length];
        for(int i = 0; i < parameters.length; i++){
            parameterClasses[i] = parameters[i].getClass();
        }
    }
    
    public String getClassName(){
        return this.className;
    }

    public String getMethodName(){
        return this.methodName;
    }

    public Class<?> [] getParameterClasses(){
        return this.parameterClasses;
    }

    public Object[] getParameters(){
        return this.parameters;
    }

    @Override
    public String[] getCommandParameters() {
        return null;
    }
}