package cn.xuqplus.jvmtest.day08.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AService {

    public void a() {
        log.info("{}", "haha");
    }
}
