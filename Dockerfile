FROM maven:3.6.3-jdk-11
COPY ./ ./
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/target/test-task-0.0.1-SNAPSHOT.jar"]