# Real-World_Software_Development
실전자바프로그래밍 실습 코드

## ch04 문서 관리 시스템
* 리스코프 치환 원칙
* 상속보다 조합

### 요구사항
* 문서를관리하고 필요한 정보를 빨리 찾을 수 있는 시스템
* 기존 환자 정보 파일을 읽어 색인 추가하고 검색할 수 있는 형태 정보로 변환
  * 리포트 : 환자의 수술과 관련된 상담 내용을 기록한 본문
  * 우편물 : 특정 주소로 발송되는 텍스트 문서
  * 이미지 : 치아와 잇몸 엑스레이 사진을 저장. 용량이 크다
  * 각각의 문서는 파일 경로, 어떤 환자 기록물인지도 포함해야 함.
  * 다양한 종류의 문서에서 측정 정보를 포함하는 문서를 찾아 검색...
  * 추후 다른 문서 추가
