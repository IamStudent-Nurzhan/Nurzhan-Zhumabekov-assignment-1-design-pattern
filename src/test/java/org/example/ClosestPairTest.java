package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ClosestPairTest {
    @Test
    public void testSmall() {
        List<ClosestPair.Point> pts = Arrays.asList(
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(3, 4),
                new ClosestPair.Point(7, 1),
                new ClosestPair.Point(1, 1)
        );

        double fast = ClosestPair.solve(new ArrayList<>(pts), new Metrics());
        double slow = ClosestPairNaive.solve(new ArrayList<>(pts), new Metrics());

        assertEquals(slow, fast, 1e-9);
    }

    @Test
    public void testRandom() {
        Random rand = new Random();
        for (int t = 0; t < 20; t++) {
            List<ClosestPair.Point> pts = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                pts.add(new ClosestPair.Point(rand.nextInt(1000), rand.nextInt(1000)));
            }

            double fast = ClosestPair.solve(new ArrayList<>(pts), new Metrics());
            double slow = ClosestPairNaive.solve(new ArrayList<>(pts), new Metrics());

            assertEquals(slow, fast, 1e-9);
        }
    }
}

