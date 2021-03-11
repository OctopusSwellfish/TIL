# 도커에서 mysql을 올리면 한글이 깨지게 된다. 이때 이걸 해결하는 궁극적 마지막 방안

* 일단 mysql container에 들어간다.
`sudo docker exec -it {database 이름} bash`
* 들어가서 mysql 접속
`$ mysql -u root -p`
* 비밀번호 입력하면 들어와지는데, 여기서 status라고 쳐 본다.
`> status`

* 중간에 encoding 부분이 2개만 utf8mb4로 되어있을 것이다.
* 밑은 latin이다. 이러면 한글이 깨짐.


* 다시 쉘을 나와서 원하는 곳에다가 custom파일을 만들어준다
```sh
[client]
default-character-set=utf8mb4

[mysql]
default-character-set=utf8mb4

[mysqld]
skip-character-set-client-handshake
init_connect="SET collation_connection = utf8mb4_unicode_ci"
init_connect="SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci"

character-set-server=utf8mb4
collation-server=utf8mb4_unicode_ci

```
* 나 같은 경우는 경로를 이렇게 해줬다.
`/config/mysql/custom.cnf`

* 이후 이 파일을 docker mysql container와 volume 연동해준다
`docker-compose.yml`에서,
```yaml
volumes:
      - ./config/mysql/custom.cnf:/etc/mysql/conf.d/custom.cnf
```

* 이렇게 해주고 다시 켜 주면 적용 완료

---
* 비고: 나의 경우는 compose파일에 command로 설정하는거 안됐었음. 왜 안된건지 모름 일단 저렇게 해주면 된다
