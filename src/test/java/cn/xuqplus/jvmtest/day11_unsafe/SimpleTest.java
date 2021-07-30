package cn.xuqplus.jvmtest.day11_unsafe;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

@Slf4j
public class SimpleTest {

    @Test
    void unsafe() {
        Unsafe unsafe = UnsafeUtils.getUnsafe();
    }
}
