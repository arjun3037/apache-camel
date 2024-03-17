package org.camel.demo.route;

import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "camel.hello.enabled" , havingValue = "true")
public class FileHandleRoute extends RouteBuilder {

    private static final String TO_DIR = "C:\\projects\\open_source\\apache-camel\\src\\main\\resources\\files\\?";
    private static final String APPEND = "&fileExist=Append";

    @Override
    public void configure() throws Exception {

        from("direct:fileWriter")
                .process(Exchange::getMessage)
                .to("file://" + TO_DIR + "filName=camel-demo-appends.txt" + APPEND);

    }
}
