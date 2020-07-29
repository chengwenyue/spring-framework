package cwy.demo.spring.base;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author cwy-pc
 * @date 2020-05-31
 */
//@Scope("prototype")
@Component
public class ComponentClass implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println(" ComponentClass + afterPropertiesSet ");
	}
}
