# 상황
* unclosed character class near index 0
* 오류발생

### 원인
* 괄호문자를 제대로 안닫아서 나는 문제
* e.g. hi.split("![");등으로 오류가 남


### 해결
* hi.split("!\\["); 등으로 처리해줍시다.
