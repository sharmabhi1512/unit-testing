package com.unittest.abhi.unittest1.spike;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HamcrestMatcherTest {
    @Test
    public void learning(){
        List<Integer> num = Arrays.asList(12, 15, 45);
        //This is for Hamcrest lib
        //assertThat(num, hasSize(3);
        //assertThat(num, hasItem(12, 15);
        //assertThat(num, everyItem(greaterThan(10)));
        //assertThat(num, everyItem(lessThan(100)));
        //This is for assertJ lib
        Assertions.assertThat(num).hasSize(3).contains(12, 15, 45);
        Assertions.assertThat(num).hasSize(3).contains(12, 15, 45).allMatch(x ->x >10).allMatch(x ->x <100);

    }
}
