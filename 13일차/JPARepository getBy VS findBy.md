# JPARepository getBy VS findBy

* 문제 상황
* 둘이 비슷한거 같은데 도대체 무슨 차이인가

---

### 바로 구글링

* 괜찮은 문서를 찾았다

getById :arrow_forward: 무조건 그 객체를 반환한다. 없으면 exception 발생시킴

findById :arrow_forward: 객체가 있으면 객체, 없으면 null을 반환한다.

그러니까 findBy는 없을수도 있는 상황에서 널의 위험을 방지하고자 쓴다는거다.

그래서 Optional<T> findById(long id)의 방식으로 쓰는거다.

오늘도 하나 배웠다...

---

출처: 

https://szymonkrajewski.pl/the-practical-difference-between-findby-and-getby-in-repositories/
