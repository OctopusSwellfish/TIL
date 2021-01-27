# REDIS 비밀번호 설정하기(CLI)

* 상황: Redis를 도커로 돌리는데 conf파일을 찾을 수 없어서 비번 설정이 어려웠다.
* 환경: Docker에 redis를 설치한 상황

---

* 해결방안
  1. docker desktop 에서 >- 모양 클릭(CLI)
  2. 이후 /bin/sh이 켜짐
  3. `# redis-cli` 입력
  4. redis-cli 환경으로 바뀌게 되는데 여기서
  5. `CONFIG SET requirepass {YOUR_PASSWORD}` 입력
  6. `OK` command 확인

