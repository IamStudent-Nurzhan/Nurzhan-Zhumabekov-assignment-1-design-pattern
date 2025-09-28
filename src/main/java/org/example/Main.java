package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 1000;
        int[] arr = rand.ints(n, 0, 10000).toArray();

        Metrics m = new Metrics();

        // MergeSort
        int[] copy1 = Arrays.copyOf(arr, arr.length);
        m.reset();
        MergeSort.sort(copy1, m);
        System.out.println("MergeSort:");
        System.out.println("cmp=" + m.getCmp() + " writes=" + m.getWrite());

        // QuickSort
        int[] copy2 = Arrays.copyOf(arr, arr.length);
        m.reset();
        QuickSort.sort(copy2, m);
        System.out.println("QuickSort:");
        System.out.println("cmp=" + m.getCmp() + " writes=" + m.getWrite() +
                " maxDepth=" + m.getMaxDepth());

        // Select (найдём k-й элемент)
        int k = n / 2;
        int[] copy3 = Arrays.copyOf(arr, arr.length);
        m.reset();
        int kth = Select.kth(copy3, k, m);
        System.out.println("Select:");
        System.out.println("k=" + k + " value=" + kth +
                " cmp=" + m.getCmp() + " writes=" + m.getWrite());

        // Closest Pair
        List<ClosestPair.Point> pts = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            pts.add(new ClosestPair.Point(rand.nextInt(1000), rand.nextInt(1000)));
        }
        m.reset();
        double d = ClosestPair.solve(pts, m);
        System.out.println("Closest Pair:");
        System.out.println("dist=" + d + " cmp=" + m.getCmp());
    }
}
