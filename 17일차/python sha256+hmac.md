```python
def encrypt(inputString):
    return hmac.new(bytes('SecretString', 'UTF-8'), bytes(inputString, 'UTF-8'), hashlib.sha256).hexdigest()

# inputString type --> str
```

bytes('SecretString', 'UTF-8') 스트링은 나만 알고 있는 스트링 정보로 해야됩니다.
sha256 + hmac이 무엇인지는 추후 정리
