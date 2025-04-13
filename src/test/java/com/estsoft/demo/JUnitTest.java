package com.estsoft.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnitTest {
    @Test
    public void addTest(){
    int a = 1;
    int b = 2;
    int sum = 4;

    Assertions.assertEquals(sum, a + b);

    }

}
