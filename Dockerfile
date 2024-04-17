#FROM openjdk:8
#COPY target/JakartaProject-latest.jar /usr/src/JakartaProject-latest.jar
#CMD java -jar /usr/src/JakartaProject-latest.jar

FROM tomcat:9.0.1-jre8-alpine
ADD ./src/main/webapp /usr/local/tomcat/webapps/webapp
CMD ["catalina.sh", "run"]