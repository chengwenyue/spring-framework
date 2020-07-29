package cwy.demo.spring.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cwy
 */
@Configuration
//@Conditional(WindowsConditional.class)
public class MainConfigConditional {
    @Bean(value = "linux")
    @Conditional(LinuxConditional.class)
    public Map<String, String> map1() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "linux");
        return map;
    }

    @Bean(value = "window")
    @Conditional(WindowsConditional.class)
    public Map<String, String> map2() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "window");
        return map;
    }
}
