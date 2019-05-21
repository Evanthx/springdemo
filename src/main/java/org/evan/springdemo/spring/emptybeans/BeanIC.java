package org.evan.springdemo.spring.emptybeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanIC implements BeanInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeanIC.class);
}
