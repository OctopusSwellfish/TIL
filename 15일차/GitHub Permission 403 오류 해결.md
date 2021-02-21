# 깃 Permission 403 오류

여느때처럼 프로젝트에 커밋하고 remote 브랜치로 합병하려고 했는데 아래와 같은 오류가 났다.



```
remote: Permission to HorangIT/HorangIT.git denied to OctopusSwellfish.
fatal: unable to access 'https://github.com/HorangIT/HorangIT.git/': The requested URL returned error: 403
```



### 오류가 나는 원인

1. 원래 매번 이 프로젝트를 작업하던 컴퓨터가 있었는데 그 컴퓨터가 아니고 다른 컴퓨터로 작업을 하니까 오류가 났다.
2. gitlab 과 github 주소가 달랐는데 git bash 에서 gitlab 주소의 아이디를 찾아서 쓰니까 오류가 난거였다.

---

# 해결 방법(Only for Windows)

* 윈도우 제어판에서 누르고 자격 증명 관리자를 검색한다.
* 웹 자격 증명/Windows 자격 증명 키가 2개가 있을 텐데, Windows 자격 증명 버튼을 누른다.
* 밑에 일반 자격 증명에 보면 gitlab과 github에 대한 인증정보가 있을 텐데 해당하는 프로젝트에 맞는 곳의 자격 증명을 눌러서 아이디랑 비밀번호를 편집했다.

