package com.microservices.apachecamel.routes;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/***
 * --------------this is a transformer bean.-----------------
 * there are basically 2 types: transform / processor beans to perform operations on routes
 * transformer : changes the body of the message.
 * processor : processes the body and will not change any data
 */
@Component
class GetCurrentDateBean {

    /***
     * based on return type a bean is differentiated as a transformer/processor
     * i.e. if return type is other than void :- then it is transformer
     */
    public String getCurrentDate() {
        return "Current time is : " + LocalDateTime.now();
    }
}
