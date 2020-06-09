package cwy.demo.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cwy-pc
 * @date 2020-03-12
 */
public class PlaceholderTest {

	public void test(){
		System.setProperty("cwy/demo/spring", "classpath");
		System.setProperty("path1", "${spring}");
		System.setProperty("filename", "config");
		//${${path1:spring}} 属性嵌套及默认值
		//${path1}  path1 = ${path1} 此时会导致循环嵌套
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("${path1:spring}:${filename}${filename}.xml");
//		context.getEnvironment().setRequiredProperties("spring");

		context.close();
	}
}
