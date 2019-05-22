package org.evan.springdemo.spring.Examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoEventConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoEventConsumer.class);

    //Register as a receiver for an event, get all events using the DemoEvent object
    @EventListener
    public void waitForEvent(DemoEvent demoEvent) {
        LOGGER.error("Got the event {}", demoEvent.getValue());
    }

    @EventListener
    public void waitForStringEvent(String demoStringEvent) {
        LOGGER.error("Got the string event {}", demoStringEvent);
    }
}
