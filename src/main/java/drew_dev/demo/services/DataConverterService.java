package drew_dev.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverterService implements IDataConverter {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public <T> T getData(String json, Class<T> clazz) {
        try{
            return objectMapper.readValue(json,clazz);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
