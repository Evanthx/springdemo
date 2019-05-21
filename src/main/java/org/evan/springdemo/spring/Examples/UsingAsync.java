package org.evan.springdemo.spring.Examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Component
public class UsingAsync {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsingAsync.class);

    /**
     * REQUIREMENTS
     * Config class needs to have @EnableAsync and implement AsyncConfigurer
     * Needs to have a Executor bean
     *
     * Cannot call the async method from the same class (Spring proxies the async
     * method, if you call from the same class the proxy is bypassed)
     */
    @Async
    public void runSlowly() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        LOGGER.info("Async method without return value is finished.");
    }

    @Async
    public Future<String> runSlowlyWithReturnValue() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        LOGGER.info("Async method with return value is finished.");
        return new AsyncResult<String>("Done");
    }



}
