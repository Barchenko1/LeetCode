package com.test.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraTest {
    private Map<Integer, Integer> shortestPath(int[][] edges, int n, int src) {
        Map<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            int w = edge[2];
            adj.get(s).add(new Integer[]{d, w});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>();
        minHeap.add(new int[]{0, src});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int w1 = cur[0];
            int n1 = cur[1];

            if (shortest.containsKey(n1)) {
                continue;
            }
            shortest.put(n1, w1);
            for (Integer[] pear: adj.get(n1)) {
                int n2 = pear[0];
                int w2 = pear[1];
                if (!shortest.containsKey(n2)) {
                    minHeap.add(new int[]{w1+w2, n2});
                }
            }
        }


        return shortest;
    }
}
