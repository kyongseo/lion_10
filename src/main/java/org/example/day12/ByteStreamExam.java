package org.example.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExam {

    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("src/main/java/org/example/day12/ByteStreamExam.java");
            out = new FileOutputStream("a.txt");

            int c = -1;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
