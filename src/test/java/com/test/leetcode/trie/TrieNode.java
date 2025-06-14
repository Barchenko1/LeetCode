package com.test.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {
    }

    public TrieNode(boolean isWord, Map<Character, TrieNode> children) {
        this.isWord = isWord;
        this.children = children;
    }
}
