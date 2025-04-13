package com.estsoft.demo;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertJTest {
    @Test
    public void test() {
        int a = 3;
        int b = 1;

        int result = 4;

        assertThat(a + b).isEqualTo(result);
    }
}
