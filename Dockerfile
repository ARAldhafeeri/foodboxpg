FROM openjdk:19-ea-20-jdk-oracle

COPY target/*.jar /app.jar

EXPOSE 3306

ENTRYPOINT ["java","-jar","/app.jar"]
