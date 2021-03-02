package com.github.xuqplus.jvmtest.day02;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class BTest {

    @Test
    void f() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        log.info("{}, {}", systemClassLoader.getClass(), systemClassLoader);

        ClassLoader parent = systemClassLoader.getParent();
        log.info("{}, {}", parent.getClass(), parent);

        ClassLoader parent2 = parent.getParent();
        log.info("{}, {}", parent2, parent2);
    }
}
