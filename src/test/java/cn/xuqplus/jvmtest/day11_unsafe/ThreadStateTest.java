package cn.xuqplus.jvmtest.day11_unsafe;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadStateTest {

    @Test
    void test() throws InterruptedException {
        Unsafe unsafe = UnsafeUtils.getUnsafe();
        {
            Thread thread = new Thread();
            assert Thread.State.NEW == thread.getState();

            thread.start();
            assert Thread.State.RUNNABLE == thread.getState();

            unsafe.park(false, TimeUnit.SECONDS.toNanos(2));
            assert Thread.State.TERMINATED == thread.getState();
        }
        {
            Object o = new Object();
            synchronized (o) {
                Thread thread = new Thread(() -> {
                    synchronized (o) {
                        // pass
                    }
                });
                thread.start();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // pass
                }

                assert Thread.State.BLOCKED == thread.getState();
            }
        }
        {
            Object o = new Object();
            synchronized (o) {
                Thread thread = new Thread(() -> {
                    synchronized (o) {
                        o.notify();
                        try {
                            o.wait();
                            log.info("{}", Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            // pass
                        }
                    }
                });
                thread.start();
                o.wait();
                log.info("{}", Thread.currentThread().getName());

                assert Thread.State.WAITING == thread.getState();
                o.notify();
            }
        }
        {
            Object o = new Object();
            synchronized (o) {
                Thread thread = new Thread(() -> {
                    synchronized (o) {
                        o.notify();
                        try {
                            o.wait(1000);
                            log.info("{}", Thread.currentThread().getName());
                        } catch (InterruptedException e) {
                            // pass
                        }
                    }
                });
                thread.start();
                o.wait();
                log.info("{}", Thread.currentThread().getName());

                assert Thread.State.TIMED_WAITING == thread.getState();
                o.notify();
            }
        }
    }
}
