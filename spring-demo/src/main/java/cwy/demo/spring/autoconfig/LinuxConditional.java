package cwy.demo.spring.autoconfig;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author cwy
 * @date $
 */
public class LinuxConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Environment environment = context.getEnvironment();
        int count = context.getBeanFactory().getBeanDefinitionCount();
        final String property = environment.getProperty("os.name");
        //WindowsConditional.java中，只需要判断 Windows
        if (property.contains("linux")) {
            return true;
        }
        return false;
//        throw new RuntimeException(property);
    }
}
