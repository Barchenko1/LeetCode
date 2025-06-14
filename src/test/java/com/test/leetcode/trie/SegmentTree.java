package com.test.leetcode.trie;

public class SegmentTree {
    int sum;
    SegmentTree left;
    SegmentTree right;
    int L;
    int R;

    public SegmentTree(int sum, int l, int r) {
        this.sum = sum;
        L = l;
        R = r;
    }
    
    public static SegmentTree build(int[] nums, int L, int R) {
        if (L == R) {
            return new SegmentTree(nums[L], L, R);
        }
        int M = (L + R) / 2;
        SegmentTree root = new SegmentTree(0, L, M);
        root.left = build(nums, L, M);
        root.right = build(nums, M + 1, R);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int i, int val) {
        if (this.L == this.R) {
            this.sum = val;
            return;
        }

        int M = (L + R) / 2;
        if (i > M) {
            this.right.update(i, val);
        } else {
            this.left.update(i, val);
        }
        this.sum = this.left.sum + this.right.sum;
    }

    public int rangeQuery(int L, int R) {
        if (L == this.L && R == this.R) {
            return this.sum;
        }
        int M = (L + R) / 2;
        if (L > M) {
            return this.right.rangeQuery(L, R);
        } else if (R <= M) {
            return this.left.rangeQuery(L, R);
        } else {
            return (this.left.rangeQuery(L, M) + this.right.rangeQuery(M + 1, R));
        }
    }
}
