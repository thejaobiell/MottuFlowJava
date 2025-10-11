FROM maven:3.9.11-eclipse-temurin-21-alpine AS builder
WORKDIR /app

COPY MottuFlow/pom.xml MottuFlow/mvnw ./
COPY MottuFlow/.mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

COPY MottuFlow/src ./src
RUN ./mvnw package -DskipTests -B

RUN mv target/MottuFlow-*.jar app.jar

FROM gcr.io/distroless/java21:nonroot
WORKDIR /app

COPY --from=builder /app/app.jar app.jar

ENV DB_HOST=mysql.railway.internal
ENV DB_PORT=3306
ENV DB_NAME=railway
ENV DB_USER=root
ENV DB_PASSWORD=QFNKHjNvwfWrAKHZUJCgqkSzhmmprjLX

EXPOSE 8080
USER nonroot
ENTRYPOINT ["java", "-jar", "app.jar"]
