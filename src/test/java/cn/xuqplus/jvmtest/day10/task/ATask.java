package cn.xuqplus.jvmtest.day10.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ATask {

    @Scheduled(fixedDelay = 5000)
    public void task() {
        log.info("task ..");
    }
}
