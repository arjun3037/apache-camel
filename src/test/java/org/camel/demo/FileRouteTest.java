package org.camel.demo;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpoints;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest(classes = MySpringBootApplication.class, properties = {"camel.hello.enabled=true"})
@CamelSpringBootTest
@MockEndpoints
public class FileRouteTest{

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void testFileRoute(){

        System.out.println("Sending first message");
        producerTemplate.sendBody("direct:fileWriter" ,"Hello" + new Date());
        System.out.println("Sending second message");
        producerTemplate.sendBody("direct:fileWriter" ,"This is appended" + new Date());


    }



}
