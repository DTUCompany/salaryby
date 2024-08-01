FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY build/libs/*.jar invitation-service.jar

ENTRYPOINT ["java", "-jar", "invitation-service.jar"]