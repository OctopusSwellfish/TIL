# JSONObject vs JsonObject

전자는 simple.json 여기 있는거고 후자는 구글에서 만든 Gson 의 클래스이다.



둘이 비슷하지만 완전 다르다. 서로 **convert 불가능**

## 문제 상황

최초의 문제상황:

BasicReponse라는 객체를 만들어서 쓰고 있었다. 이 친구는 rest api 서버에다가 대답하기 위한 서버였다

거기에는 혹시 여러 리스트같은것들을 넣게 될까봐 json을 넣기 위해 Object object;라는 필드가 있었다. 나는 Gson의 JsonObject를 만들어서 여기의 object = JsonObj.toString();을 했더니 이거를 json객체로 인식하지 않고 backslash(`\`)가 들어간 문자열로 인식하기 시작했다. 예를 들면 이렇게 됏다는 말씀.

` object: "\"title\":\"hi\" ` 뭐 이런식으로..... 그래서 이걸 어떻게 해결할까 하다가 그냥 Object에다가 = JsonObject하니까 오류 발생.

`HttpMessageNotWritableException: "Could not write JSON:"` 무슨 이런 오류 발생

### 일단 해결해보려고 한 방법

1. 많은 구글링 끝에 `application.properties`파일에 `spring.mvc.converters.preferred-json-mapper=gson`를 넣어주면 된다고 함.
   1. 근데 이렇게 했더니 잘 됐음. 실제로 잘 넘어가졌음.

## 문제상황 2

* 갑자기 다른 팀원이 만든 로그인이 안됨.
* 그 팀원이 만든 코드는 JSONObject로 (나랑 다른거) jwt토큰을 만들어서 넘겨줬는데. gson으로 인식하라고 해버렸더니만 이번에는 simple json을 인식 못해서 안되는 거였음.
* 그래서 내가 해결한 방법은 그냥 안됨.



# 결론

Json을 다루는 라이브러리는 꼭 **통일**하자.

이번의 같은 경우는 그냥 내가 simple json으로 코드를 다시 다 refactoring했다.

졸린상태에서 새벽에 쓴거라 횡설수설..

나중에 다시 문맥 고쳐야겠다



이렇게 했음

```java
JSONObject sss = new JSONObject();
sss.put("test", "test..");

// 만약에 배열을 넣고싶을때는
List<String> arr = new ArrayList<>();

arr.add("test2");
arr.add("test3");

//그리고 나서 
sss.put("arrTest", arr);

//나중에 보낼 때에는
Object object = sss //이렇게 하면 보내짐. gson으로 했을때는 오류났음. 근데 gson으로 하고싶으면 application.properties에다가 저 위에 속성 넣어주면 됨.
    
```
