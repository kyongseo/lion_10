package org.example.day05.Dice;

import java.util.Random;

public class Dice {
    public int face = 6;
    public Random random = new Random();
    public int roll(int face){
        int rand = random.nextInt(face) + 1;
        return rand;
    }
}