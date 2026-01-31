package com.microservices.apachecamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
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
public class SimpleLoggingProcessorUsingProcessor implements Processor {
    Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessorUsingProcessor.class);

    /***
     * a processor can also be defined by implementing Processor interface.
     */

    @Override
    public void process(Exchange exchange) throws Exception {
        logger.info("Simple logging process by bean {} "+exchange);
    }
}
