package cwy.demo.spring.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cwy-pc
 * @date 2020-03-14
 */
@Component
public class MyServiceDep {
	@Autowired
	MyService myService;

	public void test(){
		System.out.println("MyServiceDep test");
	}
}
