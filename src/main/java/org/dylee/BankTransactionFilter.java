package org.dylee;

/**
 * BankTransaction 선택 조건을 결정
 */
@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
