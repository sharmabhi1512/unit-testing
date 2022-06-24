package com.unittest.abhi.unittest1.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonPathTest {

    @Test
    public void learning(){
        String res = "[" +
                "{\"id\":1000, \"name\":\"Pen\",\"quanity\":5}," +
                "{\"id\":1002, \"name\":\"Pencil\",\"quanity\":25}," +
                "{\"id\":1003, \"name\":\"Eraser\",\"quanity\":15}" +
                "]";
        DocumentContext context = JsonPath.parse(res);
        int len = context.read("$.length()");
        Assertions.assertThat(len).isEqualTo(3);

        System.out.println(context.read("$..id").toString());
    }

}
