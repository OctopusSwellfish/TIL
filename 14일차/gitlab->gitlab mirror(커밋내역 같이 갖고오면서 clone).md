# Gitlab to Gitlab Mirror

* 상황: 깃랩에서 새로운 프로젝트를 만들어서, 이전에 있던 프로젝트를 갖고 와야 하는 상황이었는데  깃 커밋 내역이나 브랜치까지 다 가져와야 하는 상황이었다.

## A->B로 옮기는 상황(A:옛날 커밋 내역 남아있는거, B: 지금 repo)

* A,B 둘다: Settings->Repository 에서  Protected Branches에서 master를 unprotected해준다.(마스터가 기본으로 보호되어있을텐데 이를 삭제한다)

* A: A의 Settings->Repository 에서 Mirroring Repositories에 들어간다. url을 설정하는데 url은 B의 주소에서 갖고온다.

  * 이때 주의할 점은 username을 줘야 한다는거다

  * 왜 A에서 가져오냐면 기본 옵션이 push다. A에서 B로 push를 해줘야 되는것임.

  * B 레포에서 Clone 해서 가져오면 주소가 그냥 주소일텐데 그 앞에 username@을 붙여주면 된다.

  * 예를 들면 `https://gitlab.com/group/project.git` 뭐 이럴텐데 여기 앞에 이걸 붙여줘야된다는 것

    > `https://{username}@gitlab.com/group/project.git`

* 그런다음에 비번 쳐서 push해주면 된다.

이 간단한걸 어려워했다니..정말 배울게많다
