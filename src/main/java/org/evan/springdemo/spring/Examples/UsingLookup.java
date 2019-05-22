package org.evan.springdemo.spring.Examples;

import org.evan.springdemo.spring.emptybeans.BeanA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UsingLookup {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsingLookup.class);

    @PostConstruct
    public void demoSingle() {
        BeanA beanA = testMethod();
        if (beanA == null) {
            LOGGER.error("Lookup did not work");
        } else {
            LOGGER.error("Lookup worked.");
        }
    }

    @Lookup
    public BeanA testMethod() {
        //Spring will override this method
        //Good for getting prototype beans easily
        //Also good if a base type bean is injected dynamically
        return null;
    }


}
