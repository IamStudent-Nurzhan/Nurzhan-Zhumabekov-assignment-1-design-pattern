package org.example;

public class Metrics {
    private int depth = 0;
    private int maxDepth = 0;
    private int cmp = 0;
    private int write = 0;

    public void enter() {
        depth++;
        if (depth > maxDepth) maxDepth = depth;
    }

    public void exit() {
        depth--;
    }

    public void cmp() {
        cmp++;
    }

    public void write() {
        write++;
    }

    public int getCmp() {
        return cmp;
    }

    public int getWrite() {
        return write;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void reset() {
        depth = 0;
        maxDepth = 0;
        cmp = 0;
        write = 0;
    }
}
