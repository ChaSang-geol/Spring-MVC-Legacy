# Spring-MVC-Legacy


### docker image build
` cd ./SpringBasic
docker build -t my-tomcat8:v1 .

docker run -d -p 8090:8080  my-tomcat8:v1
`
### Docker 컨테이너 실행 (컨테이너 이름 지정)
```
docker run --name my-tomcat8 -d -p 8090:8080 my-tomcat8:v1 
```
# 
