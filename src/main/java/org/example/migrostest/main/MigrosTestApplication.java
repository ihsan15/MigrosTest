package org.example.migrostest.main;

import org.example.migrostest.config.MigrosTestConfig;
import org.example.migrostest.config.api.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MigrosTestConfig.class, SwaggerConfig.class})
public class MigrosTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MigrosTestApplication.class, args);
    }
}
