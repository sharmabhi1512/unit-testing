package com.unittest.abhi.unittest1.business;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BusinessImplTest {

    // Example 1
    @Test
    public void calculateBasicSenario(){
        BusinessImpl businessImpl = new BusinessImpl();
        int actualResult = businessImpl.calculateSum(new int[] {1,2,3,4,5});
        int expectedResult = 15;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumEmpty(){
        BusinessImpl businessImpl = new BusinessImpl();
        int actualResult = businessImpl.calculateSum(new int[] {});
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
