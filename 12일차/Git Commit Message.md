# Git Commit Message

* Git Flow의 개념에 대해 배우게 되면서, Commit Message를 **간결하고/규칙에 맞게/보기 좋게** 쓰는 것이 굉장이 중요하다는 것을 한 번 더 느끼게 되었다.
  * 보통은 혼자서 작업하는 경우가 많았기 때문에 지키지 않았는데, 이제는 혼자 작업하는 한이 있더라도 꼭 지켜서 써보려고 한다. 

---

### 커밋 메시지 규약을 왜 지켜야 하는가

* 협업을 하면서, 내가 혹은 다른 상대방이 어떤 일을 했는지 직관적으로 알 수 있어야 하기 때문에
  * 코드는 혼자 보는게 아니기 때문에/코드는 혼자 짜는게 아니기 때문에
* 이후 프로젝트나, 일했던 것을 볼 때 어떤 일을 했는지 파악 가능하기 때문에
* 보통 코드를 보기도 하지만, 통상적으로는 커밋 메시지로 어떤 일을 했는지 파악하기 때문에
* **커밋 메시지가 하나의 의미를 담고 있기 때문에, 단일 커밋 단위로 의미있는 수정들이 일어나도록 장려할 수 있기 때문에**
* 규약을 통해 Changelog에 대한 생성을 자동화할 수 있기 때문에(조금 더 공부 필요)
* 커밋을 통해 Semantic version관리를 명확하게 할 수 있고 자동화할 수 있기 때문에

---

### 커밋 메시지 규칙

* 보통은 팀과 컨벤션을 맞추는 경우가 많은 것 같다. 그래도 보통 기본적으로 통용되는 규칙
  1. 제목과 본문을 한 줄 띄워 분리하기
  2. 제목은 영문 기준 50자 이내
  3. 제목 첫 글자를 대문자
  4. 제목 끝에 **. 금지**
  5. 제목은 **명령조**로 (git의 Built-in Convention을 따르는 것)
  6. 본문은 영문 기준 72자마다 줄 바꾸기
  7. 본문은 **어떻게**보다 **무엇을, 왜**에 맞춰 작성

---

### (참고)자주 커밋 로그에 사용하는 영어 단어 목록

1. **feat**: 새로운 기능에 대한 커밋 (feature를 축악형으로 쓴 것) / Minor 버전에 해당하는것
2. **fix**: 버그 수정에 대한 커밋 (Patch버전 의미하는 형태)
3. **build**: 빌드 관련 파일 수정에 대한 커밋
4. **chore**: 그 외 자잘한 수정에 대한 커밋
5. **ci**: CI 관련 설정 수정에 대한 커밋
6. **docs**: 도큐먼트 수정에 대한 커밋
7. **style**: 코드 문법 또는 포맷에 대한 수정에 대한 커밋
8. **test**: 테스트 코드 수정에 대한 커밋

* 적용 범위
  * 부가적인 정보로, 선택사항이지만 적용 범위를 명시하게 되면 해당 커밋이 어떤 범위에 대한 수정 사항인지 이해하는지 도움이 되는 정보이다.

---

### 그럼 어떻게 쓰나요

> Add review function

본문에는 {타입} (적용범위): 메시지

>feat(pipeline) !: Add pipeline function

본문은 생략이 가능하지만, **Major버전에 대한 명시**필요하면 꼭 적어야 한다.

+ 추가적으로 Major 변화에 대한 메시지는 본문에 있으니까, 커밋 메시지에서 확인 못하고 넘어갈 가능성이 있기 때문에 : 앞에 !를 추가해서 본문에 내용이 있음을 알려줄 수 있다.



