package org.dylee;

/**
 * 규칙 정의한 인터페이스
 */
@FunctionalInterface
public interface Rule {
    void execute(Facts facts);
}
