package com.encurtado_dev.domain.value_objects;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class QrCode {
    private String qrCode;

    public QrCode(String url) throws IOException, WriterException {
            this.qrCode = this.generate(url);
    }
    private String generate(String url) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 150, 150);

        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);

        byte[] qrCodeBytes = byteArrayOutputStream.toByteArray();
        String base64QRCode = Base64.getEncoder().encodeToString(qrCodeBytes);
        return base64QRCode;
    }

    public String getQrCode() {
        return this.qrCode;
    }
}
