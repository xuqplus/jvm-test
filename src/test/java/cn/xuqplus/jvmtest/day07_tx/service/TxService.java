package cn.xuqplus.jvmtest.day07_tx.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    /**
     * 有事务方法调用无事务方法
     */
    @Transactional
    public void ydw() {
        insert2Users();
    }

    /**
     * 无事务方法调用有事务方法
     */
    public void wdy() {
        service.insertUser(201L, "201L");
        insert2UsersTx();
        service.insertUser(202L, "202L");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void insert2Users_NOT_SUPPORTED() {
        service.insertUser(103L, "103L");
        int i = 1 / 0;
        service.insertUser(104L, "104L");
    }
}
