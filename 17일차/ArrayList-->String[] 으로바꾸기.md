```java
List<String> stringList = new ArrayList<String>();
stringList.add("돈까스");
stringList.add("호흡");
stringList.add("바람개비");
        
String[] stringArray = stringList.toArray(new String[0]);
```
* `new String[0]` 이 무슨의미지?
1. List를 toArray 메서드에 파라미터로 넘어가는 배열 객체의 size만큼의 배열로 전환
2. 만약에 List size가 인자로 넘어가는 배열 객체의 size보다 크면 해당 List의 size로 배열이 만들어짐
3. List size가 인자로 넘어가는 배열객체의 size보다 작을때면 인자로 넘어가는 배열객체의 size로 배열이 만들어짐
