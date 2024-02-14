package com.eh.propman.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(@PropertySource(
        value = "classpath:h2.yml",
        factory = YamlPropertySourceFactory.class)
)
public class PropmanInfraConfig {
}
