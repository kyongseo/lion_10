package org.example.day05.Lotto;

public class LottoUser {
    public static void main(String[] args) {
        LottoMachine lotto = new LottoMachine();
        lotto.mix();
        for (int i = 0 ; i < 6; i++){
            Ball ball = lotto.getBall();
            System.out.println(ball.number);
        }
    }
}
