package com.alibaba.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * COLA framework initialization is configured in {@link com.alibaba.sample.config.ColaConfig}
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.alibaba.sample.*","com.alibaba.cola"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
