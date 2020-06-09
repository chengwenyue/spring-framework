package cwy.demo.spring.entity;

import org.springframework.core.convert.converter.Converter;

/**
 * @author cwy-pc
 * @date 2019-07-22
 */
public class MyConverter implements Converter<Company,String> {
    @Override
    public String convert(Company source) {
        return source.toString();
    }
}
