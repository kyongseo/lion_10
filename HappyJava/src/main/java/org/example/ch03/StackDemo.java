package org.example.ch03;

public class StackDemo {
    public static void main(String[] args) {
        FixedLengthStack stack = new FixedLengthStack(5); // 크기가 5인 스택 생성
        // 스택에 데이터를 푸시합니다.
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            // 스택이 가득 찼으므로, 다음 줄에서 예외가 발생합니다.
            stack.push(6);
        } catch (FixedLengthStack.StackFullException e) {
            System.out.println("스택이 가득 찼습니다.");
        }
        // 스택의 내용을 출력합니다.
        stack.dump();
        // 스택에서 데이터를 팝합니다.
        try {
            System.out.println("팝한 데이터: " + stack.pop());
            System.out.println("팝한 데이터: " + stack.pop());
            System.out.println("팝한 데이터: " + stack.pop());
            // 스택이 비었으므로, 다음 줄에서 예외가 발생합니다.
            System.out.println("팝한 데이터: " + stack.pop());
            System.out.println("팝한 데이터: " + stack.pop());
            System.out.println("팝한 데이터: " + stack.pop());
        } catch (FixedLengthStack.StackEmptyException e) {
            System.out.println("스택이 비어 있습니다.");
        }
    }
}