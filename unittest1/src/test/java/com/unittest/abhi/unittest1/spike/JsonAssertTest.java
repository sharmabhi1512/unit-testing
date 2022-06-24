package com.unittest.abhi.unittest1.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class JsonAssertTest {

    @Autowired
    private MockMvc mockMvc;
    String actual = "{\"id\":1,\"name\":\"Abhi\",\"price\":10,\"quantity\":100}";
    String actual2 = "{\"id\":1,\"name\":\"Abhi\"}";
    @Test
    public void jsonAssert() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Abhi\",\"price\":10,\"quantity\":100}";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void jsonAssertStrictFalse() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Abhi\",\"price\":10,\"quantity\":100}";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void jsonAssertWithoutEscapeChar() throws JSONException {
        String expected = "{id:1,name:Abhi}";
        Assertions.assertEquals(expected, actual2);
    }

    @Test
    public void jsonAssertWithoutEscapeCharNegative() throws JSONException {
        String expected = "{\"id\":1,\"name\":\"Abhi \"}";
        Assertions.assertEquals(expected, actual2);
    }
}
