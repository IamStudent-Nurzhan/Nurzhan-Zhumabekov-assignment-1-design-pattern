package org.example;

import java.util.Arrays;

public class Select {
    public static int kth(int[] arr, int k, Metrics m) {
        return select(arr, 0, arr.length - 1, k, m);
    }

    private static int select(int[] arr, int l, int r, int k, Metrics m) {
        while (true) {
            m.enter();
            if (l == r) {
                m.exit();
                return arr[l];
            }
            int pivot = medianOfMedians(arr, l, r, m);
            int pos = partition(arr, l, r, pivot, m);
            if (k == pos) {
                m.exit();
                return arr[k];
            } else if (k < pos) {
                r = pos - 1;
            } else {
                l = pos + 1;
            }
            m.exit();
        }
    }

    private static int partition(int[] arr, int l, int r, int pivot, Metrics m) {
        while (l <= r) {
            while (arr[l] < pivot) { m.cmp(); l++; }
            while (arr[r] > pivot) { m.cmp(); r--; }
            if (l <= r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                m.write();
                l++;
                r--;
            }
        }
        return l - 1;
    }

    private static int medianOfMedians(int[] arr, int l, int r, Metrics m) {
        int n = r - l + 1;
        int groups = (int) Math.ceil(n / 5.0);
        int[] medians = new int[groups];
        for (int i = 0; i < groups; i++) {
            int start = l + i * 5;
            int end = Math.min(start + 5, r + 1);
            int[] tmp = Arrays.copyOfRange(arr, start, end);
            Arrays.sort(tmp);
            medians[i] = tmp[tmp.length / 2];
        }
        if (medians.length == 1) return medians[0];
        return medianOfMedians(medians, 0, medians.length - 1, m);
    }
}
