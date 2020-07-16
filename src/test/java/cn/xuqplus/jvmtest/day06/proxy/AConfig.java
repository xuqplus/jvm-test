package cn.xuqplus.jvmtest.day06.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.winterchen.config"})
public class AConfig {

    @Bean
    public String a() {
        return "hahaha";
    }
}
