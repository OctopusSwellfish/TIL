# git flow 정리
1. 원격에 있는 master, develop, feature 브랜치 가져오기
   `git checkout -t origin/feature`

 * 로컬에서 feature 이름의 브랜치가 생성됨
2. feature/기능 브랜치 생성
   `git checkout -b origin/feature/기능`

3. 로컬에서 origin/feature/기능 브랜치가 생성됨
* feature/기능 브랜치에서 작업 후 커밋
* status로 변경 사항 꼭 확인하기
* feature 브랜치로 넘어와서 merge
   `git checkout feature`

4. feature/기능 브랜치 삭제
   `git branch -d origin/feature/기능`

5. feature 브랜치로 push
   `git push origin feature`

6. gitlab에서 feature -> develop 브랜치로 merge request
