package cwy.demo.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * spring后置处理器
 */
public class BeanPostProcessorDemo implements BeanPostProcessor{

	private Logger logger = LoggerFactory.getLogger(BeanPostProcessorDemo.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("自定义bean后置处理器处理：{}",beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


		return bean;
	}

}
