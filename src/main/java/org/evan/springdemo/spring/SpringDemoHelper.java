package org.evan.springdemo.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


@Component
public class SpringDemoHelper implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringDemoHelper.class);

    @PostConstruct
    public void SleepForABit() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
