# Build stage using Maven 3.9.6 and OpenJDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and source
COPY pom.xml .
COPY src ./src

# Build application
RUN mvn clean package -DskipTests

# Runtime stage using OpenJDK 17 JRE (lightweight)
FROM eclipse-temurin:17-jre-jammy

# Set working directory
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar demo.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "demo.jar"]
