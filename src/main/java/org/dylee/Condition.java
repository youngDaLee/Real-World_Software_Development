package org.dylee;

/**
 * 조건절만 포함하는 인터페이스
 */
@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
