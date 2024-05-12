FROM openjdk:17-jdk-slim-buster

WORKDIR /app/build

COPY build/libs/account-service-0.0.1.jar .

EXPOSE 8081
ENTRYPOINT java -jar account-service-0.0.1.jar