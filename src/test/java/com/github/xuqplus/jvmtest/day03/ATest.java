package com.github.xuqplus.jvmtest.day03;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ATest {

    public static void a() {
        log.info("this ATest a() - .");
        BTest bTest = new BTest();
        bTest.b();
        bTest.bb();
    }

    @Test
    void f() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aTest = Class.forName("com.github.xuqplus.jvmtest.day03.ATest", false, new AClassLoader());
        Method a = aTest.getMethod("a", null);
        a.invoke(null, null);

        Class<?> aTest1 = Class.forName("com.github.xuqplus.jvmtest.day03.ATest", false, new BClassLoader());
        Method a1 = aTest1.getMethod("a", null);
        a1.invoke(null, null);
    }
}
