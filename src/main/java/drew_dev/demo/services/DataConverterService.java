package drew_dev.demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

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

    @Override
    public <T>List<T> getList(String json, Class<T> clazz) {
        try {
             CollectionType list = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
             return objectMapper.readValue(json, list);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
