package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    void subString(){
        String str = "abcdefg";
        assertEquals("cd",str.substring(2,4));
    }
}
