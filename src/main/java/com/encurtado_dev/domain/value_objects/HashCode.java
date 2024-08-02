package com.encurtado_dev.domain.value_objects;
import org.apache.commons.lang3.RandomStringUtils;

public class HashCode {

    private String hashCode;
    public HashCode(){
        this.hashCode = this.generateHash();
    }
    private String generateHash(){
        String hash = RandomStringUtils.randomAlphanumeric(5,10);
        return hash;
    }
    public String getHashCode(){
        return this.hashCode;
    }
}
