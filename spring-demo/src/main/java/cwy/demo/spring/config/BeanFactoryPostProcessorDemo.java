package cwy.demo.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * 后置处理器工厂，用来为spring注册后置处理器的
 */
@Component
public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor{
	private Logger logger = LoggerFactory.getLogger(BeanFactoryPostProcessorDemo.class);

	public BeanFactoryPostProcessorDemo() {
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		logger.info("postProcessBeanFactory");

//		GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("myService");
//		System.out.println("注入模型: "+beanDefinition.getAutowireMode());
//		beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
//		beanFactory.addBeanPostProcessor(new BeanPostProcessorDemo());

		// 对于FactoryBean
		// 1. allowFactoryBeanInit = true则会实例化FactoryBean，然后调用getObjectType获取类型
		// 2. allowFactoryBeanInit = true 不会例化FactoryBean，只能根据类上的泛型判断
		// 对于普通bean，不需要实例化也能找到类型
		System.out.println("FactoryBean 的myBfp  type : "+ beanFactory.getType("myBfp",false));
	}
	

}
