package com.test.letter.rule.follower;

import com.test.letter.rule.IRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FollowerRule implements IRule {

    private final Map<Character, Set<String>> characterFlollowersMap;

    public FollowerRule() {
        this.characterFlollowersMap = new HashMap<>() {{
            put('a', Set.of("a", "b", "d"));
            put('b', Set.of("a", "f"));
            put('c', Set.of("a"));
        }};
    }

    @Override
    public boolean isValid(String word) {
        boolean result = false;
        for (int i = 0; i < word.length() - 1; i++) {
            char letter = word.charAt(i);
            Set<String> allowFollowers = characterFlollowersMap.get(letter);
            char nextLetter = word.charAt(i + 1);
            result = allowFollowers.contains(nextLetter);
        }
        return result;
    }
}
