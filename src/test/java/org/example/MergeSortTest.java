package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    public void testMergeSortSimple() {
        int[] arr = {5, 2, 9, 1, 3};
        int[] expected = {1, 2, 3, 5, 9};
        MergeSort.sort(arr, new Metrics());  // передаём Metrics
        assertArrayEquals(expected, arr);
    }
}
