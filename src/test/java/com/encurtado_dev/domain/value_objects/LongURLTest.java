package com.encurtado_dev.domain.value_objects;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class LongURLTest {
    @Test
    @DisplayName("The long url must be valid")
    public void validUrl() throws Exception {
        LongURL longURL = new LongURL("https://www.google.com");
        Assertions.assertEquals(longURL.getLongUrl(), "https://www.google.com");
    }
    @Test
    @DisplayName("The long url can not be valid")
    public void urlInvalid(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> new LongURL("www.google.com"));
        Assertions.assertEquals("URL inválida. Deve começar com https:// ou http://", exception.getMessage() );
    }

    @Test
    @DisplayName("The long url can not be valid")
    public void urlNull(){
        Exception exception = Assertions.assertThrows(Exception.class, () -> new LongURL(""));
        Assertions.assertEquals("Deve ser fornecida uma URL", exception.getMessage() );
    }
}