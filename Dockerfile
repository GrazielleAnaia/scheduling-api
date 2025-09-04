FROM gradle:8.7-jdk17-alpine AS build

WORKDIR /app

COPY . .

RUN gradle build --no-daemon


FROM amazoncorretto:17-alpine3.19-jdk

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/scheduling-api.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/scheduling-api.jar"]