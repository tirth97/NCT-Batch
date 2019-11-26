package batch.service.dto;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Mapper class to return the right subclass Object of DataTransferObject
 * singleton class prevents creating multiple copies of the hashmap in memory.
 * 
 * @author wilson.v@husky.neu.edu 
 */
public  class DtoMapper{
    private  ObjectMapper obj;
    private  static HashMap<String,Class<?>> classMap;
    private static DtoMapper mapper = null;

    private DtoMapper(){
        obj = new ObjectMapper();
        classMap = new HashMap<String,Class<?>>();

        classMap.put("word-count", WordCountDTO.class);
        classMap.put("matrix-mult", MatrixMultDTO.class);
        classMap.put("feature-extraction",FeatureExtractionDTO.class);
        classMap.put("zoom-level", ZoomLevelDTO.class);
        classMap.put("to-hdfs", ToHdfsDTO.class);
        classMap.put("from-hdfs", FromHdfsDTO.class);
        classMap.put("hdfs-copy", HdfsCopyDTO.class);
        classMap.put("hdfs-delete", HdfsDeleteDTO.class);
        classMap.put("retiling", RetileDTO.class);
        classMap.put("image-stitching", ImageStitchingDTO.class);
        classMap.put("imagej-gaussian", ImageJGaussianDTO.class);
        classMap.put("imagej-fft", ImageJFFTDTO.class);
        classMap.put("imagej-threshold", null);
        classMap.put("imagej-gaussian-db", ImageJGaussianDTO.class);
        classMap.put("imagej-fft-db", ImageJFFTDTO.class);
        classMap.put("imagej-threshold-db", ImageJThresholdDTO.class);
        classMap.put("matlab-gaussian-db", MatlabGaussianDTO.class);
        classMap.put("matlab-gaussian", MatlabGaussianDTO.class);
        classMap.put("feature-extract-match", FeatureExtractMatchDTO.class);
        classMap.put("kill-job",KillJobDTO.class);

    }

    public static DtoMapper getInstance(){
        if(mapper == null){
            mapper = new DtoMapper();
        }
        return mapper;
    }

    /**
     * Returns an object of the subclass of DataTransferObject
     * Note : only this function needs to be modified when a new DTO is added
     * @param dto
     * @param request
     * @return subclass object of dto 
     */
    public DataTransferObject getSubClassObject(String request){
        try{
            DataTransferObject dto = obj.readValue(request,DataTransferObject.class);
            return (DataTransferObject) obj.readValue(request, classMap.get(dto.getJob()));

        }catch(IOException e){
            e.printStackTrace();
        }  
        return null;
    }
}