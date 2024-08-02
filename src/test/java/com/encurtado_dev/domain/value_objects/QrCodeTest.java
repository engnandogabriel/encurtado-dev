package com.encurtado_dev.domain.value_objects;

import com.google.zxing.WriterException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class QrCodeTest {
    @Test
    @DisplayName("Should be created QrCode")
    public void createQrCode() throws IOException, WriterException {
        QrCode qrCode = new QrCode("www.instagram.com/nando_gabriel10");
        System.out.println(qrCode.getQrCode());
        Assertions.assertNotNull(qrCode.getQrCode());
    }
}