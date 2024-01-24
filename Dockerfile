FROM openjdk:19-ea-20-jdk-oracle

COPY target/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]