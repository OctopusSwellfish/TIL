* GRANT ALL PRIVILEGES ON *.* TO 'root'@'111.222.33.44'; 이런거 안먹었음
* root에서 외부접속을 차단하고 싶었음

* 어떻게하냐면
* docker exec -it ... bash 들어가서

* `/usr/bin/mysql_secure_installation`
* 치고 수정하면 된다.
* 자세한건 나중에 수정
* 

* Kubernetes 에서 Mysql 이 올라가지 않는데 그 이유를 모르겠다
* 일단 팀원의 말로 들었을때는 mongodb 이런게 kubernetes랑 잘 맞고 mysql 은 잘 맞지 않는다고 한다.
* 개중에 컨테이너가 생성되면 내용을 백업하고 해야되는데 그걸 쿠버에올리는게 맞냐 이런 의견도 있었음.
* 공부하고 더 추가해야 됨.
