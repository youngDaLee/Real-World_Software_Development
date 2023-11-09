package ch02;

public class MainApplication {
    public static void main(String[] args) {
        final BankTransactionAnalyzer bankTransactionAnalyzer
                = new BankTransactionAnalyzer();
        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        bankTransactionAnalyzer.analyze(args[0], bankStatementParser);
    }
}
