package org.evan.springdemo.spring.Examples;

import org.evan.springdemo.spring.emptybeans.BeanA;
import org.evan.springdemo.spring.emptybeans.BeanInterface;
import org.evan.springdemo.spring.emptybeans.BeanInterfaceTwo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsingArrays {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsingArrays.class);

    @Autowired
    public UsingArrays(List<BeanInterface> beans, List<BeanA> beanAList, List<BeanInterfaceTwo> beanTwos) {
        //It finds all beans implementing the interface
        LOGGER.error("Bean counts - Interface - {}", beans.size());

        //Or all instances of a bean type
        LOGGER.error("Bean counts - SingleBean - {}", beanAList.size());

        //And if there aren't any, you get an empty list, not a null
        LOGGER.error("Bean counts - BeanTwo - {}", beanTwos.size() );
    }

}
