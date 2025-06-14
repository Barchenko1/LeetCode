package com.test.letter.rule.finalletter;

import com.test.letter.rule.IRule;

import java.util.HashMap;
import java.util.Map;

public class LetterCanBeOnEndOfWordRule implements IRule {

    private final Map<String, Boolean> isCharacterFinalMap;

    public LetterCanBeOnEndOfWordRule() {
        this.isCharacterFinalMap = new HashMap<>() {{
            put("a", true);
            put("b", false);
            put("c", true);
        }};
    }

    @Override
    public boolean isValid(String word) {
        String lastChar = word.substring(word.length() - 1);
        return isCharacterFinalMap.get(lastChar);
    }
}
