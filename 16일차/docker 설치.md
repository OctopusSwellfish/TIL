* 기존에 있던거 지우기<br>
`sudo apt-get remove docker docker-engine docker.io containerd runc`

` sudo apt-get update`<br>
` sudo apt-get install \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg`
    
`curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg`

<br>
* x86_64 / amd64 기준<br>
```sudo add-apt-repository \
"deb [arch=amd64] https://download.docker.com/linux/ubuntu \
$(lsb_release -cs) \
stable"``` <br>

`sudo apt-get install docker-ce docker-ce-cli containerd.io`

<br>

* 테스트
`sudo docker run hello-world`
