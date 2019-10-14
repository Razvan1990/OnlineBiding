package com.sda.auction.util;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class ImageUtil {

    public static byte[] getByteArray(Blob image) throws SQLException {

        int blobLength = (int) image.length();
        //metoda de returnat ca vector
        return image.getBytes(1, blobLength);
    }



    public static Blob toBlob(MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            byte[] imageByteArray = new byte[0];
            try {
                imageByteArray = multipartFile.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Blob image = BlobProxy.generateProxy(imageByteArray);
            return image;
        }
        return null;
    }
}
