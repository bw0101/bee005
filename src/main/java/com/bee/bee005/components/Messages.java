package com.bee.bee005.components;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Messages {

    @Value("${messages.greetings}")
    String greeting;
    @Value("${messages.bye}")
    String bye;
}
