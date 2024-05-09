package org.example.day12;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class ByteStreamExam2 {
    public static void main(String[] args) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("date.txt"));
        ){
            out.writeInt(100);
            out.writeBoolean(true);
            out.writeDouble(50.5);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
