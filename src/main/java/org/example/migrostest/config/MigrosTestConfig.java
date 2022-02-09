package org.example.migrostest.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "org.example.migrostest", excludeFilters = {@ComponentScan.Filter(Configuration.class)})
@EntityScan("org.example.migrostest.domain")
@EnableJpaRepositories("org.example.migrostest.repository")
public class MigrosTestConfig {
}
