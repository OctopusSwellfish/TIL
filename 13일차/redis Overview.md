# 애증의 Redis

* 이 레디스를 이번에 하는 프로젝트에 도입해 보려고 하면서 정말 많은 난관이 있었다.
* 일단 개념을 이해하는 게 어려웠고, 각자 다 다르게 짜놓은 Config클래스들을 보면서 많은 혼란이 있었다다.
  * 그 중 내가 보고 이해가 되었던 개념들을 정리를 해서 저장해 놓으려고 한다
  * 순서는 나중에 보기좋게 수정할거다

---

### Redis 데이터 타입 테스트

| 메서드      | 설명                                        |
| ----------- | ------------------------------------------- |
| opsForValue | String을 쉽게 De/Serialize해주는 인터페이스 |
| opsForList  | List를 쉽게 De/Serialize해주는 인터페이스   |
| opsForSet   | Set을 쉽게 De/Serialize해주는 인터페이스    |
| opsForZSet  | ZSet을 쉽게 De/Serialize해주는 인터페이스   |
| opsForHash  | Hash를 쉽게 De/Serialize해주는 인터페이스   |

* 얘를 도대체 어떻게 쓰느냐

```Java
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getData(String key){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.get(key);
    }
```

* 위의 방식으로 사용 가능

* 근데 그러면 도대체 stringRedisTemplate은 어디서 받아온걸까

  * 이걸 알려면 RedisConfig파일 설정들을 좀 볼 필요가 있다
  * RedisConfig 파일 안 만들어도되는데 왜 만들어야됨??
  * 얘는 뭐임?
  * 오버로딩 어케됨 ?
  * 뭔 놈의 설정?
  * RedisTemplate에서 파생된거같은데 그럼 그건 뭥미?
  * redis자료구조
  * 설정하는법
  * 헷갈렸던점(Config다 다르고, 심지어 config안해도 간단학 쓸수잇는이유)
  * redisTemplate & redisRepository 뭐가다르고 이게 둘다 뭐지?
  * 이번 프로젝트에는 expired했을때 이벤트가 필요한데 그건 어떻게 받아올수있는거지?
  * pub/sub를 해야되는데 그건 어떻게 설정하지?
  * pub/sub에 대해서 pub/sub할때마다 이벤트를 만들어야되는데 그건 어떻게하지?
  * pub/sub 구조는 어떻게 만드는게 좋지?

  이것들에 대해서 지금은 졸리니까 낼 다시 수정할게요

  더 알아봐야할것도 많음
