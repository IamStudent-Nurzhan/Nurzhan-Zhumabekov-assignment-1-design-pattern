package org.example;

import java.util.Random;

public class QuickSort {
    private static final int CUTOFF = 10;

    public static void sort(int[] arr, Metrics m) {
        quick(arr, 0, arr.length - 1, m, new Random());
    }

    private static void quick(int[] arr, int l, int r, Metrics m, Random rnd) {
        while (l < r) {
            m.enter();
            if (r - l < CUTOFF) {
                insertion(arr, l, r, m);
                m.exit();
                return;
            }
            int pivot = arr[l + rnd.nextInt(r - l + 1)];
            int i = l, j = r;
            while (i <= j) {
                while (arr[i] < pivot) { m.cmp(); i++; }
                while (arr[j] > pivot) { m.cmp(); j--; }
                if (i <= j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    m.write();
                    i++;
                    j--;
                }
            }
            if (j - l < r - i) {
                quick(arr, l, j, m, rnd);
                l = i;
            } else {
                quick(arr, i, r, m, rnd);
                r = j;
            }
            m.exit();
        }
    }

    private static void insertion(int[] arr, int l, int r, Metrics m) {
        for (int i = l + 1; i <= r; i++) {
            int x = arr[i];
            int j = i - 1;
            while (j >= l && arr[j] > x) {
                m.cmp();
                arr[j + 1] = arr[j];
                m.write();
                j--;
            }
            arr[j + 1] = x;
            m.write();
        }
    }
}
