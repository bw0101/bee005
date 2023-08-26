package com.bee.bee005;

import com.bee.bee005.configuration.CustomConfig;
import com.bee.bee005.configuration.DevConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({CustomConfig.class, DevConfig.class})
class Bee005ApplicationTests {


    @Configuration
    static class TestConfig {
        // ... bean definitions ...
    }
    @Test
    void contextLoads() {
    }

}
