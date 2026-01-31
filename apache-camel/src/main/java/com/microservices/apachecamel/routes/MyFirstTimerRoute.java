package com.microservices.apachecamel.routes;

import com.microservices.apachecamel.processor.SimpleLoggingProcessBean;
import com.microservices.apachecamel.processor.SimpleLoggingProcessorUsingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTimerRoute extends RouteBuilder {
    @Autowired
    private GetCurrentDateBean getCurrentDateBean;
    @Autowired
    private SimpleLoggingProcessBean simpleLoggingProcessBean;
    @Autowired
    private SimpleLoggingProcessorUsingProcessor processorUsingProcessor;

    @Override
    public void configure() throws Exception {
        from("timer:first-timer")
                .log("${body}")
//                .transform().constant("MyConstantValue")          //transformer
                //time will be constant since we are using constant here.
//                .transform().constant("current time : "+ LocalDateTime.now())
//                .bean("getCurrentDateBean") // if you are not using auto-wired you can use a bean in this way..
//                .bean(getCurrentDateBean)   //or
                //if you have multiple methods in your class then, specify method also
                .bean(simpleLoggingProcessBean)     //processor bean
                .log("${body}")
                .bean(getCurrentDateBean,"getCurrentDate")  //transformer bean
                .log("${body}")
                .process(processorUsingProcessor)
                .log("${body}")
                .to("log:first-timer");
    }
}


