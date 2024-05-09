package org.example.day10;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class collectionExam2 {

    public static void readScores(Scanner input, List<Integer> scores) throws InputMismatchException {
        while (true) {
            System.out.print("1-100사이의 숫자를 입력하세요(종료 : 0) : ");

            int score = input.nextInt();

            if (score > 100 || score < 0) {
                throw new InputMismatchException("1-100까지의 숫자만 입력하세요. 입력한 점수는 " + score + "입니다.");

            } else if (score == 0) {
                break;
            }
        }
    }


    public static void removeZero(List<Integer> scores) {
        scores.remove(Integer.valueOf(0));
    }

    public static void printScores(List<Integer> scores) {
        System.out.println("입력한 점수 : " + scores);

        int sum = 0;
        for (Integer score : scores) {
            sum += score;
        }
        System.out.println("합계 : " + sum);

        if (!scores.isEmpty()) {
            int average = sum / scores.size();
            System.out.println("평균 : " + average);
        } else {
            System.out.println("점수를 입력해주세요.");
        }
    }

    public static void main(String[] args) {


        try (Scanner input = new Scanner(System.in)) {
            List<Integer> scores = new ArrayList<>();

            // 점수 입력 받기
            readScores(input, scores);

            // 0점 제거
            removeZero(scores);

            // 결과 출력
            printScores(scores);

        } catch (InputMismatchException e) {
            System.out.println("예외 발생: " + e.getMessage());
            e.printStackTrace(); // 에러 스택 트레이스 출력
        }
    }
}


