package com.test.leetcode.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AdjacencyListTest {

    @Test
    public void test(){
        String[][] edges = {
                {"A", "B"},
                {"B", "C"},
                {"B", "E"},
                {"C", "E"},
                {"E", "D"}
        };

        // Build adjacency list
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();
        for (String[] edge : edges) {
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
        }

        int totalPaths = dfs("A", "D", adjList, new HashSet<>());
        System.out.println("✅ Total paths from A to D: " + totalPaths);
        int totalPaths1 = bfs("A", "D", adjList);
        System.out.println("✅ Shortest path from A to D: " + totalPaths1);
    }

    public int dfs(String node, String target, HashMap<String, ArrayList<String>> adjList, HashSet<String> visit) {
        if (visit.contains(node)){
            return 0;
        }
        if (node.equals(target)){
            return 1;
        }
        int count = 0;
        visit = new HashSet<>();
        visit.add(node);
        for (String neighbor: adjList.get(node)){
            count += dfs(neighbor, target, adjList, visit);
        }
        visit.remove(node);
        return count;
    }

    public int bfs(String node, String target, HashMap<String, ArrayList<String>> adjList) {
        int length = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(node);
        queue.add(node);

        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String cur = queue.peek();
                queue.poll();
                if (cur.equals(target)){
                    return length;
                }
                for (String neighbor: adjList.get(cur)){
                    if (!visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }

            length++;
        }

        return length;
    }
}
