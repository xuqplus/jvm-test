package cn.xuqplus.jvmtest.day03;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ArrayTest3 {
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

    @Test
    public void f() {
        int[][] intervals = new int[][]{{1, 5}, {12, 17}};
        int[] newInterval = new int[]{6, 6};
        int[][] insert = insert(intervals, newInterval);
        for (int[] i : insert) {
            log.info("{}", i);
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (null == intervals || intervals.length <= 0) {
            return new int[][]{newInterval};
        }
        if (null == newInterval || newInterval.length <= 0) {
            return intervals;
        }
        int a = intervals[0][0];
        int b = intervals[intervals.length - 1][1];
        List<int[]> r = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (is(current, newInterval)) {
                newInterval = merge(current, newInterval);
                if (-1 == index) {
                    index = i;
                }
            } else {
                r.add(current);
            }
        }
        if (-1 == index) {
            if (newInterval[1] < a) {
                r.add(0, newInterval);
            } else if (newInterval[0] > b) {
                r.add(newInterval);
            } else {
                for (int i = 0; i < r.size() - 1; i++) {
                    int[] current = r.get(i);
                    int[] next = r.get(i + 1);
                    if (current[1] < newInterval[0] && newInterval[1] < next[0]) {
                        r.add(i + 1, newInterval);
                    }
                }
            }
        } else {
            r.add(index, newInterval);
        }
        int[][] result = new int[r.size()][];
        for (int i = 0; i < r.size(); i++) {
            result[i] = r.get(i);
        }
        return result;
    }

    public static final boolean is(int[] x, int[] y) {
        int x0 = x[0], x1 = x[1], y0 = y[0], y1 = y[1];
        if (x1 < y0 || y1 < x0) {
            return false;
        }
        return true;
    }

    public static final int[] merge(int[] x, int[] y) {
        int x0 = x[0], x1 = x[1], y0 = y[0], y1 = y[1];
        return new int[]{Math.min(x0, y0), Math.max(x1, y1)};
    }
}
