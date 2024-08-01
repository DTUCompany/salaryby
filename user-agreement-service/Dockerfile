FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY build/libs/*.jar user-agreement-service.jar

ENTRYPOINT ["java", "-jar", "user-agreement-service.jar"]