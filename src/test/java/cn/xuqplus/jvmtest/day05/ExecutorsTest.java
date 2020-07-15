package cn.xuqplus.jvmtest.day05;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class ExecutorsTest {
    @Test
    public void c() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int i0 = i;
            executorService.execute(() -> {
                log.info("{} {}", i0, Thread.currentThread().getName());
            });
        }

        Thread.sleep(3000L);
    }

    @Test
    public void c0() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int i0 = i;
            executorService.execute(() -> {
                log.info("{} {}", i0, Thread.currentThread().getName());
            });
        }

        Thread.sleep(3000L);
    }

    @Test
    public void c1() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 10; i++) {
            final int i0 = i;
            executorService.execute(() -> {
                log.info("{} {}", i0, Thread.currentThread().getName());
            });
        }

        Thread.sleep(3000L);
    }

    @Test
    public void c2() throws InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            final int i0 = i;
            executorService.execute(() -> {
                log.info("{} {}", i0, Thread.currentThread().getName());
            });
        }

        Thread.sleep(3000L);
    }

    @Test
    public void c3() throws InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int i0 = i;
            executorService.execute(() -> {
                log.info(">> start {} {}", i0, Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("<< stop {} {}", i0, Thread.currentThread().getName());
            });
        }

        Thread.sleep(10000L);
    }

    @Test
    public void c4() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            final int i0 = i;
            executorService.execute(() -> {
                log.info(">> start {} {}", i0, Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("<< stop {} {}", i0, Thread.currentThread().getName());
            });
        }

        Thread.sleep(10000L);
    }


    @Test
    public void c4submit() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int i0 = i;
            Future<?> submit = executorService.submit(() -> {
                log.info(">> start {} {}", i0, Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("<< stop {} {}", i0, Thread.currentThread().getName());
                return "callable result ..";
            });
            futures.add(submit);
        }
        for (Future f : futures) {
            log.info("{}", f.get());
        }
    }
}
