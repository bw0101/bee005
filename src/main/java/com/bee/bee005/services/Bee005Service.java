package com.bee.bee005.services;

import com.bee.bee005.components.Messages;
import com.bee.bee005.configuration.AppFirstProperties;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Bee005Service {

    private Messages greeting;

    private final AppFirstProperties properties;

    public String getSourcePath(){
        return properties.getSourcepath();
    }

    public String getDestinationPath(){
        return properties.getDestinationpath();
    }

    public String showGreeting(){
        return greeting.getGreeting();
    }

    public String sayGoodbye(){
        return greeting.getBye();
    }

}
