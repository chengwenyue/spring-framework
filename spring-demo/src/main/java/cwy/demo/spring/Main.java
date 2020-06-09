package cwy.demo.spring;

import cwy.demo.spring.config.BeanFactoryPostProcessorDemo;
import cwy.demo.spring.config.BeanPostProcessorDemo;
import cwy.demo.spring.config.MyBeanDefinitionRegistryPostProcessor;
import cwy.demo.spring.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
//@Component
//@Configuration
//@EnableTransactionManagement
public class Main {
	private Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "Z:\\code2");

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

//		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Company.class);
//		applicationContext.registerBeanDefinition("company",builder.getBeanDefinition());
//		Company bean = (Company) applicationContext.getBeanFactory().getBean("company");
//		System.out.println(bean);
//		BeanDefinition company = applicationContext.getBeanDefinition("company");
//		System.out.println(company.getSource());
		applicationContext.register(Main.class);
		applicationContext.register(MyBeanDefinitionRegistryPostProcessor.class);
//		applicationContext.register(FactoryBeanPostProcessor.class);
		applicationContext.refresh();

//		applicationContext.getBean("myConfig.MyConfigInner");
//		System.out.println(applicationContext.getBean(MyConfig.MyConfigInner.class));
		ObjectProvider<Employee> beanProvider = applicationContext.getBeanProvider(Employee.class);
		System.out.println(beanProvider.getIfAvailable());

		System.out.println(applicationContext.getBean(BeanPostProcessorDemo.class));

//		applicationContext.getBeanNamesForType(MyFactoryBean.class);
//		System.out.println(applicationContext.getBean(MyFactoryBean.class));

	}
}
