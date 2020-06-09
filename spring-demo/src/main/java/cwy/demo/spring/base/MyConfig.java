package cwy.demo.spring.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author cwy-pc
 * @date 2019-11-07
 */
@Configuration
public class MyConfig {

    @Bean
    public SimpleBean getSimpleBean(){
        return new SimpleBean();
    }

    @Autowired(required = false)
    public void getSim(SimpleBean simpleBean){
    }
}
