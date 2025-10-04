package algorithms;

import metrics.PerformanceTracker;

public final class InsertionSortOptimized {
    public static void sort(int[] a) { sort(a, 0, a.length - 1); }

    public static void sort(int[] a, int lo, int hi) {
        PerformanceTracker.current().enterFrame(1);
        if (hi - lo + 1 <= 1) return;
        boolean anyMove = false;
        for (int i = lo + 1; i <= hi; i++) {
            int x = a[i];
            PerformanceTracker.current().access(1);
            PerformanceTracker.current().compare();
            if (x >= a[i - 1]) { PerformanceTracker.current().access(1); continue; }
            int pos = binarySearchInsertionPoint(a, lo, i - 1, x);
            int len = i - pos;
            System.arraycopy(a, pos, a, pos + 1, len);
            PerformanceTracker.current().move(len);
            a[pos] = x;
            PerformanceTracker.current().access(len + 1);
            anyMove = true;
        }
        if (!anyMove) return;
    }

    private static int binarySearchInsertionPoint(int[] a, int lo, int hi, int key) {
        int l = lo, r = hi;
        while (l <= r) {
            int m = (l + r) >>> 1;
            PerformanceTracker.current().compare();
            PerformanceTracker.current().access(1);
            if (a[m] <= key) l = m + 1;
            else r = m - 1;
        }
        return l;
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            PerformanceTracker.current().compare();
            PerformanceTracker.current().access(2);
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }
}
