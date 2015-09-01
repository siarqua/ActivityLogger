package org.some.pkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApplicationBoot extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationBoot.class, args);
    }

}