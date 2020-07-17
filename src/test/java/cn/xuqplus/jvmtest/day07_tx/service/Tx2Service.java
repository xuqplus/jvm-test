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

    /**
     * 有事务方法调用有事务方法
     */
    @Transactional
    public void ydy() {
        bService.insertUser(401L, "401L");
        service.insert2UsersTx();
        bService.insertUser(402L, "402L");
    }

    /**
     * 有事务方法调用有事务方法
     */
    @Transactional
    public void ydy_REQUIRES_NEW() {
        bService.insertUser(501L, "501L");
        service.insert2Users_REQUIRES_NEW();
        bService.insertUser(502L, "502L");
    }

    /**
     * 有事务方法调用有事务方法 - 捕获异常
     */
    @Transactional
    public void ydy2_REQUIRES_NEW() {
        bService.insertUser(601L, "601L");
        try {
            service.insert2Users_REQUIRES_NEW();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        bService.insertUser(602L, "602L");
    }
}
