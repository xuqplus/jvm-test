package cn.xuqplus.jvmtest.day06.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

@Slf4j
public class AConfigTest {

    /**
     * 启动类注解
     */
    @Test
    public void a() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AConfig.class);
        String bean = context.getBean(String.class);

        log.info("{}", bean);
    }

    /**
     * jdk动态代理 - 有接口
     */
    @Test
    public void b() {
        AClazz clazz = new AClazzImpl();
        clazz.a();
        clazz.b();

        Class[] classes = {AClazz.class};

        Object o = Proxy.newProxyInstance(clazz.getClass().getClassLoader(), classes, (proxy, method, args) -> {
            log.info(">> 增强");
            Object r = method.invoke(clazz, args);
            log.info("<< 增强");
            return r;
        });
        AClazz proxy = (AClazz) o;
        proxy.a();
        proxy.b();
        proxy.c();

        log.info("{}", proxy);
    }

    /**
     * cglib动态代理 - 无接口
     */
    @Test
    public void c() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AClazzImpl.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            log.info(">> 增强");
            Object r = methodProxy.invokeSuper(o, objects);
            log.info("<< 增强");
            return r;
        });
        AClazzImpl proxy = (AClazzImpl) enhancer.create();

        proxy.a();
        proxy.b();
        proxy.c();

        log.info("{}", "proxy");
    }
}
