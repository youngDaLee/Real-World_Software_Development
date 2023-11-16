package org.dylee;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        BankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }
}