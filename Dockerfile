FROM maven:3.6.3-jdk-11-slim AS build-image
WORKDIR /to-build-app
COPY . .
RUN mvn dependency:go-offline
RUN mvn package -DskipTests

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build-image /app/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
