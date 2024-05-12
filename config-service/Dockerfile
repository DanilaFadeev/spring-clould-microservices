FROM openjdk:17-jdk-slim-buster

WORKDIR /app/build

COPY /build/libs/config-service-0.0.1.jar .

EXPOSE 8001
ENTRYPOINT java -jar config-service-0.0.1.jar