FROM openjdk:17-jdk-slim-buster

WORKDIR /app/build

COPY build/libs/bill-service-0.0.1.jar .

EXPOSE 8002
ENTRYPOINT java -jar bill-service-0.0.1.jar