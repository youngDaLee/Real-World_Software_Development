package org.dylee;

@FunctionalInterface
public interface BankTransactionsSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
