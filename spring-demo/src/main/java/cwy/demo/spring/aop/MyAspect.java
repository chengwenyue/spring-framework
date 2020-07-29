package cwy.demo.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author cwy-pc
 * @date 2020-05-10
 */
@Component
@Aspect
//@EnableAspectJAutoProxy
public class MyAspect {

	@Pointcut("execution(* cwy.demo.spring.base.*.*(..))")
	public void pointCut(){};

	@Before("pointCut()")
	public void doAccessCheck() {
		System.out.println("-------------------------------------------");
		System.out.println("this is aop ");
	}
}

