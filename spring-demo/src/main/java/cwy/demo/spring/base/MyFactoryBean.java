package cwy.demo.spring.base;

import cwy.demo.spring.entity.Employee;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author cwy-pc
 * @date 2020-03-17
 */
//@Component
public class MyFactoryBean<T> implements FactoryBean<T> {

	private Class c;
	private SimpleBean myServiceDep;
	public MyFactoryBean(Class c){
		this.c = c;
	}

	public MyFactoryBean(Class c,SimpleBean myServiceDep){
		this.c = c;
		this.myServiceDep = myServiceDep;
	}
	@Override
	public T getObject() throws Exception {
		System.out.println("init "+c +" myServiceDep "+myServiceDep);
		return (T) c.newInstance();
	}

	@Override
	public Class<?> getObjectType() {
		return c;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
