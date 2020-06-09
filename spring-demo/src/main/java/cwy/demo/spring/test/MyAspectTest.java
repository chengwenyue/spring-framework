package cwy.demo.spring.test;

import cwy.demo.spring.aop.MyAspect;
import cwy.demo.spring.base.SimpleBean;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.weaver.internal.tools.PointcutExpressionImpl;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParameter;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cwy-pc
 * @date 2020-05-19
 */
public class MyAspectTest {

	public static void main(String[] args) {
		ProxyFactory factoryBean = new ProxyFactory();
//		ProxyFactoryBean factoryBean = new ProxyFactoryBean();
		factoryBean.setTarget(new SimpleBean());

		//声明一个aspectj切点
//		AspectJExpressionPointcut cut = new AspectJExpressionPointcut();
		AspectJExpressionPointcut cut = new AspectJExpressionPointcut(MyAspect.class,new String[0],new Class[0]);
		//设置需要拦截的方法-用切点语言来写
		cut.setExpression("pointCut()");
//		cut.setExpression("execution(* cwy.demo.spring.base.*.*(..))");//拦截:空参返回值为int的run方法

		Advice advice = new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("放行前拦截...");
				Object obj = invocation.proceed();//放行
				System.out.println("放行后拦截...");
				return obj;
			}
		};

		//切面=切点+通知
		Advisor advisor = new DefaultPointcutAdvisor(cut,advice);
		factoryBean.addAdvisor(advisor);
		SimpleBean p = (SimpleBean) factoryBean.getProxy();
		p.test();

		PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingAllPrimitivesAndUsingContextClassloaderForResolution();
		final PointcutExpression expression = pointcutParser.parsePointcutExpression("execution(* cwy.demo.spring.base.*.*(..))");
		System.out.println(expression.couldMatchJoinPointsInType(SimpleBean.class));

	}
}
