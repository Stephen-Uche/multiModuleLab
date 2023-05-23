


FROM maven:3.8.7-eclipse-temurin-8-alpine as build


COPY . /app
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:8-jre-alpine

COPY --from=build /app/consumer/target/*.jar  /app/consumer.jar
COPY --from=build /app/provider/target/*.jar  /app/lib/provider.jar
COPY --from=build /app/service/target/*.jar  /app/lib/service.jar

ENTRYPOINT["customjre\bin\java.exe","--module-path","provider\target\classes","-m","org.example.consumer/org.example.consumer.Consumer"]
