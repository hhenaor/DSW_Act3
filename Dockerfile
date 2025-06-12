# install jdk, maven clean and run

FROM maven:3.8-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=builder /app/target/actividad3-1.0.0.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
