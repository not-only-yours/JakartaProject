#FROM openjdk:8

#CMD java -jar /usr/src/JakartaProject-latest.jar

FROM tomcat:8.0-alpine
LABEL maintainer="darty.vis@gmail.com"
ADD target/JakartaProject-latest.war /usr/local/tomcat/webapps/
#ADD ./src/main/webapp /usr/local/tomcat/webapps/webapp
CMD ["catalina.sh", "run"]