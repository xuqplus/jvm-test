package cn.xuqplus.jvmtest.day06.proxy2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"cn.xuqplus.jvmtest.day06.proxy2"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BConfig {
}
