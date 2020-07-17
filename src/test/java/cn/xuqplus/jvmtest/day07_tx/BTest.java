package cn.xuqplus.jvmtest.day07_tx;

import cn.xuqplus.jvmtest.day07_tx.service.BService;
import cn.xuqplus.jvmtest.day07_tx.service.TxService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class BTest {

    @Test
    public void b() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        List<Map<String, Object>> query = jdbcTemplate.query("select * from user", new ColumnMapRowMapper());
        log.info("{}", query);
    }

    @Test
    public void b0() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        BService bService = context.getBean(BService.class);
//        bService.insertUser(1L, "xqq");
//        bService.deleteUser(1L);
//        bService.deleteUserByName("xqq");
//        bService.updateUser(1L, "xqq1");
        log.info("{}", "");
    }

    /**
     * 未开启事务
     */
    @Test
    public void b1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        TxService txService = context.getBean(TxService.class);
        txService.insert2Users();
        log.info("{}", "");
    }

    /**
     * 开启事务
     */
    @Test
    public void b1tx() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);
        TxService txService = context.getBean(TxService.class);
        txService.insert2UsersTx();
        log.info("{}", "");
    }
}
