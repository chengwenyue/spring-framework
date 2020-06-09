package cwy.demo.spring.test;

import cwy.demo.spring.entity.Company;
import cwy.demo.spring.entity.Employee;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.DataBinder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cwy-pc
 * @date 2020-03-12
 */
@Component
public class DataBindTest{

	private static final Logger logger = LoggerFactory.getLogger(DataBindTest.class);


	public void test() {
		BeanWrapper company = new BeanWrapperImpl(new Company());
		// setting the company name..
		company.setPropertyValue("name", "Some Company Inc.");
		// ... can also be done like this:
		PropertyValue value = new PropertyValue("name", "Some Company Inc.");

		company.setPropertyValue(value);

		MutablePropertyValues values = new MutablePropertyValues();
		//文件属性绑定
		values.addPropertyValue("file","classpath:config.xml");
		company.setPropertyValues(values);


		// ok, let's create the director and tie it to the company:
		BeanWrapper jim = new BeanWrapperImpl(new Employee());
//		jim.setPropertyValue("name", "Jim Stravinsky");
		company.setPropertyValue("managingDirector", jim.getWrappedInstance());
		// retrieving the salary of the managingDirector through the company
		Float salary = (Float) company.getPropertyValue("managingDirector.salary");

		//内部bean属性绑定
		company.setPropertyValue("managingDirector.name","Jim Stravinsky");

		//内部list属性绑定
		company.setPropertyValue("employeeList",new ArrayList<Employee>());
		company.setPropertyValue("employeeList[0]",new Employee());
		company.setPropertyValue("employeeList[0].name","employeeList[0].name");

		logger.info("{}",company.getWrappedInstance());
		Company companyWrappedInstance = (Company) company.getWrappedInstance();
		logger.info("{}",companyWrappedInstance.getEmployeeList());

		try {
			logger.info("{}", FileUtils.readFileToString(companyWrappedInstance.getFile(), Charset.defaultCharset()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void testDataBind2() {
		DataBinder dataBinder = new DataBinder(new Company());
		Map<String, Object> params = new HashMap<>();
		params.put("name", "Some Company Inc.");
		PropertyValues propertyValues = new MutablePropertyValues(params);
		dataBinder.bind(propertyValues);
		logger.info("{}",dataBinder.getTarget());
	}
}
