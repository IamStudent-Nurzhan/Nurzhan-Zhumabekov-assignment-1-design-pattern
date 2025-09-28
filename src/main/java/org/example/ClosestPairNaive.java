package org.example;

import java.util.List;

public class ClosestPairNaive {
    public static double solve(List<ClosestPair.Point> pts, Metrics m) {
        double best = Double.MAX_VALUE;
        for (int i = 0; i < pts.size(); i++) {
            for (int j = i + 1; j < pts.size(); j++) {
                m.cmp();
                double d = Math.hypot(pts.get(i).x - pts.get(j).x, pts.get(i).y - pts.get(j).y);
                if (d < best) best = d;
            }
        }
        return best;
    }
}
