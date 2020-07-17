package cn.xuqplus.jvmtest.day07_tx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class TxService {
    @Resource
    private BService service;

    public void insert2Users() {
        service.insertUser(10L, "10L");
        int i = 1 / 0;
        service.insertUser(11L, "11L");
    }

    @Transactional
    public void insert2UsersTx() {
        service.insertUser(20L, "20L");
        int i = 1 / 0;
        service.insertUser(21L, "21L");
    }
}
