package drew_dev.demo.services;

public interface IDataConverter {

    public <T> T getData(String json, Class<T> clazz);
}
