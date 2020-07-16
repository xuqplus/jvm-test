package cn.xuqplus.jvmtest.day06.proxy2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BConfigTest {

    @Test
    public void b() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);

        BClazz bean = context.getBean(BClazz.class);

        bean.a();
        bean.b();
        bean.c();
    }
}
