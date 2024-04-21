FROM adoptopenjdk/openjdk17:alpine
COPY target/tractors-farm44-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
