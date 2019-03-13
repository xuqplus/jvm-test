package cn.xuqplus.jvmtest.day04;

import org.junit.Assert;
import org.junit.Test;

public class PrimitiveTest {

  @Test
  public void a() {
    int a = 4;
    int b = 4;
    int c = a;
    Assert.assertEquals(a, b);
    Assert.assertEquals(a, c);
    Assert.assertTrue(a == b);
    Assert.assertTrue(a == c);
  }

  @Test
  public void b() {
    int a = 200;
    int b = 200;
    int c = a;
    Assert.assertEquals(a, b);
    Assert.assertEquals(a, c);
    Assert.assertTrue(a == b);
    Assert.assertTrue(a == c);
  }

  @Test
  public void c() {
    Integer a = 200;
    Integer b = 200;
    Integer c = a;
    Assert.assertEquals(a, b);
    Assert.assertEquals(a, c);
    Assert.assertFalse(a == b); // the point
    Assert.assertTrue(a == c);
  }

  @Test
  public void d() {
    Integer a = 4;
    Integer b = 4;
    Integer c = a;
    Assert.assertEquals(a, b);
    Assert.assertEquals(a, c);
    Assert.assertTrue(a == b); // the point
    Assert.assertTrue(a == c);
  }
}
