package cn.xuqplus.jvmtest.day11_unsafe;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class UncaughtExceptionTest {

    @Test
    void test() {
        {
            Thread thread = new Thread(() -> {
                throw new AException("test uncaught exception ..");
            });
            thread.setUncaughtExceptionHandler((t, e) -> {
                log.info("thread {} {}", t.getName(), e.getMessage());
            });
            thread.start();
        }
        {
            ThreadGroup group = new ThreadGroup("a-group") {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    log.info("group {} {}", t.getName(), e.getMessage());
                }
            };
            Thread thread = new Thread(group, () -> {
                log.info("{}", Thread.currentThread().getName());
                throw new AException("test thread group");
            });
            thread.start();
        }

        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(4));
    }

    static class AException extends RuntimeException {
        public AException(String message) {
            super(message);
        }
    }
}
