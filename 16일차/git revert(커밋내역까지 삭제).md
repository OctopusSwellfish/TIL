# 커밋 내역에 application.properties가 올라가서 민감정보가 올라가버린 상황.
커밋 내역까지 다 없앤 상태로 돌려야 하는 상황이었다.

이미 push된 상태에서 commit 되돌리는 법이다.

git bash에서
` git reset --hard {되돌아가고자 하는 커밋주소}`
* 커밋 주소는 git log로 알수있다
* reset 옵션은 hard/soft/mixed있음


이후
`git push origin +{branch명}`
* 브랜치 명 앞에 `+`붙여야됨(덮어씌운다는 의미)
* `+`안 쓰면 최근커밋 pull하라고 오류남
