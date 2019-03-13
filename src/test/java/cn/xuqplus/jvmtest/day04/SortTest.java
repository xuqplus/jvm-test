package cn.xuqplus.jvmtest.day04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortTest {

  private static int[] ints = {10, 8, 20, 15, 16, 17, 1, 5, 9, 9, 2, 4, 3};

  private static final void log(Object o) {
    if (o.getClass().isArray()) {
      try {
        System.out.println(Arrays.toString((Object[]) o));
      } catch (Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < Array.getLength(o) - 1; i++) {
          sb.append(Array.get(o, i)).append(", ");
        }
        sb.append(Array.get(o, Array.getLength(o) - 1) + "]");
        System.out.println(sb.toString());
      }
    }
  }

  @Before
  public void before() {
    log(ints);
  }

  @After
  public void after() {
    log(ints);
  }

  /**
   * 冒泡
   */
  @Test
  public void a() {
    int flag;
    for (int i = 0; i < ints.length; i++) {
      for (int j = i + 1; j < ints.length; j++) {
        if (ints[i] > ints[j]) {
          flag = ints[i];
          ints[i] = ints[j];
          ints[j] = flag;
        }
      }
    }
  }

  /**
   * 选择
   */
  @Test
  public void b() {
    int flag;
    for (int i = 0; i < ints.length; i++) {
      flag = i;
      for (int j = i + 1; j < ints.length; j++) {
        if (ints[flag] < ints[j]) {
          flag = j;
        }
      }
      if (flag != i) {
        int t = ints[flag];
        ints[flag] = ints[i];
        ints[i] = t;
      }
    }
  }
}
