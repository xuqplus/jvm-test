package cn.xuqplus.jvmtest.day08.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class BService {

    // solution 1
//    @Resource
//    @Qualifier(value = "AService")

    // solution 2
//    @Resource(name = "aService")

    // solution 3
//    @Autowired
//    @Qualifier(value = "aService")

    // solution 4
    // on bean definition side using @Primary
//    @Autowired // or
    @Resource
    AService aService11;

    public void b() {
        log.info("{}", "hoho");
        aService11.a();
    }
}
