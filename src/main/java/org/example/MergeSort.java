package org.example;

public class MergeSort {
    private static final int CUTOFF = 10; // маленький порог для вставок

    public static void sort(int[] a, Metrics m) {
        int[] buf = new int[a.length];
        mergeSort(a, 0, a.length, buf, m);
    }

    private static void mergeSort(int[] a, int l, int r, int[] buf, Metrics m) {
        m.enter();
        int n = r - l;
        if (n <= CUTOFF) {
            insertion(a, l, r, m);
            m.exit();
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(a, l, mid, buf, m);
        mergeSort(a, mid, r, buf, m);

        m.cmp();
        if (a[mid - 1] <= a[mid]) { m.exit(); return; }

        merge(a, l, mid, r, buf, m);
        m.exit();
    }

    private static void insertion(int[] a, int l, int r, Metrics m) {
        for (int i = l + 1; i < r; i++) {
            int x = a[i];
            int j = i - 1;
            while (j >= l && a[j] > x) {
                m.cmp();
                a[j + 1] = a[j];
                m.write();
                j--;
            }
            a[j + 1] = x;
            m.write();
        }
    }

    private static void merge(int[] a, int l, int mid, int r, int[] buf, Metrics m) {
        int i = l, j = mid, k = 0;
        while (i < mid && j < r) {
            m.cmp();
            if (a[i] <= a[j]) buf[k++] = a[i++];
            else buf[k++] = a[j++];
            m.write();
        }
        while (i < mid) { buf[k++] = a[i++]; m.write(); }
        while (j < r) { buf[k++] = a[j++]; m.write(); }

        for (int t = 0; t < k; t++) a[l + t] = buf[t];
    }
}
