FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY build/libs/*.jar user-service.jar

ENTRYPOINT ["java", "-jar", "user-service.jar"]