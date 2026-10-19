# Step 1: Maven se Build karna (Eclipse Temurin use kar rahe hain)
FROM maven:3.8.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run karne ke liye Light-weight JRE use karna
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# Render Free Tier ke liye RAM management (-Xmx384m)
ENTRYPOINT ["java", "-Xmx384m", "-jar", "app.jar"]