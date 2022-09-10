package com.skillsoft.stsspringboot;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SimpleScheduler {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRateString = "${scheduler.rate}")
    public void scheduledLookup() throws  InterruptedException{
        System.out.println("The time is now: " + dateFormat.format(new Date()));

        Thread.sleep(5000);
    }
}
