package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class QuickSortDepthTest {
    @Test
    public void testRecursionDepth() {
        Random rand = new Random();
        int n = 10000;
        int[] arr = rand.ints(n, 0, 100000).toArray();
        Metrics m = new Metrics();

        QuickSort.sort(arr, m);

        // Теоретическая верхняя граница: ≈ 2*log2(n)
        int bound = 2 * (int)(Math.log(n) / Math.log(2)) + 5;
        assertTrue(m.getMaxDepth() <= bound,
                "Recursion depth too large: " + m.getMaxDepth() + " > " + bound);
    }
}
