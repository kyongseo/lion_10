package org.example.day17;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        int sum = numbers.stream().reduce(0,(a,b)-> a+b);
        System.out.println(sum);

        List<Member> members = Arrays.asList(
                new Member("박경서",100),
                new Member("신짱구",90),
                new Member("이훈이",80),
                new Member("김맹구",70)
        );

        // Member 들의 score 총합을 구해봅시다.
        int memberScoreSum = members.stream().mapToInt(Member::getScore).sum();
        System.out.println(memberScoreSum);

        int memberScoreSum2 = members.stream().mapToInt(Member::getScore).reduce(0, (a,b)-> a+b);
        System.out.println(memberScoreSum2);


    }
}
