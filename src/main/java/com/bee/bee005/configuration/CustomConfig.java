package com.bee.bee005.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application-special.yaml", factory = YamlPropertySourceFactory.class)
public class CustomConfig {

}
