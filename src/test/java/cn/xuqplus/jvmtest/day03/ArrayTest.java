package cn.xuqplus.jvmtest.day03;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {
  private static int[] ints = {10, 8, 20, 15, 16, 17, 1, 5, 9, 9, 2, 4, 3};
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
//    System.out.println(Arrays.toString(es(int.class, ints)));
    System.out.println(Arrays.toString(es(Integer.class, integers)));
  }

  public static class A<T> {
    public T[] f(Class<T> clazz, Object o) {
      T[] r = (T[]) o;
      return r;
    }
  }

  /**
   * 泛型方法 对象转数组
   *
   * @param e
   * @param o
   * @param <E>
   * @return
   */
  public static <E> E[] es(E e, Object o) {
    if (o.getClass().isArray()) {
      E[] es = (E[]) o;
      return es;
    }
    return null;
  }

  /**
   * int数组是对象吗
   * 基本类型数组是对象也
   */
  @Test
  public void isIntArrayObject() {
    int[] ints = {1, 2, 3};
    Assert.assertTrue(ints instanceof Object);
  }

  /**
   * int数组是对象吗
   */
  @Test
  public void isIntArrayObject2() {
    int[] ints = null;
    Object o = new int[]{1, 2, 3};
    ints = (int[]) o;
    Assert.assertTrue(ints instanceof Object);
  }

  @Test
  public void isIntArrayObject3() {
    int[] ints = null;
    Object o = new int[]{1, 2, 3};
    ints = (int[]) o;
    Assert.assertTrue(ints instanceof Object);
  }

  /**
   * 数组类型相同吗
   */
  @Test
  public void isArrayObjectTheSame() {
    int[] ints = new int[]{};
    int[] ints2 = new int[]{};
    int[][] ints3 = new int[][]{};
    char[] chars = new char[]{};
    Integer[] integers = new Integer[]{};
    Assert.assertTrue(ints.getClass().equals(ints2.getClass()));
    Assert.assertFalse(ints.getClass().equals(ints3.getClass()));
    Assert.assertFalse(ints.getClass().equals(chars.getClass()));
    Assert.assertFalse(ints.getClass().equals(integers.getClass()));
    Assert.assertFalse(chars.getClass().equals(integers.getClass()));
  }

  @Test
  public void a2() {
    int[][] a = {{1, 2}, {3, 4}, {5, 6}};
    System.out.println(a[0]);
    System.out.println(a[0][0]);
    System.out.println(a[0][1]);
    System.out.println(a[1][0]);
    System.out.println(a[1][1]);
    System.out.println(a[2][0]);
    System.out.println(a[2][1]);

    int[][][] b = {{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}},
            {{9, 10, 11}, {12, 13, 14}, {15, 16, 17}},
            {{18, 19, 20}, {21, 22, 23}, {24, 25, 26}}};
    System.out.println(b[0]);
    System.out.println(b[0][0]);
    System.out.println(b[0][0][0]);
    System.out.println(b[0][0][1]);
    System.out.println(b[0][0][2]);
    System.out.println(b[0][1][0]);
    System.out.println(b[0][1][1]);
    System.out.println(b[0][1][2]);
    System.out.println(b[0][2][0]);
    System.out.println(b[0][2][1]);
    System.out.println(b[0][2][2]);
  }
}
