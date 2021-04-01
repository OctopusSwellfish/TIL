access Denied뜨거나 올바른 git주소가 아니라고 할 때

통상적으로 아이디를 잘못 썼거나 비번을 잘 못 썼는데, 옵션->인증 갔을때는 제대로 되어있고
또 그 깃 주소 클론 받아오려 하면 잘못된 아이디로 fix되어서 비번만 치라고 하는 경우(로그인 유지 눌렀을때)
혹은 또 안될때

그때 해결 방법이다.

C:\Users\사용자계정\AppData\Local\Atlassian\SourceTree 폴더의

password, userhosts 파일을 제거하고 껐다 키면 된다
