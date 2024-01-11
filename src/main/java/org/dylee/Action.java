package org.dylee;

/**
 * 다양한 액션 구현 가능하도록 액션 인터페이스 정의
 * - 비즈니스 규칙 엔진과 액션 결합 제거 위함
 */
@FunctionalInterface
public interface Action {
    void execute();
}
