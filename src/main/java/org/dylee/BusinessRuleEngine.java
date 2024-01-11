package org.dylee;

import java.util.ArrayList;
import java.util.List;

/**
 * 기본 기능 API
 */
public class BusinessRuleEngine {
    private final List<Rule> rules;
    public final Facts facts;

    public BusinessRuleEngine(final Facts facts) {
        this.facts = facts;
        this.rules = new ArrayList<>();
    }

    public void addRule(final Rule rule) {
        this.rules.add(rule);
    }

    public int count() {
        return this.rules.size();
    }

    public void run() {
        this.rules.forEach(action -> action.execute(facts));
    }
}
