package cwy.demo.spring.test;

import cwy.demo.spring.entity.MyConverter;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.converter.Converter;

/**
 * @author cwy-pc
 * @date 2020-03-12
 */
public class TypeConvert {
	public void testConvert(){
		ResolvableType resolvableType = ResolvableType.forClass(MyConverter.class).as(Converter.class);
		ResolvableType[] generics = resolvableType.getGenerics();
		resolvableType.getSource();

	}
}
