## swagger 오류 (IN Spring)

* 상황 : swagger가 문제가 생겼다. 어느때처럼 서버 재시작 했는데 이 오류가 떴음.

  `[Fetching resource list: undefined; Please wait]`

* 음.. 무슨 오류지 검색했는데도 큰 해결 방법이 보이지 않았다.

---

### 해결 방법

프로젝트 내부의 `SwaggerConfig.java`를 지우고 재시작, 다시 같은 파일(`SwaggerConfig.java`)을 다시 자바 파일 만들어서 내용 똑같이 복붙해주고 저장한뒤에 서버 재시작했더니 괜찮아졌다.



식겁...
