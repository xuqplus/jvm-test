package cn.xuqplus.jvmtest.day03;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ArrayTest2 {
    private static int[] ints = {10, 8, 20, 15, 16, 17, 1, 5, 9, 9, 2, 4, 3};

    @Test
    public void a() {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};
        int[][] insert = insert(intervals, newInterval);
        for (int[] i : insert) {
            log.info("{}", i);
        }
    }

    @Test
    public void b() {
        int[][] intervals = new int[][]{};
        int[] newInterval = new int[]{4, 8};
        int[][] insert = insert(intervals, newInterval);
        for (int[] i : insert) {
            log.info("{}", i);
        }
    }

    @Test
    public void c() {
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{1, 3};
        int[][] insert = insert(intervals, newInterval);
        for (int[] i : insert) {
            log.info("{}", i);
        }
    }

    @Test
    public void d() {
        int[][] intervals = new int[][]{{1, 5}};
        int[] newInterval = new int[]{2, 7};
        int[][] insert = insert(intervals, newInterval);
        for (int[] i : insert) {
            log.info("{}", i);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (null == intervals || intervals.length <= 0) {
            return new int[][]{newInterval};
        }
        int a = newInterval[0];
        int b = newInterval[1];
        ArrayList<Integer> l = new ArrayList();
        ArrayList<Boolean> lb = new ArrayList(); // is start
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            l.add(current[0]);
            l.add(current[1]);
            lb.add(true);
            lb.add(false);
        }
        if (a < l.get(0)) {
            l.add(0, a);
            lb.add(0, null);
        } else if (a > l.get(l.size() - 1)) {
            l.add(a);
            lb.add(null);
        } else {
            for (int i = 0; i < l.size() - 1; i++) {
                if (l.get(i) < a && a <= l.get(i + 1)) {
                    l.add(i + 1, a);
                    lb.add(i + 1, null);
                    break;
                }
            }
        }
        if (b < l.get(0)) {
            l.add(0, b);
            lb.add(0, null);
        } else if (b > l.get(l.size() - 1)) {
            l.add(b);
            lb.add(null);
        } else {
            for (int i = 0; i < l.size() - 1; i++) {
                if (l.get(i) <= b && b < l.get(i + 1)) {
                    l.add(i + 1, b);
                    lb.add(i + 1, null);
                    break;
                }
            }
        }
        log.info("{}", l);
        log.info("{}", lb);
        Integer start = null;
        boolean isNullStarted = false;
        boolean isNullStopped = false;
        List<int[]> r = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (isNullStarted && !isNullStopped && null == lb.get(i)) {
                isNullStopped = true;
            }
            if (!isNullStarted && null == lb.get(i)) {
                isNullStarted = true;
            }
            if (null == start) {
                start = l.get(i);
                continue;
            }
            if (!isNullStarted) {
                r.add(new int[]{start, l.get(i)});
                start = null;
                continue;
            }
            if (!isNullStopped) {
                continue;
            }
            if (i >= l.size() - 1) {
                r.add(new int[]{start, l.get(i)});
            } else if (lb.get(i + 1)) {
                r.add(new int[]{start, l.get(i)});
            } else {
                r.add(new int[]{start, l.get(++i)});
                isNullStarted = false;
                isNullStopped = false;
            }
            start = null;
        }
        int[][] result = new int[r.size()][];
        for (int i = 0; i < r.size(); i++) {
            result[i] = r.get(i);
        }
        return result;
    }

    @Test
    public void test() {
        String a = "" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnzyis1ZjfNB0bBgKFMSv" +
                "vkTtwlvBsaJq7S5wA+kzeVOVpVWwkWdVha4s38XM/pa/yr47av7+z3VTmvDRyAHc" +
                "aT92whREFpLv9cj5lTeJSibyr/Mrm/YtjCZVWgaOYIhwrXwKLqPr/11inWsAkfIy" +
                "tvHWTxZYEcXLgAXFuUuaS3uF9gEiNQwzGTU1v0FqkqTBr4B8nW3HCN47XUu0t8Y0" +
                "e+lf4s4OxQawWD79J9/5d3Ry0vbV3Am1FtGJiJvOwRsIfVChDpYStTcHTCMqtvWb" +
                "V6L11BWkpzGXSW4Hv43qa+GSYOD2QU68Mb59oSk2OB+BtOLpJofmbGEGgvmwyCI9" +
                "MwIDAQAB" +
                "";
        String b = "" +
                "MIIEogIBAAKCAQEAnzyis1ZjfNB0bBgKFMSvvkTtwlvBsaJq7S5wA+kzeVOVpVWw" +
                "kWdVha4s38XM/pa/yr47av7+z3VTmvDRyAHcaT92whREFpLv9cj5lTeJSibyr/Mr" +
                "m/YtjCZVWgaOYIhwrXwKLqPr/11inWsAkfIytvHWTxZYEcXLgAXFuUuaS3uF9gEi" +
                "NQwzGTU1v0FqkqTBr4B8nW3HCN47XUu0t8Y0e+lf4s4OxQawWD79J9/5d3Ry0vbV" +
                "3Am1FtGJiJvOwRsIfVChDpYStTcHTCMqtvWbV6L11BWkpzGXSW4Hv43qa+GSYOD2" +
                "QU68Mb59oSk2OB+BtOLpJofmbGEGgvmwyCI9MwIDAQABAoIBACiARq2wkltjtcjs" +
                "kFvZ7w1JAORHbEufEO1Eu27zOIlqbgyAcAl7q+/1bip4Z/x1IVES84/yTaM8p0go" +
                "amMhvgry/mS8vNi1BN2SAZEnb/7xSxbflb70bX9RHLJqKnp5GZe2jexw+wyXlwaM" +
                "+bclUCrh9e1ltH7IvUrRrQnFJfh+is1fRon9Co9Li0GwoN0x0byrrngU8Ak3Y6D9" +
                "D8GjQA4Elm94ST3izJv8iCOLSDBmzsPsXfcCUZfmTfZ5DbUDMbMxRnSo3nQeoKGC" +
                "0Lj9FkWcfmLcpGlSXTO+Ww1L7EGq+PT3NtRae1FZPwjddQ1/4V905kyQFLamAA5Y" +
                "lSpE2wkCgYEAy1OPLQcZt4NQnQzPz2SBJqQN2P5u3vXl+zNVKP8w4eBv0vWuJJF+" +
                "hkGNnSxXQrTkvDOIUddSKOzHHgSg4nY6K02ecyT0PPm/UZvtRpWrnBjcEVtHEJNp" +
                "bU9pLD5iZ0J9sbzPU/LxPmuAP2Bs8JmTn6aFRspFrP7W0s1Nmk2jsm0CgYEAyH0X" +
                "+jpoqxj4efZfkUrg5GbSEhf+dZglf0tTOA5bVg8IYwtmNk/pniLG/zI7c+GlTc9B" +
                "BwfMr59EzBq/eFMI7+LgXaVUsM/sS4Ry+yeK6SJx/otIMWtDfqxsLD8CPMCRvecC" +
                "2Pip4uSgrl0MOebl9XKp57GoaUWRWRHqwV4Y6h8CgYAZhI4mh4qZtnhKjY4TKDjx" +
                "QYufXSdLAi9v3FxmvchDwOgn4L+PRVdMwDNms2bsL0m5uPn104EzM6w1vzz1zwKz" +
                "5pTpPI0OjgWN13Tq8+PKvm/4Ga2MjgOgPWQkslulO/oMcXbPwWC3hcRdr9tcQtn9" +
                "Imf9n2spL/6EDFId+Hp/7QKBgAqlWdiXsWckdE1Fn91/NGHsc8syKvjjk1onDcw0" +
                "NvVi5vcba9oGdElJX3e9mxqUKMrw7msJJv1MX8LWyMQC5L6YNYHDfbPF1q5L4i8j" +
                "8mRex97UVokJQRRA452V2vCO6S5ETgpnad36de3MUxHgCOX3qL382Qx9/THVmbma" +
                "3YfRAoGAUxL/Eu5yvMK8SAt/dJK6FedngcM3JEFNplmtLYVLWhkIlNRGDwkg3I5K" +
                "y18Ae9n7dHVueyslrb6weq7dTkYDi3iOYRW8HRkIQh06wEdbxt0shTzAJvvCQfrB" +
                "jg/3747WSsf/zBTcHihTRBdAv6OmdhV4/dD5YBfLAkLrd+mX7iE=";
        String c = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.POstGetfAytaZS82wHcjoTyoqhMyxXiWdR7Nn7A29DNSl0EiXLdwJ6xC6AfgZWF1bOsS_TuYI3OG85AmiExREkrS6tDfTQ2B3WXlrr-wp5AokiRbz3_oB4OxG-W9KcEEbDRcZc0nH3L7LzYptiy1PtAylQGxHTWZXtGz4ht0bAecBgmpdgXMguEIcoqPJ1n3pIWk_dUZegpqx0Lka21H6XxUTxiy8OcaarA8zdnPUnV6AmNP3ecFawIFYdvJB_cm-GvpCSbr8G8y_Mllj8f4x9nBH8pQux89_6gUY618iYv7tuPWBFfEbLxtF2pZS6YC1aSfLQxeNe8djT9YjpvRZA";
    }
}
