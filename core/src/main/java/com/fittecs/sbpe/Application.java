package com.fittecs.sbpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.fittecs.sbpe"})
@EntityScan("com.fittecs.sbpe.entity")
@EnableJpaRepositories("com.fittecs.sbpe.repository")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
