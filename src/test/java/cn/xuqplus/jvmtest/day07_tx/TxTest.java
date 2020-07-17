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

    @Test
    public void tx3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        Tx2Service tx2Service = context.getBean(Tx2Service.class);
        tx2Service.ydy(); // 回滚了
        log.info("{}", "");
    }

    @Test
    public void tx4() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        Tx2Service tx2Service = context.getBean(Tx2Service.class);
        tx2Service.ydy_REQUIRES_NEW(); // 回滚了
        log.info("{}", "");
    }

    @Test
    public void tx5() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        Tx2Service tx2Service = context.getBean(Tx2Service.class);
        tx2Service.ydy2_REQUIRES_NEW(); // 内层回滚, 外层无异常不回滚
        log.info("{}", "");
    }

    @Test
    public void tx6() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        TxService service = context.getBean(TxService.class);
        service.ydy3_REQUIRES_NEW(); // 不回滚
        log.info("{}", "");
    }

    /**
     * // Transaction rolled back because it has been marked as rollback-only
     * <p>
     * 事务合并导致提交失败
     */
    @Test
    public void tx7() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        Tx2Service service = context.getBean(Tx2Service.class);
        service.ydy2(); // 事务合并导致提交失败
        log.info("{}", "");
    }
}
