package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void testQuickSortSimple() {
        int[] arr = {8, 4, 7, 2, 5};
        int[] expected = {2, 4, 5, 7, 8};
        QuickSort.sort(arr, new Metrics());  // передаём Metrics
        assertArrayEquals(expected, arr);
    }
}
