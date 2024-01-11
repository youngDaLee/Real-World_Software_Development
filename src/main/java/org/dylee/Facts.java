package org.dylee;

import java.util.HashMap;
import java.util.Map;

/**
 * 비즈니스 규칙 엔진 일부의 필요한 상태
 */
public class Facts {
    private final Map<String, String> facts = new HashMap<>();

    public String getFact(final String name) {
        return this.facts.get(name);
    }

    public void addFact(final String name, final String value) {
        this.facts.put(name, value);
    }
}
