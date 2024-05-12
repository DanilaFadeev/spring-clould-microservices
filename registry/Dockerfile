FROM openjdk:17-jdk-slim-buster

WORKDIR /app/build

COPY build/libs/registry-0.0.1.jar .

EXPOSE 8761
ENTRYPOINT java -jar registry-0.0.1.jar