package org.example.ch04;

public class MyStack {
    private int maxSize; // 스택의 최대 크기
    private int[] stackArray; // 스택을 저장하는 배열
    private int top; // 스택의 가장 위를 가리키는 포인터

    // 생성자: 스택의 최대 크기를 인자로 받아 초기화
    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1; // 스택이 비어있음을 나타내는 초기값
    }

    // 스택에 데이터를 추가하는 메소드
    public void push(int data) {
        if (isFull()) {
            System.out.println("스택이 가득 찼습니다.");
            return;
        }else{
            stackArray[++top] = data; // 스택에 데이터를 추가하고 top을 증가시킴
        }
    }

    // 스택에서 데이터를 제거하고 반환하는 메소드
    public int pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1; // 임의의 값으로 처리
        }else {
            return stackArray[top--]; // 스택에서 데이터를 제거하고 top을 감소시킴
        }
    }

    // 스택이 비어있는지 확인하는 메소드, boolean 타입
    public boolean isEmpty() {
        return (top == -1);
    }

    // 스택이 가득 찼는지 확인하는 메소드, boolean 타입
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // 스택의 가장 위에 있는 데이터를 반환하는 메소드(삭제하지 않음)
    public int peek() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1; // 임의의 값으로 처리
        } else{
            return stackArray[top]; // 스택의 가장 위에 있는 데이터를 반환
        }
    }

    // 테스트를 위한 메인 메소드
    public static void main(String[] args) {
        MyStack stack = new MyStack(5); // 최대 크기가 5인 스택 생성

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("가장 위에 있는 데이터: " + stack.peek()); // 4

        stack.pop(); // 4
        stack.pop(); // 3
        System.out.println("가장 위에 있는 데이터: " + stack.peek()); // 2
        stack.pop(); // 2
        stack.pop(); // 1
        System.out.println("가장 위에 있는 데이터: " + stack.peek()); // -1
    }
}