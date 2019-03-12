package cn.xuqplus.jvmtest.day02;

import org.junit.Test;

public class RuntimeTest {

  /**
   * 只在windows操作系统下有效, 作用: 打开记事本
   */
  @Test
  public void aVoid() {
    Runtime r = Runtime.getRuntime();
    Process p = null;
    try {
      p = r.exec("notepad");
    } catch (Exception e) {
      System.out.println("Error executing notepad.");
    }
  }

  @Test
  public void a0() {
    Runtime r = Runtime.getRuntime();
    Process p = null;
    try {
      p = r.exec("notepad");
      p.waitFor();
    } catch (Exception e) {
      System.out.println("Error executing notepad.");
    }
    System.out.println("记事本关闭了..");
  }

  @Test
  public void a1() {
    Runtime r = Runtime.getRuntime();
    Process p = null;
    try {
      p = r.exec("notepad");
      p.waitFor();
      p.getInputStream().read(new byte[]{'a', 'b', 'c'});
      p.getOutputStream().write(new byte[]{'a', 'b', 'c'});
    } catch (Exception e) {
      System.out.println("Error executing notepad.");
    }
    System.out.println("记事本关闭了..");
  }
}
