package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        Metrics m = new Metrics();

        System.out.println("Before: " + Arrays.toString(arr));
        MergeSort.sort(arr, m);
        System.out.println("After:  " + Arrays.toString(arr));

        System.out.println("Comparisons: " + m.comparisons);
        System.out.println("Writes: " + m.writes);
        System.out.println("Calls: " + m.calls);
        System.out.println("Max depth: " + m.maxDepth);
    }
}
