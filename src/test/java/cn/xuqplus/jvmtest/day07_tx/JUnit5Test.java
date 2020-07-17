package cn.xuqplus.jvmtest.day07_tx;

import cn.xuqplus.jvmtest.day07_tx.service.BService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;

@Slf4j
@SpringJUnitConfig(classes = BConfig.class)

// 或使用两个注解
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = BConfig.class)
public class JUnit5Test {

    @Resource
    private BService bService;

    @Test
    public void a() {
        log.info(">> {}", bService);
    }
}
