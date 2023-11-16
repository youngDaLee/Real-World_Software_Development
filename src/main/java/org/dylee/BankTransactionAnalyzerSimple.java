package org.dylee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String... args) throws IOException {

        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path); // 행 목록 가져오기
        double total = 0d;
        for (final String line: lines) {
            final String[] columns = line.split(","); // 콤마로 열 분리
            final double amount = Double.parseDouble(columns[1]); // 금액 추출
            total += amount; // 금액을 double로 저장
        }

        System.out.println("Total for all transaction is " + total);
        /** 출시 되었을 때 이슈
         * 파일이 비어 있다면?
         * 데이터에 문제가 있어 금액 파싱하지 못하면?
         * 행의 데이터가 완벽하지 않다면?
         */
    }
}
