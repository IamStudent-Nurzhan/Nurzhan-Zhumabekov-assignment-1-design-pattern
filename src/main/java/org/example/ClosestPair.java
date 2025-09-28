package org.example;

import java.util.*;

public class ClosestPair {
    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }


    public static double solve(List<Point> pts, Metrics m) {
        pts.sort(Comparator.comparingDouble(p -> p.x));
        return rec(pts, 0, pts.size(), m);
    }


    public double closest(int[][] points) {
        List<Point> pts = new ArrayList<>();
        for (int[] p : points) {
            pts.add(new Point(p[0], p[1]));
        }
        return solve(pts, new Metrics());
    }

    private static double rec(List<Point> pts, int l, int r, Metrics m) {
        m.enter();
        int n = r - l;
        if (n <= 3) {
            double best = Double.MAX_VALUE;
            for (int i = l; i < r; i++)
                for (int j = i + 1; j < r; j++)
                    best = Math.min(best, dist(pts.get(i), pts.get(j), m));
            m.exit();
            return best;
        }
        int mid = (l + r) / 2;
        double xMid = pts.get(mid).x;
        double d = Math.min(rec(pts, l, mid, m), rec(pts, mid, r, m));

        List<Point> strip = new ArrayList<>();
        for (int i = l; i < r; i++)
            if (Math.abs(pts.get(i).x - xMid) <= d) strip.add(pts.get(i));

        strip.sort(Comparator.comparingDouble(p -> p.y));
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && j < i + 8; j++) {
                d = Math.min(d, dist(strip.get(i), strip.get(j), m));
            }
        }
        m.exit();
        return d;
    }

    private static double dist(Point a, Point b, Metrics m) {
        m.cmp();
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}
