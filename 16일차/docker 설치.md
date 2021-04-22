* 기존에 있던거 지우기<br>
`sudo apt-get remove docker docker-engine docker.io containerd runc`

` sudo apt-get update`<br>
` sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg \
    lsb-release`
    
`curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg`

* x86_64 / amd64 기준<br>
```
 echo \
  "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
```

`sudo apt-get install docker-ce docker-ce-cli containerd.io`

<br>

* 테스트
`sudo docker run hello-world`
