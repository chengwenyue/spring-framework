package cwy.demo.spring.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.TypePatternClassFilter;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author cwy-pc
 * @date 2020-05-19
 */
//@Component
//@Import(DefaultAdvisorAutoProxyCreator.class)
public class MyAdvisor extends AbstractPointcutAdvisor {
	@Override
	public Pointcut getPointcut() {

		return new Pointcut() {
			@Override
			public ClassFilter getClassFilter() {
				return (c) -> c.getPackage().getName().startsWith("cwy.demo.spring.base") ;
			}

			@Override
			public MethodMatcher getMethodMatcher() {
				return MethodMatcher.TRUE;
			}
		};
	}

	@Override
	public Advice getAdvice() {
		return new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("MyAdvisor aop " +invocation.getThis().getClass()+"  "+invocation.getMethod().getName());
				return invocation.proceed();
			}
		};
	}
}
