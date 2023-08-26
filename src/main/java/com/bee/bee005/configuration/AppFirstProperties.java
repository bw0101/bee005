package com.bee.bee005.configuration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
@Getter
@Setter
@ConfigurationProperties(prefix = "appfirst")
public class AppFirstProperties {

    private String greeting;

    private String sourcepath;

    private String destinationpath;
}