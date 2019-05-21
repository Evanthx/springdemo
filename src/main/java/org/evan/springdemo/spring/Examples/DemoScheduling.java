package org.evan.springdemo.spring.Examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Needs @EnableScheduling to be set on the configuration class
 */
@Component
public class DemoScheduling {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoScheduling.class);

    private int rateCount = 0;
    private int delayCount = 0;

    /**
     * Fixed delay - sleep this long once the job completes.
     * So below - run the call, sleep 2 seconds, run the call again.
     * The initialDelay tells it to wait that long to start the job, and is optional
     */
    @Scheduled(fixedDelay = 2000, initialDelay=5000)
    public void ScheduledMethod() {
        LOGGER.info("Running fixedDelay job {}", delayCount++);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            return;
        }
    }

    /**
     * Fixed rate - run the job every X seconds.
     * So for below - run the job at 5:51:10. Then run it again at 5:51:12 - even if the
     * first job is still running.
     *
     * Note - we can also use cron expressions inside the @Scheduled annotation
     */
    @Scheduled(fixedRate = 2000, initialDelay=5000)
    public void ScheduledFixedRateMethod() {
        LOGGER.info("Running fixedRate job {}", rateCount++);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            return;
        }
    }
}
