package org.example.day05.Dice;

import org.example.day05.Dice.Dice;

public class DiceTest {
    public static void main(String[] args) {
        Dice dice = new Dice();
        int result = dice.roll(6);
        System.out.println("주사위 결과 = " + result);
    }
}