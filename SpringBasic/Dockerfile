FROM tomcat:jre8-alpine
#COPY /mnt/c/projects/workspace/Spring-MVC-Legacy/SpringBasic/target/spring-sample.war /usr/local/tomcat/webapps/ROOT.war
#COPY /home/jjangee/projects/workspace/Spring-MVC-Legacy/SpringBasic/target/spring-basic.war /usr/local/tomcat/webapps/ROOT.war
RUN rm -fR /usr/local/tomcat/webapps/ROOT
COPY ./target/spring-basic.war /usr/local/tomcat/webapps/ROOT.war
#EXPOSE 8080
CMD ["catalina.sh", "run"]