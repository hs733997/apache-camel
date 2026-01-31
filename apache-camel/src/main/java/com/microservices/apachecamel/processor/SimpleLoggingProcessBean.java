package com.microservices.apachecamel.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/***
 * --------------this is a processor bean.-----------------
 * there are basically 2 types: transform / processor beans to perform operations on routes
 * transformer : changes the body of the message.
 * processor : processes the body and will not change any data
 */
@Component
public class SimpleLoggingProcessBean {
    Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessBean.class);

    /***
     * based on return type a bean is differentiated as a transformer/processor
     * i.e. if return type is void :- then it is processor
     */
    public void process(String message){
        logger.info("Simple logging process by bean {} "+message);
    }
}
