* GRANT ALL PRIVILEGES ON *.* TO 'root'@'111.222.33.44'; 이런거 안먹었음
* root에서 외부접속을 차단하고 싶었음

* 어떻게하냐면
* docker exec -it ... bash 들어가서

* `/usr/bin/mysql_secure_installation`
* 치고 수정하면 된다.
* 자세한건 나중에 수정
* 
