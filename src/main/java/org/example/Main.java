package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Metrics m = new Metrics();

        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
        QuickSort.sort(arr, m);
        System.out.println("QuickSort: " + Arrays.toString(arr));

        m.reset();
        int[] arr2 = {5, 3, 8, 4, 2, 7, 1, 6};
        int kth = Select.kth(arr2, 3, m);
        System.out.println("3rd smallest (Select): " + kth);

        m.reset();
        List<ClosestPair.Point> pts = List.of(
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(1,1),
                new ClosestPair.Point(2,2),
                new ClosestPair.Point(5,5)
        );
        double d = ClosestPair.solve(new ArrayList<>(pts), m);
        System.out.println("Closest pair distance: " + d);
    }
}
