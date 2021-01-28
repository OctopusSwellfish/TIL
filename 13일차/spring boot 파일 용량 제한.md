# Spring boot 파일 사이즈 업로드

* 파일 사이즈 1mb이상이면 올라가지 않는 오류 발생
* `org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException: The field files exceeds its maximum permitted size of 1048576 bytes.`

해결 방안

appliaction.properties에다가 이렇게 써주면 된다.

`spring.servlet.multipart.maxFileSize=8MB spring.servlet.multipart.maxRequestSize=8MB`
