package cwy.demo.spring.test;

import com.alibaba.fastjson.JSONObject;
import cwy.demo.spring.entity.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author cwy-pc
 * @date 2020-03-12
 */
public class SpELTest {

	private static final Logger logger = LoggerFactory.getLogger(SpELTest.class);


	public void testSpEL(){
		ExpressionParser parser = new SpelExpressionParser();
		ParserContext parserContext = new TemplateParserContext();

		Expression exp = parser.parseExpression("'Hello World'.concat('!')");
		String message = (String) exp.getValue();
		logger.info("{}",message);
		//普通bean
		Company company = new Company();
		company.setName("myname");
		Expression expression = parser.parseExpression("#{name}",parserContext);
		EvaluationContext context = new StandardEvaluationContext(company);
		context.setVariable("com",company);
		String value = expression.getValue(context , String.class);

		//json
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name","jsonName");
		expression = parser.parseExpression("['name'] = '123'");
		context = new StandardEvaluationContext(jsonObject);
		expression.getValue(context);
//		value = expression.getValue(context , String.class);

		logger.info("{}",value);
		logger.info("{}",jsonObject);
	}
}
