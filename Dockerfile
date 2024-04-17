FROM tomcat:8.0-jre8-alpine
LABEL maintainer="darty.vis@gmail.com"
ADD target/JakartaProject-latest.war /usr/local/tomcat/webapps/
CMD ["catalina.sh", "run"]
