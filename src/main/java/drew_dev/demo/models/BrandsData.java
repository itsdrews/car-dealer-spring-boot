package drew_dev.demo.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrandsData (@JsonAlias("codigo") String code, @JsonAlias("nome") String name){
}
