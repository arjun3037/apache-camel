package org.camel.demo.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "camel.hello.enabled" , havingValue = "true")
public class HelloRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:greeting")
                .choice()
                    .when().simple("${body} contains 'Team'")
                    .log("I am working with Team")
                .otherwise()
                .log("I am working alone")
         .end();

    }
}
