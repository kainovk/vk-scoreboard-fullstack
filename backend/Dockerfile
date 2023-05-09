FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle gradle
COPY src src

RUN ./gradlew clean build -x test

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /workspace/app/build/libs/*.jar ./

EXPOSE 9090

CMD ["java", "-jar", "vk-task-scoreboard.jar"]