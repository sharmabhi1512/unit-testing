package com.unittest.abhi.unittest1.data;

import com.unittest.abhi.unittest1.business.ItemBusinessService;
import com.unittest.abhi.unittest1.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@DataJdbcTest // using when writing test case for repository
    public class ItemDataMockTest {

    @Mock
    ItemRepo repo;

    @Test
    public void testFindAll(){
        when(repo.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 100),
                new Item(3, "Item3", 20, 200)));
        //business.setDataService(dataServiceMock); //No need, when define inside before method.
        List<Item> items = repo.findAll();
        Assertions.assertEquals(3,items.size());
     }

}
