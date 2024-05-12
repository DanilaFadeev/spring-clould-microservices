FROM openjdk:17-jdk-slim-buster

WORKDIR /app/build

COPY build/libs/deposit-service-0.0.1.jar .

EXPOSE 8083
ENTRYPOINT java -jar deposit-service-0.0.1.jar