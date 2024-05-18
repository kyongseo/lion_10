package org.example.멋사10기.study.collection;

import java.util.*;

public class ListExam {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        list.add("park");
//        list.add("china");
//        list.add("park");
//
//        System.out.println(list.size());
//        System.out.println(list);

        Map<String ,Integer> map = new HashMap<>();
        map.put("001",10);
        map.put("002",20);

        Set<String > keys = map.keySet();

        Iterator<String> iter= keys.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            Integer value = map.get(key);
            System.out.println(key+":"+value);
        }
    }
}