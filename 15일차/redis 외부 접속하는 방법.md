# redis 외부 접속하는 방법
1. 먼저 redis-tool설치
`$ sudo apt-get install redis-tools`

2. 이후 접속시도
`redis-cli -h <redis 서버 ip> -p <redis port> -a <password>`
e.g. `redis-cli -h 127.0.0.1 -p 6379 -a mypassword

* 이거때문에 해킹당했다......ㅠㅠㅠㅠ
  * 나중에 다시 꼭 확인해서 올리기!
