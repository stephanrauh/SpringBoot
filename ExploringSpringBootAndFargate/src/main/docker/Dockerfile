FROM --platform=linux/amd64 openjdk:17-jdk-alpine
COPY ./app.jar app.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/app.jar"]
