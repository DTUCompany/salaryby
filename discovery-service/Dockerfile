FROM eclipse-temurin:21-jdk
EXPOSE 8761
WORKDIR /app
COPY build/libs/*.jar discovery-service.jar

ENTRYPOINT ["java", "-jar", "discovery-service.jar"]