package com.encurtado_dev.domain.value_objects;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class HashCodeTest {

    @Test
    @DisplayName("Shoud be create a new hash code")
    public void createHash(){
        HashCode hashCode = new HashCode();
        Assertions.assertNotNull(hashCode.getHashCode());
    }
    @Test
    @DisplayName("Hash length should be greater than 5 and less than 10")
    public void lengthHash(){
        HashCode hashCode = new HashCode();
        int length = hashCode.getHashCode().length();
        Assertions.assertTrue(length >= 5 && length <= 10);
    }
}