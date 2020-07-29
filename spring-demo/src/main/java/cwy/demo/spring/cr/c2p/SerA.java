package cwy.demo.spring.cr.c2p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cwy-pc
 * @date 2020-07-09
 */
@Component
public class SerA {

	@Autowired
	private SerB serB;

}
