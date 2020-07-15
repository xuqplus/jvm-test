package cn.xuqplus.jvmtest.day05;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CountDownLatchTest {
    @Test
    public void a() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                Thread.sleep(1000L);
                log.info("{}", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                Thread.sleep(3000L);
                log.info("{}", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        latch.await();
        log.info("{}", Thread.currentThread().getName());
    }
}
