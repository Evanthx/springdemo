package org.evan.springdemo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = { "org.evan" })
public class SpringConfiguration implements AsyncConfigurer {

    @Bean
    @Override
    public Executor getAsyncExecutor() {
        return new ThreadPoolTaskExecutor();
    }

/**
 *
 * You can name the bean:     @Bean(name = "demoExecutor")
 * If you do then in the async methods you can choose which thread pool to use
 *
 * You can configure the threadpool if needed:
 *
 */

//    @Bean
//    @Override
//    public Executor getAsyncExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(7);
//        executor.setMaxPoolSize(42);
//        executor.setQueueCapacity(11);
//        executor.setThreadNamePrefix("MyExecutor-");
//        return executor;
//    }

}
