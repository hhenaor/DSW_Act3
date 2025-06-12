# install jdk, maven clean and run

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/actividad3-0.0.1-SNAPSHOT.jar"]
