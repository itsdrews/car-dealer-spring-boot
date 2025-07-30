package drew_dev.demo.services;

import java.util.List;

public interface IDataConverter {

    public <T> List<T> getList(String json, Class <T> clazz);
    public <T> T getData(String json, Class<T> clazz);
}
