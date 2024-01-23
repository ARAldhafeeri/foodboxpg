FROM openjdk:19-ea-20-jdk-oracle

# Download wait-for-it.sh script
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

COPY target/*.jar /app.jar

ENTRYPOINT ["/wait-for-it.sh", "mysqldb:3306", "--", "java", "-jar", "/app.jar"]