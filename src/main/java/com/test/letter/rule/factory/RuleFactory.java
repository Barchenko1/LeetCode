package com.test.letter.rule.factory;

import com.test.letter.rule.IRule;
import com.test.letter.rule.finalletter.LetterCanBeOnEndOfWordRule;
import com.test.letter.rule.follower.FollowerRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleFactory implements IRuleFactory {

    private final Map<String, IRule> ruleMap;

    public RuleFactory() {
        this.ruleMap = new HashMap<>(){{
            put("followerRule", new FollowerRule());
            put("finalLetter", new LetterCanBeOnEndOfWordRule());
        }};
    }

    @Override
    public List<IRule> getRuleList() {
        return new ArrayList<>(ruleMap.values());
    }

    @Override
    public IRule getRule(String ruleName) {
        return ruleMap.get(ruleName);
    }
}
