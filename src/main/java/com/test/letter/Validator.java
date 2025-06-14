package com.test.letter;

import com.test.letter.rule.IRule;
import com.test.letter.rule.factory.IRuleFactory;
import com.test.letter.rule.factory.RuleFactory;

import java.util.List;

public class Validator implements IValidator {

    private final IRuleFactory ruleFactory;

    public Validator() {
        this.ruleFactory = new RuleFactory();
    }

    public boolean IsValid(String word) {
        List<IRule> ruleList = ruleFactory.getRuleList();
        boolean result = false;
        for (IRule rule : ruleList) {
            result = rule.isValid(word);
            if (!result) {
                break;
            }
        }
        return result;
    }
}
