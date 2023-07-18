# Use an OpenJDK base image with a specific version
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY target/your-app.jar .

# Expose the port your Spring Boot application listens on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "your-app.jar"]
