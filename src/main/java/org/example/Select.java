package org.example;

import java.util.Arrays;

public class Select {
    public static int kth(int[] arr, int k, Metrics m) {
        if (k < 0 || k >= arr.length) throw new IllegalArgumentException("k out of bounds");
        return select(arr, 0, arr.length - 1, k, m);
    }

    public static int select(int[] arr, int l, int r, int k, Metrics m) {
        while (l <= r) {
            m.enter();

            if (l == r) {
                m.exit();
                return arr[l];
            }

            int pivot = medianOfMedians(arr, l, r, m);
            int pivotIndex = partition(arr, l, r, pivot, m);

            if (k == pivotIndex) {
                m.exit();
                return arr[k];
            } else if (k < pivotIndex) {
                r = pivotIndex - 1;
            } else {
                l = pivotIndex + 1;
            }

            m.exit();
        }
        return -1; // на всякий случай
    }

    private static int partition(int[] arr, int l, int r, int pivot, Metrics m) {
        int i = l, j = r;
        while (i <= j) {
            while (arr[i] < pivot) { m.cmp(); i++; }
            while (arr[j] > pivot) { m.cmp(); j--; }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                m.write();
                i++; j--;
            }
        }
        // Возвращаем индекс разделения (i - 1)
        return i - 1;
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
