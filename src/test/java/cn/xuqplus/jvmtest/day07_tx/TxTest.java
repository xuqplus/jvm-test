package cn.xuqplus.jvmtest.day07_tx;

import cn.xuqplus.jvmtest.day07_tx.service.Tx2Service;
import cn.xuqplus.jvmtest.day07_tx.service.TxService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class TxTest {

    @Test
    public void tx() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        TxService txService = context.getBean(TxService.class);
        Tx2Service tx2Service = context.getBean(Tx2Service.class);
//        txService.ydw(); // 回滚了
        tx2Service.ydw(); // 回滚了
        log.info("{}", "");
    }

    @Test
    public void tx1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        TxService txService = context.getBean(TxService.class);
        Tx2Service tx2Service = context.getBean(Tx2Service.class);
//        txService.wdy(); // 同一个service内, 无事务方法调用有事务方法, 事务失效, 未回滚
        tx2Service.wdy(); // 外层方法不回滚, 内层方法回滚了
        log.info("{}", "");
    }

    @Test
    public void tx2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        Tx2Service tx2Service = context.getBean(Tx2Service.class);
        tx2Service.ydn(); // 外层事务方法回滚, 内层不支持事务不回滚
        log.info("{}", "");
    }
}
