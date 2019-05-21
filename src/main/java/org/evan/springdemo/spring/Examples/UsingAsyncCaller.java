package org.evan.springdemo.spring.Examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


@Component
public class UsingAsyncCaller implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsingAsyncCaller.class);
    private final UsingAsync usingAsync;

    @Autowired
    public UsingAsyncCaller(UsingAsync usingAsync) {
        this.usingAsync = usingAsync;
    }

    @PostConstruct
    public void SleepForABit() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);

            LOGGER.info("About to call async method.");
            usingAsync.runSlowly();
            LOGGER.info("Finished calling async method.");

            LOGGER.info("About to call async method with return value.");
            Future<String> future = usingAsync.runSlowlyWithReturnValue();
            while (true) {
                if (future.isDone()) {
                    LOGGER.info("Value from async method - {}", future.get());
                    break;
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
            LOGGER.info("Finished calling async method with return value.");

        } catch (Exception e) {
        }
    }
}
