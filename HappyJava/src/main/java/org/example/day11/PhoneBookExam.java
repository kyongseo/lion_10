package org.example.day11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PhoneBookExam {
    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("김철수", "010-1111-2222");
        phoneBook.put("박영희", "010-3333-4444");
        phoneBook.put("김민지", "010-5555-6666");
        phoneBook.put("이영호", "010-7777-8888");

        String minjiNumber = phoneBook.get("김민지");
        System.out.println("김민지의 전화번호 : " + minjiNumber);


        Set<String> keySet = phoneBook.keySet();
        System.out.println("키의 값 : " + keySet);


        Iterator<String> keyIter = keySet.iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            System.out.println(key);
            System.out.println(phoneBook.get(key));
        }
        System.out.println("======================");

        // 전체 목록 출력
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("==========================");

        //데이터 삭제
        System.out.println(phoneBook);
        phoneBook.remove("박영희");
        System.out.println(phoneBook);

        //특정 키 존재 여부 확인
        if (phoneBook.containsKey("박영희")){
            System.out.println("박영희가 있습니다.");
        } else {
            System.out.println("박영희는 없습니다.");
        }

        // 특정 값 존재 여부 확인
        if (phoneBook.containsValue("010-1111-2222")){
            System.out.println(phoneBook.get("김철수"));
        }

        //map이 비었는지 확인
        if (phoneBook.isEmpty()) {
            System.out.println("비었습니다.");
        }
        System.out.println("있습니다.");
    }
}
