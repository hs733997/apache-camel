package com.microservices.apachecamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimeDelayedRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://test?period=5000")
                .setBody(simple("Welcome to Apache Camel 's World!!"))
                .to("log:test");
    }
}
