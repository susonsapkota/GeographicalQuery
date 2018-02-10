package com.googletest.main;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;


public class GoogleURL {


    public void downloadMap(String nameOfPlace) {
        try {

                String urlOfImage = "https://maps.googleapis.com/maps/api/staticmap?size=640x440&zoom=15&center=" +
                        URLEncoder.encode(nameOfPlace,"UTF-8") + "&scale=2&region=NP";

                URL url = new URL(urlOfImage);
                InputStream is = url.openStream();
                OutputStream os = new FileOutputStream(nameOfPlace);

                byte[] b = new byte[2048];
                int length;
                while ((length = is.read(b)) != -1) {
                    os.write(b, 0, length);

                }
                is.close();
                os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageIcon getIcon(String nameOfPlace) {
        return new ImageIcon((new ImageIcon(nameOfPlace)).getImage().getScaledInstance(640, 640, Image.SCALE_SMOOTH));
    }

    public void deleteFile(String fileName) {
        File f = new File(fileName);
        f.delete();
    }
}
