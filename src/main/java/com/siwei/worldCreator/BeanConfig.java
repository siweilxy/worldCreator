package com.siwei.worldCreator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations= {"classpath:config.xml"})
@ComponentScan
public class BeanConfig {

}
