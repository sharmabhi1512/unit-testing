package com.unittest.abhi.unittest1.integrationtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoadsIT() {
        String forObject = this.restTemplate.getForObject("/all-item-from-database", String.class);

        Assertions.assertEquals("[{\"id\":10001,\"name\":\"Item1\",\"price\":10,\"quantity\":20,\"value\":200},{\"id\":10002,\"name\":\"Item2\",\"price\":5,\"quantity\":10,\"value\":50},{\"id\":10003,\"name\":\"Item3\",\"price\":15,\"quantity\":2,\"value\":30}]", forObject);
    }
}
