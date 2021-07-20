package cn.xuqplus.jvmtest.day09;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class TimerTest {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer(true);

        timer.schedule(new TimerTask() {
                           @SneakyThrows
                           @Override
                           public void run() {
                               log.info("haha");
                               Thread.sleep(200);
                           }
                       },
                100, 100);
        timer.schedule(new TimerTask() {
                           @SneakyThrows
                           @Override
                           public void run() {
                               log.info("hihi");
                               Thread.sleep(2);
                           }
                       },
                100, 100);

        log.info("111");
        Thread.sleep(1000L);
        log.info("222");
    }
}
