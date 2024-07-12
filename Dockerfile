# Use the appropriate OpenJDK version
FROM openjdk:20-ea-4-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/Prepmaster-API-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application is listening on
EXPOSE 8080

# Run your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
