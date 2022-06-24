package com.unittest.abhi.unittest1.business;


import com.unittest.abhi.unittest1.data.DataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataServiceStub implements DataService {

    @Override
    public int[] retreiveAllData() {
        return new int[] {1,2,3};
    }
}

public class BusinessImplStubTest {

    //Example 2 Via data Service Positive Scenario
    @Test
    public void calculateSumUsingDataServiceBasic(){
        BusinessImpl businessImpl = new BusinessImpl();
        businessImpl.setDataService(new DataServiceStub());
        int actualResult = businessImpl.calculateSumUsingDataService();
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    //Example 2 Via data Service Negative Scenario
    @Test
    public void calculateSumUsingDataServiceEmpty(){
        BusinessImpl businessImpl = new BusinessImpl();
        businessImpl.setDataService(new DataServiceEmptyStub());
        int actualResult = businessImpl.calculateSumUsingDataService();
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    //Example 2
    @Test
    public void calculateSumUsingDataServiceOneValueEmpty(){
        BusinessImpl businessImpl = new BusinessImpl();
        businessImpl.setDataService(new DataServiceOneStub());
        int actualResult = businessImpl.calculateSumUsingDataService();
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
