package com.test.leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsetsWithDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curSet = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();
        helper2(0, nums, curSet, subsets);
        return subsets;
    }

    private void helper2(int i, int[] nums, List<Integer> curSet, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }
        curSet.add(nums[i]);
        helper2(i + 1, nums, curSet, subsets);
        curSet.remove(curSet.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        helper2(i + 1, nums, curSet, subsets);
    }
}
