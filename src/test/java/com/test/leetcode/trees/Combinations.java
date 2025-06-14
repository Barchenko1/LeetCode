package com.test.leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    public List<List<Integer>> subsetsWithDuplicates(int n, int k) {
        List<List<Integer>> comb = new ArrayList<>();
        helper2(1, new ArrayList<>(), comb, n, k);
        return comb;
    }

    private void helper2(int i, List<Integer> curSet, List<List<Integer>> comb, int n, int k) {
        if (comb.size() == k) {
            comb.add(new ArrayList<>(curSet));
            return;
        }
        if (i > n) {
            return;
        }
        curSet.add(i);
        helper2(i + 1, curSet, comb, n, k);
        curSet.remove(curSet.size() - 1);
        helper2(i + 1, curSet, comb, n, k);
    }
}
