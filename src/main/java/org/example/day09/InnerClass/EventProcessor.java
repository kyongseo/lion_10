package org.example.day09.InnerClass;

import org.w3c.dom.ls.LSOutput;

import java.beans.EventHandler;

public class EventProcessor {
    public void processEvent(String event){
        class EventHandler {
            public void handle(){
                System.out.println("현재 실행 중인 이벤트 : " + event);
            }
        }
        EventHandler handler = new EventHandler();
        handler.handle();
    }

    public static void main(String[] args) {
        EventProcessor Processor = new EventProcessor();
        Processor.processEvent("abcd");

    }
}
