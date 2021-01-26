# git .ignore 다시 반영



### 상황: 처음에 .ignore를 반영하고 나서 또 .gitignore를 추가했더니, gitignore에 들어가있는 파일이어도 자꾸 형상 관리가 된다



* application.properties와 같은 민감정보가 들어있는 파일이었기 아무도 이것을 commit내역에 올리면 안된다.
* AWS credentials정보가 있어서 한 번이라도 commit 해서 올리면 aws계정이 영구정지될 위기에 처하는 경우..



1. .gitignore파일을 수정한다
2. `git rm -r --cached .`
3. `git add .`
4. `git commit -m "remove .gitignored file"`
5. `git push origin {branch}`



* **항상 커밋하기 전에 `git status`를 꼭 해서 수정 내역을 확인하자.**
* 이를 확인하지 않으면 대참사가 일어날수도 있다.

