```python
def encrypt(inputString):
    return hmac.new(bytes('ssafySecret', 'UTF-8'), bytes(inputString, 'UTF-8'), hashlib.sha256).hexdigest()

# inputString type --> str
```

sha256 + hmac이 무엇인지는 추후 정리
