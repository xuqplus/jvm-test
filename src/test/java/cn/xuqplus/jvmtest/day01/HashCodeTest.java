package cn.xuqplus.jvmtest.day01;

import org.junit.Test;

public class HashCodeTest {

  @Test
  public void a123() {
    System.out.println(System.identityHashCode(1));
    System.out.println(System.identityHashCode(2));
    System.out.println(System.identityHashCode(3));
    System.out.println(System.identityHashCode(1));
    System.out.println(System.identityHashCode(2));
    System.out.println(System.identityHashCode(3));
  }

  @Test
  public void a1d0() {
    System.out.println(System.identityHashCode(1.0));
    System.out.println(System.identityHashCode(1.0));
    System.out.println(System.identityHashCode(1.0));
  }

  @Test
  public void a127() {
    System.out.println(System.identityHashCode(127));
    System.out.println(System.identityHashCode(127));
    System.out.println(System.identityHashCode(127));
  }

  @Test
  public void a128() {
    System.out.println(System.identityHashCode(128));
    System.out.println(System.identityHashCode(128));
    System.out.println(System.identityHashCode(128));
  }

  @Test
  public void a129() {
    System.out.println(System.identityHashCode(129));
    System.out.println(System.identityHashCode(129));
    System.out.println(System.identityHashCode(129));
  }

  @Test
  public void a_129() {
    System.out.println(System.identityHashCode(-129));
    System.out.println(System.identityHashCode(-129));
    System.out.println(System.identityHashCode(-129));
  }

  @Test
  public void a_128() {
    System.out.println(System.identityHashCode(-128));
    System.out.println(System.identityHashCode(-128));
    System.out.println(System.identityHashCode(-128));
  }

  @Test
  public void a0() {
    System.out.println(System.identityHashCode(0));
    System.out.println(System.identityHashCode(0));
    System.out.println(System.identityHashCode(0));
  }

  @Test
  public void string0() {
    System.out.println(System.identityHashCode(""));
    System.out.println(System.identityHashCode(""));
    System.out.println(System.identityHashCode(""));
  }

  @Test
  public void string1() {
    System.out.println(System.identityHashCode("a"));
    System.out.println(System.identityHashCode("a"));
    System.out.println(System.identityHashCode("a"));
  }

  @Test
  public void string2() {
    System.out.println(System.identityHashCode("abc"));
    System.out.println(System.identityHashCode("abc"));
    System.out.println(System.identityHashCode("abc"));
  }

  @Test
  public void string3() {
    System.out.println(System.identityHashCode("abc"));
    System.out.println(System.identityHashCode(String.valueOf("abc")));
    System.out.println(System.identityHashCode(new String("abc")));
    String a = "abc";
    String b = new String(a);
    String c = new String(b);
    System.out.println(System.identityHashCode(a));
    System.out.println(System.identityHashCode(b));
    System.out.println(System.identityHashCode(c));
  }

  @Test
  public void string4() {
    String a = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
    String b = new String(a);
    String c = new String(b);
    System.out.println(System.identityHashCode("abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc"));
    System.out.println(System.identityHashCode(a));
    System.out.println(System.identityHashCode(b));
    System.out.println(System.identityHashCode(c));
    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
    System.out.println(c.hashCode());
  }

  @Test
  public void string5() {
    String a = "abcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabcabc";
    String b = new String(a);
    String c = new String(b);
    StringBuilder sb0 = new StringBuilder(a);
    StringBuilder sb1 = new StringBuilder(b);
    StringBuilder sb2 = new StringBuilder(c);
    System.out.println(System.identityHashCode(sb0.toString()));
    System.out.println(System.identityHashCode(sb1.toString()));
    System.out.println(System.identityHashCode(sb2.toString()));
    System.out.println(sb0.hashCode());
    System.out.println(sb1.hashCode());
    System.out.println(sb2.hashCode());

    String d0 = sb0.toString();
    String d1 = sb1.toString();
    String d2 = sb2.toString();

    System.out.println(d0.hashCode());
    System.out.println(d1.hashCode());
    System.out.println(d2.hashCode());
    System.out.println(System.identityHashCode(d0));
    System.out.println(System.identityHashCode(d1));
    System.out.println(System.identityHashCode(d2));
  }
}
