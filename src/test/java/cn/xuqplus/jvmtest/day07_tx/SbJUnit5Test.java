package cn.xuqplus.jvmtest.day07_tx;

import cn.xuqplus.jvmtest.day07_tx.service.BService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest(classes = BConfig.class)
public class SbJUnit5Test {

    @Resource
    private BService bService;

    @Test
    public void a() {
        log.info(">> {}", bService);
    }
}
