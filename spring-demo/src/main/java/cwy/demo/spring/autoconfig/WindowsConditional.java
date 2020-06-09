package cwy.demo.spring.autoconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author cwy
 * @date $
 */
public class WindowsConditional implements Condition {
    private  static final Logger logger = LoggerFactory.getLogger(WindowsConditional.class);
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        final Environment environment = context.getEnvironment();
        final String property = environment.getProperty("os.name");
        //WindowsCoditional.java中，只需要判断 Windows
        logger.info(property);
        if (property.contains("Windows")) {
            return true;
        }
        return false;
//        throw new RuntimeException(property);
    }
}
