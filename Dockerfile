# Use the official Maven image with OpenJDK 11 as a base image
FROM maven:3.8.4-openjdk-17

# Set Timezone
ENV TZ=Asia/Ho_Chi_Minh

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the Maven project files into the container
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package

# Expose the port on which the application will run
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "target/WeatherAppBackEnd-0.0.1-SNAPSHOT.jar"]