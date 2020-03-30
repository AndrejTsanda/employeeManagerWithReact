package com.tsanda.packager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.tsanda")
@EntityScan(basePackages = "com.tsanda.entities")
@EnableJpaRepositories(basePackages = "com.tsanda.dao")
public class PackagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(PackagerApplication.class, args);
  }
}
