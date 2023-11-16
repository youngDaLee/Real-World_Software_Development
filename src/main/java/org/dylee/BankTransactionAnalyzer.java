package org.dylee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public static void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path); // 행 목록 가져오기

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("the total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("the total for transaction in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("the total for transaction in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("the total salary received for is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}