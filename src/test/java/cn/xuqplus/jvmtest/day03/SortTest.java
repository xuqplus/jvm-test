package cn.xuqplus.jvmtest.day03;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {
  private static int[] target = {10, 8, 20, 15, 16, 17, 1, 5, 9, 9, 2, 4, 3};
  private static Integer[] integers = {10, 8, 20, 15, 16, 17, 1, 5, 9, 9, 2, 4, 3};
  private static Object[] OS = {10, 8, 20, 15, 16, 17, 1, 5, 9, 9, 2, 4, 3};

  public static final void log(Object o) {
    if (null != o && o.getClass().isArray()) {
    } else {
      System.out.println(String.valueOf(o));
    }
  }

  @Test
  public void a() {
    Object[] os = new A<>().f(Object.class, OS);
    System.out.println(Arrays.toString(es(Integer.class, integers)));
  }

  public static class A<T> {
    public T[] f(Class<T> clazz, Object o) {
      T[] r = (T[]) o;
      return r;
    }
  }

  public static <E> E[] es(E e, Object o) {
    if (o.getClass().isArray()) {
      E[] es = (E[]) o;
      return es;
    }
    return null;
  }
}
