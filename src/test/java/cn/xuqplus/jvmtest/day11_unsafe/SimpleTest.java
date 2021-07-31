package cn.xuqplus.jvmtest.day11_unsafe;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class SimpleTest {

    @Test
    void unsafe() throws InstantiationException, NoSuchFieldException, InterruptedException {
        Unsafe unsafe = UnsafeUtils.getUnsafe();

        {
            InitializationOrdering ordering = new InitializationOrdering();
            assert ordering.a == 1;
        }
        {
            // instantiating a class
            InitializationOrdering ordering = (InitializationOrdering) unsafe.allocateInstance(InitializationOrdering.class);
            assert ordering.a == 0;
        }
        {
            // altering private fields
            InitializationOrdering ordering = new InitializationOrdering();
            Field a = InitializationOrdering.class.getDeclaredField("a");
            unsafe.putInt(ordering, unsafe.objectFieldOffset(a), 11);
            assert 11 == ordering.a;
        }
        {
            // throwing an exception
            try {
                unsafe.throwException(new Exception("msg"));
            } catch (Exception e) {
                assert "msg".equals(e.getMessage());
            }
        }
        {
            // allocate memory
            {
                OffHeapArray array = new OffHeapArray(100, unsafe);
                log.info("{}", array.address);
            }
            {
                OffHeapArray array = new OffHeapArray(200, unsafe);
                for (int i = 0; i < array.size; i++) {
                    array.set(i, (byte) 3);
                    assert 3 == array.get(i);
                }
            }
        }
        {
            // out of memory
            // unsafe.allocateMemory(Integer.MAX_VALUE);
            // unsafe.allocateMemory(Integer.MAX_VALUE);
        }
        {
            // cas operation
            IntStream.range(0, 5).parallel().forEach(i -> {
                log.info("{}", i);
            });
            IntStream.rangeClosed(0, 10).forEach(i -> {
                log.info("{}", i);
            });

            int threads = 1000;
            int increment = 1000;
            ExecutorService service = Executors.newFixedThreadPool(threads);
            CASCounter counter = new CASCounter(unsafe);
            IntStream.range(0, threads).forEach(i -> {
                service.submit(() -> {
                    IntStream.range(0, increment).forEach(j -> {
                        counter.increment();
                    });
                });
            });
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
            log.info("{}", counter.counter);
        }
        {
            // test volatile
            ExecutorService executor = Executors.newFixedThreadPool(2);
            CASCounter counter = new CASCounter(unsafe);
            executor.execute(() -> {
                while (true) {
                    log.info("{}", counter.counter);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // noop
                    }
                }
            });
            executor.execute(() -> {
                IntStream.range(0, 50).forEach(i -> {
                    counter.increment();
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // noop
                    }
                });
            });
            executor.shutdown();
            executor.awaitTermination(2, TimeUnit.SECONDS);
        }
    }

    class InitializationOrdering {
        long a;

        public InitializationOrdering() {
            this.a = 1;
        }
    }

    // test memory allocate
    class OffHeapArray {
        private final long size;
        private final long address;
        private final Unsafe unsafe;

        public OffHeapArray(long size, Unsafe unsafe) {
            this.size = size;
            this.unsafe = unsafe;
            this.address = unsafe.allocateMemory(size);
        }

        public void set(long i, byte value) {
            unsafe.putByte(address + i, value);
        }

        public int get(long i) {
            return unsafe.getByte(address + i);
        }

        public long size() {
            return size;
        }

        public void freeMemory() {
            unsafe.freeMemory(address);
        }
    }

    class CASCounter {
        private final Unsafe unsafe;
        private final long offset;
        private volatile long counter = 0;

        public CASCounter(Unsafe unsafe) throws NoSuchFieldException {
            this.unsafe = unsafe;
            this.offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
        }

        public void increment() {
            long before = counter;
            while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
                before = counter;
            }
        }
    }
}
