package cn.xuqplus.jvmtest.day10;

import cn.xuqplus.jvmtest.day10.service.AService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@Configuration
@EnableScheduling
@ComponentScan(basePackages = {"cn.xuqplus.jvmtest.day10"})
public class ATest {

    @Test
    void test() throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ATest.class);
        AService service = context.getBean(AService.class);
        service.f();

        Thread.sleep(50000);
    }
}
