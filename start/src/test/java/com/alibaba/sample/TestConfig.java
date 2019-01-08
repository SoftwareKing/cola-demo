package com.alibaba.sample;

import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Frank Zhang
 * @date 2018-08-08 12:33 PM
 */
@Configuration
@ComponentScan(basePackages = {"com.alibaba.cola", "com.alibaba.sample"})
public class TestConfig {

    public TestConfig() {
        LoggerFactory.activateSysLogger();
        Logger logger = LoggerFactory.getLogger(TestConfig.class);
        logger.debug("Spring container is booting");
    }

}