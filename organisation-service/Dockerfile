FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY build/libs/*.jar organisation-service.jar

ENTRYPOINT ["java", "-jar", "organisation-service.jar"]