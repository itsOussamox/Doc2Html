# Use a base image with Java and Maven pre-installed
FROM eclipse-temurin:17-jdk-alpine

COPY demo-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080 

# Command to run the application
ENTRYPOINT ["java","-jar","/app.jar"]
