FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY build/libs/*.jar agreement-service.jar

ENTRYPOINT ["java", "-jar", "agreement-service.jar"]