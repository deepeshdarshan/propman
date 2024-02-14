package com.eh.propman.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eh.propman"})
@EntityScan(basePackages = {"com.eh.propman"})
@EnableJpaRepositories(basePackages = {"com.eh.propman"})
public class PropmanApplication {
    public static void main(String[] args) {
        SpringApplication.run(PropmanApplication.class, args);
    }
}
