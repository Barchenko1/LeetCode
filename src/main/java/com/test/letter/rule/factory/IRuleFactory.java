package com.test.letter.rule.factory;

import com.test.letter.rule.IRule;

import java.util.List;

public interface IRuleFactory {
    List<IRule> getRuleList();
    IRule getRule(String ruleName);
}
