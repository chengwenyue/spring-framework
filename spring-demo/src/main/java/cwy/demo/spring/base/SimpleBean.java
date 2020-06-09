package cwy.demo.spring.base;

import cwy.demo.spring.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBean {
	public static int count = 0;
	private int num;
	private Logger logger = LoggerFactory.getLogger(Main.class);
	
	public SimpleBean() {
		count++;
		this.num = count;
	}
	public void send() {
		logger.info("My number is "+this.num);
		logger.info("I am send method from SimpleBean!");
		logger.info("Count is "+count);
    }
	
	public void test() {
		logger.info("bean call test");
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
