FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY build/libs/*.jar test-service.jar

ENTRYPOINT ["java", "-jar", "test-service.jar"]