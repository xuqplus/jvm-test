package cn.xuqplus.jvmtest.day07_tx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class Tx2Service {
    @Resource
    private TxService service;
    @Resource
    private BService bService;

    /**
     * 有事务方法调用无事务方法
     */
    @Transactional
    public void ydw() {
        service.insert2Users();
    }

    /**
     * 无事务方法调用有事务方法
     */
    public void wdy() {
        bService.insertUser(301L, "301L");
        service.insert2UsersTx();
        bService.insertUser(302L, "302L");
    }

    /**
     * 有事务方法调用不支持事务方法
     */
    @Transactional
    public void ydn() {
        bService.insertUser(101L, "101L");
        service.insert2Users_NOT_SUPPORTED();
        bService.insertUser(102L, "102L");
    }
}
