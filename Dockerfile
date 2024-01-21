FROM maven:3.8-openjdk-11-slim

WORKDIR /app

COPY ./pom.xml ./pom.xml
COPY ./src ./src

RUN mvn install -DskipTests

RUN mvn spring-boot:run
