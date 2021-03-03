package cn.xuqplus.jvmtest.day08;

import cn.xuqplus.jvmtest.day08.service.BService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ATest {

    @Test
    void a() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AConfig.class);
        BService bService = context.getBean(BService.class);
        bService.b();
    }
}
