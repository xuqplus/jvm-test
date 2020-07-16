package cn.xuqplus.jvmtest.day06.proxy2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BClazz {

    public void a() {
        log.info("{}", "aaa");
    }

    public void b() {
        log.info("{}", "bbb");
    }

    public void c() {
        a();
        b();
    }
}
