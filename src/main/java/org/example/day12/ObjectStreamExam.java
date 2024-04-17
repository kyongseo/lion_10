package org.example.day12;

import java.io.*;

public class ObjectStreamExam {
    public static void main(String[] args) {
        /**
         * 객체를 파일에 저장
         */
        // // 직렬화
        //m = new Member("hong", 20);
        //ObjectOutputStream oos = null;
        //oos = new ObjectOutputStream(new FileOutputStream("object.ser")); // 두번째 인자로 true를 주면 덮어쓰기
        //oos.writeObject(m);

//
//        Person person =new Person("park", 23);
//        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"));){
//            out.writeObject(person);
//        }catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         *  파일에서 객체 가져오기
         */
        // // 반직렬화
        //ObjectInputStream ols = null;
        //ols = new ObjectInputStream(new FileInputStream("object.ser"));
        //m = (Member) ols.readObject();

        Person readPerson = null;
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream("person.dat"));) {
            readPerson = (Person) in.readObject();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(readPerson);
        System.out.println(readPerson.getName());

        readPerson.setAge(40);
        System.out.println(readPerson.getAge());

    }
}
