package cn.xuqplus.jvmtest.day07_tx;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
public class BTest {

    @Test
    public void b() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BConfig.class);

        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        List<Map<String, Object>> query = jdbcTemplate.query("select * from user", new ColumnMapRowMapper());

        log.info("{}", query);
    }
}
