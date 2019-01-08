package com.alibaba.sample.validator;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.alibaba.cola.validator.ValidatorI;
import com.alibaba.sample.dto.CustomerAddCmd;
import org.springframework.stereotype.Component;


@Component
public class CustomerAddValidator implements ValidatorI {

	private Logger logger = LoggerFactory.getLogger(CustomerAddValidator.class);
	
	@Override
	public void validate(Object candidate) {
		logger.debug("General validation");
		CustomerAddCmd addCmd = (CustomerAddCmd)candidate;
	}
}
