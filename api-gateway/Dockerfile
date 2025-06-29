FROM openjdk:17-jdk-slim
LABEL authors="maisyst"
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","app.jar"]
