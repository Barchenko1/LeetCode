package com.test.leetcode.medium;

import com.test.leetcode.util.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }

    private void addNode(Node newNode) {
        Node temp = head.next;

        newNode.next = temp;
        newNode.prev = head;

        head.next = newNode;
        temp.prev = newNode;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            map.remove(key);
            removeNode(curr);
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }


        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addNode(newNode);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node resultNode = map.get(key);
            int value = resultNode.value;
            map.remove(key);
            removeNode(resultNode);
            addNode(resultNode);
            map.put(key, head.next);
            return value;
        }
        return -1;
    }

    @Test
    public void test1() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}

        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

//    @Test
//    public void test2() {
//        int[] result = new int[] {1,2};
//        Assertions.assertArrayEquals(result, twoSum(new int[]{3,2,4}, 6));
//        Assertions.assertArrayEquals(result, twoSum2(new int[]{3,2,4}, 6));
//    }
//
//    @Test
//    public void test3() {
//        int[] result = new int[] {0,1};
//        Assertions.assertArrayEquals(result, twoSum(new int[]{3,3}, 6));
//        Assertions.assertArrayEquals(result, twoSum2(new int[]{3,3}, 6));
//    }
}
