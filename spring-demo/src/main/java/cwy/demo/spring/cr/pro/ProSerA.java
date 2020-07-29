package cwy.demo.spring.cr.pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cwy-pc
 * @date 2020-07-09
 */
@Component
public class ProSerA {

	@Autowired
	ProSerB serB;

}
