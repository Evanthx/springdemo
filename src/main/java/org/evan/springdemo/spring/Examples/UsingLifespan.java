package org.evan.springdemo.spring.Examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class UsingLifespan {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsingLifespan.class);

    //Use this annotation to call this method after bean properties are initialized
    @PostConstruct
    public void testMethod() {
        LOGGER.error("Post Construct method called!");
    }

    //Use this annotation to call the method before the bean is removed from the application context.
    @PreDestroy
    public void stopTaskThread() {
        LOGGER.error("Pre-destroy called!");
    }

}
