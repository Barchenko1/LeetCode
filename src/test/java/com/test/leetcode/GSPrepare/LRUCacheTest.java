package com.test.leetcode.GSPrepare;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {
    public class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public class LRUCache {
        int capacity;
        Map<Integer, Node> cache;
        Node left;
        Node right;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.left = new Node(0, 0);
            this.right = new Node(0, 0);
            this.left.next = this.right;
            this.right.prev = this.left;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                remove(node);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insert(newNode);
            if (cache.size() > capacity) {
                Node first = this.left.next;
                remove(first);
                cache.remove(first.key);
            }
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                remove(node);
                insert(node);
                return node.value;
            }

            return -1;
        }

        private void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void insert(Node node) {
            Node prev = this.right.prev;
            prev.next = node;
            node.prev = prev;
            node.next = this.right;
            this.right.prev = node;
        }
    }


    @Test
    public void test(){

    }
}
