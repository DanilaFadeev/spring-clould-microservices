FROM openjdk:17-jdk-slim-buster

WORKDIR /app/build

COPY build/libs/notification-service-0.0.1.jar .

EXPOSE 8084
ENTRYPOINT java -jar notification-service-0.0.1.jar