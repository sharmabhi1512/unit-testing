package com.unittest.abhi.unittest1.business;

import com.unittest.abhi.unittest1.data.DataService;
import com.unittest.abhi.unittest1.data.ItemRepo;
import com.unittest.abhi.unittest1.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // when using below annotation
    public class BusinessImplMockitoTest {

    @InjectMocks
    BusinessImpl business;
    //BusinessImpl business = new BusinessImpl();

    @Mock
    DataService dataServiceMock;
   // DataService dataServiceMock = mock(DataService.class);


    @BeforeEach
    public void before() {
        business.setDataService(dataServiceMock);
    }

    // Example 2 By creating a mock.
    @Test
    public void calculateSumUsingDataServiceBasic(){
        // When dataServiceMock is called return retreiveAllData new int[] {1,2,3}
        when(dataServiceMock.retreiveAllData()).thenReturn(new int[]{1, 2, 3});
        //business.setDataService(dataServiceMock); //No need, when define inside before method.
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataServiceEmpty(){
        when(dataServiceMock.retreiveAllData()).thenReturn(new int[]{});
        //business.setDataService(dataServiceMock); //No need, when define inside before method.
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataServiceOne(){
        when(dataServiceMock.retreiveAllData()).thenReturn(new int[]{5});
        //business.setDataService(dataServiceMock); //No need,when define inside before method.
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    // Unit Test for Service Layer
    @ExtendWith(MockitoExtension.class)
        public static class ItemBusinessMockTest {

        @InjectMocks
        ItemBusinessService item;
        //BusinessImpl business = new BusinessImpl();

        @Mock
        ItemRepo repo;
       // ItemRepo dataServiceMock = mock(ItemRepo.class);

        @Test
        public void retrieveAllItemFromDatabase(){
            when(repo.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 100),
                    new Item(3, "Item3", 20, 200)));
            List<Item> items = item.retriveAllItem();
            Assertions.assertEquals(1000,items.get(0).getValue());
            Assertions.assertEquals(4000,items.get(1).getValue());
         }

    }
}
