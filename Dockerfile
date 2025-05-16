FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY build/libs/scheduling-api-0.0.1-SNAPSHOT.jar /app/scheduling-api.jar

EXPOSE 8181

CMD ["java", "-jar", "/app/scheduling-api.jar"]