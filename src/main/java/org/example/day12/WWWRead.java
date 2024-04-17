package org.example.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WWWRead {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://docs.oracle.com/javase/8/docs/api/");
        InputStream urlInput = url.openStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(urlInput));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(msg);
        }
        System.out.println(msg);
    }
}
