# FROM tomcat:jre8-alpine
# FROM tomcat:8.5.91-jdk8-corretto
FROM tomcat8:8.5.91-alpine-jre8u372-b07
#COPY /mnt/c/projects/workspace/Spring-MVC-Legacy/SpringBasic/target/spring-sample.war /usr/local/tomcat/webapps/ROOT.war
#COPY /home/jjangee/projects/workspace/Spring-MVC-Legacy/SpringBasic/target/spring-basic.war /usr/local/tomcat/webapps/ROOT.war
# USER root
RUN rm -fR /usr/local/tomcat/webapps/ROOT
# USER tomcat
COPY ./target/spring-basic.war /usr/local/tomcat/webapps/ROOT.war
#EXPOSE 8080
CMD ["catalina.sh", "run"]