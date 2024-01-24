FROM openjdk:19-ea-20-jdk-oracle

COPY target/*.jar /app.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]