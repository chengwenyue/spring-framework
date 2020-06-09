package cwy.demo.spring.config;

import cwy.demo.spring.base.MyFactoryBean;
import cwy.demo.spring.entity.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 *
 * @author cwy-pc
 * @date 2020-03-15
 */

public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	private static final Logger logger = LoggerFactory.getLogger(MyBeanDefinitionRegistryPostProcessor.class);

	private AnnotatedBeanDefinitionReader reader;

	/**
	 * 在后置处理器工厂调用之前为spring容器添加BeanDefinition。
	 *
	 * ConfigurationClassPostProcessor也是利用此方法实现ComponentScan的功能。
	 * @param registry the bean definition registry used by the application context
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//		reader = new AnnotatedBeanDefinitionReader(registry);
		logger.info("自定义BeanDefinitionRegistryPostProcessor注册一个bean");
//		reader.register(Company.class);
		GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
		genericBeanDefinition.setBeanClass(MyFactoryBean.class);
		genericBeanDefinition.getConstructorArgumentValues().addGenericArgumentValue("cwy.demo.spring.entity.Employee");
		registry.registerBeanDefinition("myEmp",genericBeanDefinition);

		GenericBeanDefinition genericBeanDefinition2 = new GenericBeanDefinition();
		genericBeanDefinition2.setBeanClass(MyFactoryBean.class);
		genericBeanDefinition2.getConstructorArgumentValues().addGenericArgumentValue("cwy.demo.spring.config.BeanPostProcessorDemo");

		registry.registerBeanDefinition("myBfp",genericBeanDefinition2);

	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
