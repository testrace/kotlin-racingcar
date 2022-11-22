# kotlin-racingcar

# 🚀 2단계 - 문자열 계산기

## 기능 요구사항
- [x] 사칙 연산 계산
  - [x] 연산자에 해당하는 계산기
    - [x] 덧셈
    - [x] 뺄셈
    - [x] 곱셈
    - [x] 나눗셈
      - [x] 0으로 나누려는 경우 연산하지 않는다.
      - [x] 소수점은 모두 무시한다.
- [x] 입력 순으로 계산 (연산 우선 순위 무시)

### 2단계 피드백
- [ ] Application의 calculate 함수를 Calculator 클래스 내부로 이동
- [ ] calculate 함수의 로컬 변수명 변경
  - inputFormula -> formula
- [ ] calculateInternal 함수의 로컬 변수명 변경
  - summary -> total
- [ ] Application 내부 메서드 순서 변경 (호출 순)
- [ ] 불필요한 변경 제거 (map)
- [x] 연산기호 객체를 표현할 수 있는 클래스명으로 변경
  - Calculator -> Operator
- [x] Scanner 대신 readln 함수 사용
- [ ] 함수에서 중괄호를 사용하는 경우 `return` 명시
- [ ] scope function 대신 Elvis operator 활용!
- [ ] 나누기 0 예외 처리를 operation 내부에서 수행하도록 변경
- [ ] InputView를 object class로 변경
