package com.bee.bee005.configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CustomConfig.class, DevConfig.class})
@EnableConfigurationProperties(AppFirstProperties.class)
public class AppConfig {

}