FROM amazoncorretto:8-alpine-jdk

COPY target/sistema-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]