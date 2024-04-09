package org.example.day07.Parent;

abstract public class 새 {
    /**
     * 기능의 표준화
     * 강제성 (반드시 메서드를 구현해야 함)
     */
    abstract public void 노래하다();

    class 비둘기 extends 새{
        @Override
        public void 노래하다(){
            System.out.println("구구");
        }
    }
    class 참새 extends 새{
        @Override
        public void 노래하다(){
            System.out.println("짹짹");
        }
    }

    /**
     * 추상 클래스를 상속받은 앵무새를 추상클래스로 만들기
     */
    abstract class 앵무새 extends 새{

        // 추상메서드
        abstract public void 말하다();
    }

    class 코뉴어 extends 앵무새{

        @Override
        public void 노래하다() {
            System.out.println("랄라");
        }

        @Override
        public void 말하다() {
            System.out.println("앵무앵무");
        }
    }
}
