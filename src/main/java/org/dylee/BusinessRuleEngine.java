package org.dylee;

import java.util.ArrayList;
import java.util.List;

/**
 * 기본 기능 API
 */
public class BusinessRuleEngine {
    private final List<Action> actions;
    public final Facts facts;

    public BusinessRuleEngine(final Facts facts) {
        this.facts = facts;
        this.actions = new ArrayList<>();
    }

    public void addAction(final Action action) {
        this.actions.add(action);
    }

    public int count() {
        return this.actions.size();
    }

    public void run() {
        this.actions.forEach(action -> action.execute(facts));
    }
}
