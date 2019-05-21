package org.evan.springdemo.spring.Examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class DemoEventPublisher implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoEventPublisher.class);

    private final ApplicationEventPublisher publisher;
    public static final String STRING_EVENT = "String event ";

    @Autowired
    public DemoEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostConstruct
     public void SleepForABit() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int i = 0;
        try {
            //Sleeping for a bit to ensure the consumer bean is ready to receive an event
            TimeUnit.SECONDS.sleep(2);
            //Send an event to every registered listener - one DemoEvent, one String event.
            //Only the appropriate listener should get them.
            publisher.publishEvent(new DemoEvent("Demo Value"));
            publisher.publishEvent(STRING_EVENT + i);
            if (++i > 10) {
                return;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
