package cn.xuqplus.jvmtest.day06.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AClazzImpl implements AClazz {

    @Override
    public void a() {
        log.info("{}", "aaa");
    }

    @Override
    public void b() {
        log.info("{}", "bbb");
    }

    @Override
    public void c() {
        a();
        b();
    }
}
