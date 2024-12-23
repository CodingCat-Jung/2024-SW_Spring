package edu.sch.springboot;

import edu.sch.springboot.aop.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {
    @Bean
    public LoggingAspect  loggingAspect() {
        return new LoggingAspect();
    }
}
