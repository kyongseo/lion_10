package org.example.day05.Dice;

public class Dice2 {

    // 생성자 - 객체가 처음 생성될 대 초기화 할 수 있는 메서드
    // 접근제한자 메소드명() { 구 } => 리턴타입 없음, 메서드명은 클래스명과 동일
    public int face = 6;
    public int eye;

    public Dice2(int face){
        System.out.println("Dice2(int face) 실행");
        this.face = face;
    }

    public Dice2(){
   //     this.face = 6;
        this(6);
        System.out.println("Dice2() 실행");
    }

    //행위 - 주사위를 굴리다.  roll
    public void roll(){
        //주사위를 굴렸을 때 어떤 일을 해야할지??
        eye = (int)(Math.random()*face) + 1;
    }
}



