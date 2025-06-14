package com.test.leetcode.trie;

public class Trie {
    private TrieNode root;

    public Trie(TrieNode root) {
        this.root = root;
    }

    private void insert(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    private boolean search(String word) {
        TrieNode cur = this.root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isWord;
    }

    private boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
