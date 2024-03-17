package org.camel.demo;

import org.apache.camel.ProducerTemplate;
import org.junit.jupiter.api.Test;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MySpringBootApplication.class, properties = {"camel.hello.enabled =true"})
@CamelSpringBootTest
@MockEndpoints()
public class HelloRouteTest {

    @Autowired
    private ProducerTemplate producerTemplate;
    @Test
    public void testMockAreValid(){
        System.out.println("sending 1");
        producerTemplate.sendBody("direct:greeting", "Team");
        System.out.println("sending 2");
        producerTemplate.sendBody("direct:greeting", "Me");

    }


}

