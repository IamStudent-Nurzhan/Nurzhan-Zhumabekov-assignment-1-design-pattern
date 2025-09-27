package org.example;

public class Metrics {
    public long comparisons = 0;
    public long writes = 0;
    public long calls = 0;
    public int maxDepth = 0;
    private int depth = 0;

    public void cmp() { comparisons++; }
    public void write() { writes++; }
    public void enter() { calls++; depth++; if (depth > maxDepth) maxDepth = depth; }
    public void exit() { depth--; }
    public void reset() { comparisons = writes = calls = 0; maxDepth = depth = 0; }
}
