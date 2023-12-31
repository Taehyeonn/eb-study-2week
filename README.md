
# 2주차: Servlet을 이용한 MODEL-2 게시판 만들기
사용기술: java 11, jsp, mysql, mybatis 3.5.14

[1주차: JSP를 이용한 MODEL-1 게시판 만들기](https://github.com/Taehyeonn/eb-study-1week)

## 코드리뷰

### 프론트 컨트롤러

- 파라미터를 추출해 넘겨주지 말고 request, response를 직접 넘겨주는 게 더 효율적이다
- get/post 방식을 구분해서 받자
- 뷰에 보낼 때도 forward/redirect 구분해서 보내자

### 컨트롤러

- 역할을 잘 정의하자. 컨트롤러는 해당하는 파라미터를 받아서 서비스에 전달하고 다시 돌려받는 역할만 한다
- 로직 실패 시 HTTP 메세지 스펙에 맞춰 오류페이지를 띄우자

### util

- 주어진 일만 수행하는 독립된 메서드로 구성하자

### 공통

- 함수명, 메서드명을 명확히 구분하자
- log, 디버그 모드 습관들이자
- 모든 메서드 단위에 주석 쓰자

## 후기

- 컨트롤러와 뷰가 합쳐있던 1주 차 MODEL-1에 비해 코드가 깔끔해졌다. 그만큼 더 잘게 나누었기에 전체적인 흐름을 파악하는 것이 중요해졌다고 생각한다. 내가 짠 코드니까 지금 당장은 잘 알겠지만 시간이 지나고 다시 봤을 때를 위해 주석 다는 습관을 들여야겠다. 흐름을 파악하기 위한 방법들은 많지만 지금 당장 할 수 있는 건 주석을 이용해서 내 프로젝트를 처음 본 사람도 코드를 직접 읽지 않고 빠르게 이해하게 만드는 것이다.
- 프로젝트 세팅하는 시간이 생각보다 많이 들었으나 1주 차 때 얻은 교훈을 바탕으로 시간 배분에 신경 썼더니 무사히 완료할 수 있었다
- 스프링이 자동으로 제공해주는 기능들이 어떻게 동작하고, 어떻게 생겨났고, 이로써 얼마나 편해졌는지 몸소 깨닫는 시간이었다.
