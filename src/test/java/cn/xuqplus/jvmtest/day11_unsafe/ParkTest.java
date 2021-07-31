package cn.xuqplus.jvmtest.day11_unsafe;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ParkTest {

    @Test
    void park() {
        Unsafe unsafe = UnsafeUtils.getUnsafe();

        int n = 2; // seconds
        long millis = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(n);
        long nanos = TimeUnit.SECONDS.toNanos(n);

        log.info("{}", 1);
        unsafe.park(true, millis); // park util specific milliseconds
        log.info("{}", 2);
        unsafe.park(false, nanos); // park for n nanoseconds
        log.info("{}", 3);

        LockSupport.parkNanos(nanos);
        log.info("{}", 4);
        LockSupport.parkUntil(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(n));
        log.info("{}", 5);
        Object blocker = LockSupport.getBlocker(Thread.currentThread());
        LockSupport.parkNanos(blocker, TimeUnit.SECONDS.toNanos(n));
        log.info("{}", 6);
    }
}
