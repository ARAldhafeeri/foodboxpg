FROM openjdk:19-ea-20-jdk-oracle


ENTRYPOINT ["java", "-jar", "/app.jar"]