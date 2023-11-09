package ch02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String... args) throws IOException {
        // 알게된 것 : 불변값을 명시적으로 표현할 때 final을 사용하기도 하는구나....
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions
                = bankStatementCSVParser.parseLinesFrom(lines);

        System.out.println("Total for all transaction is ");
    }

    public static double caculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }


    /**
     * 리팩터링 전 코드
     * @param args
     * @throws IOException
     */
    public static void oldMain(final String... args) throws IOException {
        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path); // 행 목록 가져오기
        double total = 0d;
        for (final String line: lines) {
            final String[] columns = line.split(","); // 콤마로 열 분리
            final double amount = Double.parseDouble(columns[1]); // 금액 추출
            total += amount; // 금액을 double로 저장
        }
        System.out.println("Total for all transaction is " + total);
    }
}
