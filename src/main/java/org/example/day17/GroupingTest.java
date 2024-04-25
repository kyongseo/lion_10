package org.example.day17;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingTest {
    public static void main(String[] args) {
        List<Member> memberList = Arrays.asList(
                new Member("Park",22,Member.FEMALE),
                new Member("Kim",30,Member.MALE),
                new Member("Lee",40,Member.FEMALE)
        );

        Map<Integer, List<Member>> mapBySex = memberList.stream()
                .collect(Collectors.groupingBy(Member::getSex));

        System.out.println("남자");
        mapBySex.get(Member.MALE).stream().forEach(member -> System.out.println(member.getName()));

        System.out.println("여자");
        mapBySex.get(Member.FEMALE).stream().forEach(member -> System.out.println(member.getName()));

        System.out.println("==================");
        for (Member member : memberList) {

            System.out.print(member.getName() + ", " );
            System.out.println(member.getAge());
        }

        System.out.println("===========================");
        System.out.println(memberList.toString());
    }
}
