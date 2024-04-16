FROM openjdk:8
COPY target/JakartaProject-latest.jar /usr/src/JakartaProject-latest.jar
CMD java -jar /usr/src/JakartaProject-latest.jar