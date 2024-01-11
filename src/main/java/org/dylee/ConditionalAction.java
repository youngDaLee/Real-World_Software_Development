package org.dylee;

/** Deprecated
 * 실행/조건 분리된 인터페이스
 */
public interface ConditionalAction {
    boolean evaluate(Facts facts);
    void execute(Facts facts);
}
