FROM eclipse-temurin:21-jdk
EXPOSE 8080
WORKDIR /app
COPY build/libs/*.jar api-gateway.jar

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]