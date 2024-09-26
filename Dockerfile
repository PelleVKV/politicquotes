# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Install Maven
RUN apk add --no-cache maven

# Set the working directory in the container
WORKDIR /app

# Copy the project's pom.xml and download dependencies
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the project source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

RUN ls -la target

# Expose the port the application runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/qoutes-0.0.1-SNAPSHOT.jar"]
