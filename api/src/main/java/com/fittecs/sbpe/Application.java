package com.fittecs.sbpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.fittecs.sbpe")
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.fittecs.sbpe")
@EnableJpaRepositories("com.fittecs.sbpe.repository")
@EnableTransactionManagement
@EntityScan("com.fittecs.sbpe.entity")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
