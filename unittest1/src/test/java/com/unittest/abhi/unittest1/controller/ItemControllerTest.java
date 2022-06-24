package com.unittest.abhi.unittest1.controller;

import com.unittest.abhi.unittest1.business.BusinessImpl;
import com.unittest.abhi.unittest1.business.ItemBusinessService;
import com.unittest.abhi.unittest1.model.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;
    String expected = "{\"id\":1,\"name\":\"Abhi\",\"price\":10,\"quantity\":100}";

    @MockBean
    private BusinessImpl business;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);

        // For String data this will give error if data is not proper or we have extra space
        MvcResult resultString = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"Abhi\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        // For Json data
        MvcResult resultJson = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Abhi\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        //Assertions.assertEquals(expected, resultJson.getResponse().getContentAsString());
    }

    @Test
    public void dummyItem_fromService() throws Exception {

        Mockito.when(itemBusinessService.retreiveHardCodedItem()).thenReturn(new Item(2, "Item2", 10, 100));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{id:2,name:Item2,price:10,quantity:100}"))
                .andReturn();

        //Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void dummyItem_fromDatabase() throws Exception {

        Mockito.when(itemBusinessService.retriveAllItem()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 100),
                new Item(3, "Item3", 10, 100)));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/all-item-from-database").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{id:2,name:Item2,price:10,quantity:100}, {id:3,name:Item2,price:10,quantity:100}]"))
                .andReturn();

        //Assertions.assertEquals(expected, result.getResponse().getContentAsString());
    }


}
