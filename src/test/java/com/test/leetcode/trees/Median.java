package com.test.leetcode.trees;

import java.util.Collections;
import java.util.PriorityQueue;

public class Median {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public Median() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
    }

    public void invert(int num) {
        small.add(num);
        int val;
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            val = small.poll();
            large.add(val);
        }
        if (small.size() > large.size() + 1) {
            val = small.poll();
            large.add(val);
        }
        if (large.size() > small.size() + 1) {
            val = large.poll();
            small.add(val);
        }
    }

    public double getMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}
