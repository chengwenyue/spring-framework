package cwy.demo.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener implements ApplicationListener<ContextRefreshedEvent> {

    public static final Logger logger = LoggerFactory.getLogger(MyListener.class);
    @EventListener
    public void listener1(ContextStartedEvent event){
        logger.info("{}",event);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("{}",event);
    }
}
