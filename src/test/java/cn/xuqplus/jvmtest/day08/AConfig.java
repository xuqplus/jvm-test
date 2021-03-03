package cn.xuqplus.jvmtest.day08;

import cn.xuqplus.jvmtest.day08.service.AService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"cn.xuqplus.jvmtest.day08"})
public class AConfig {

    @Bean
    @Primary
    public AService aService() {
        return new AService();
    }
}
