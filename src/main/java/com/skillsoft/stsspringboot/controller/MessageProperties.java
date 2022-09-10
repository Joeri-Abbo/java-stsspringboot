package com.skillsoft.stsspringboot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("messages")
public class MessageProperties {
    /**
     * Greeting message returned by the Greeting controller
     */
    private String greeting = "Good morning ";

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
