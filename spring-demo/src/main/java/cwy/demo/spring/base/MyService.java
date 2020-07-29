package cwy.demo.spring.base;

import cwy.demo.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author cwy-pc
 * @date 2020-03-14
 */
@Component
public class MyService{

	/**
	 * @Autowired 实际上是一种属性装配，可以理解为手动装配，类似xml方式的注入
	 * 		<property name="dep">
	 * 			<ref bean="dep"></ref>
	 * 		</property>
	 *  byType和byName 是一种注入模型，只对xml配置有用
	 *  注入方式有两种，一种Constructor-based，一种是Setter-based
	 *  注入模型有四种: byType和byName ， no , constructor
	 *
	 */
	@Autowired
	private MyServiceDep dep;

	public MyService(){

	}


	public MyService(MyServiceDep dep){
		System.out.println("MyServiceDep");
	}

	@Autowired(required = false)
	public MyService(SimpleBean dep){
		System.out.println("SimpleBean");
	}

	@Autowired(required = false)
	public MyService(Employee employee){
		System.out.println("employee");
	}

	@Autowired(required = false)
	public MyService(Employee employee,String str){
		System.out.println("employee");
	}

	@PostConstruct
	public void init(){
		System.out.println("life init");
		System.out.println(dep);
	}

	public MyServiceDep getDep() {
		return dep;
	}

	public void setDep(MyServiceDep dep) {
		this.dep = dep;
	}
}
