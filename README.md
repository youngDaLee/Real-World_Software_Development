# Real-World_Software_Development
실전자바프로그래밍 실습 코드

## ch03 입출금 내역 분석기 확장판
여러 기능을 제공하는 새 버전
* OCP
* 언제 인터페이스 사용해야 좋을지 가이드라인
* 높은 결합도 피할 수 있는 기법
* 언제 API에 예외를 포함하거나 포함하지 않는... 예외 처리 기법
* 그레이들을 이용해 시스템적 빌드

### 요구사항
1. 특정 입출금 내역 검색 (ex: 주어진 날짜, 특정 범주의 입출금 내역 얻기
2. 검색 결과 요약 통계를 텍스트, HTML 등 다양항 형식으로 만들기


## ch02 입출금 내역 분석기
* 입출금 내역을 자동으로 분석해 재정 상태를 더 잘보여주는 SW
* SRP(Single Responsibility Principle, 단일 책임 원칙)
* 응집도
* 결합도

### 요구사항
입출금 내역 목록이 담긴 텍스트 파일을 읽어 분석
* 은행 입출금 내역 총 수입 & 총 지출, 결과가 양수인지 음수인지
* 특정 달에 몇 건의 입출금 내역이 발생했는지
* 지출이 가장 높은 상위 10건은 무엇인지
* 돈을 가장 많이 소비하는 항목은 무엇인지

텍스트 파일 형식
```text
30-01-2017,-100,Deliveroo
30-01-2017,-50,Tesco
01-02-2017,6000,Salary
02-02-2017,2000,Royalties
02-02-2017,-4000,Rent
03-02-2017,3000,Tesco
05-02-2017,-30,Cinema
```