package com.github.xuqplus.jvmtest.day03;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BTest {

    public static void b() {
        log.info("this BTest.b() in .");
    }

    public void bb() {
        log.info("this BTest.bb() in .");
    }
}
