FROM openjdk:17-jdk-slim-buster

WORKDIR /app/build

COPY build/libs/gateway-0.0.1.jar .

EXPOSE 8989
ENTRYPOINT java -jar gateway-0.0.1.jar