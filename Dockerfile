


FROM maven:3.8.7-eclipse-temurin-19 as build
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:19-jre-alpine
COPY --from=build /app/consumer/target/*.jar /app/org.example.consumer.jar
COPY --from=build /app/provider/target/*.jar /app/lib/org.example.provider.jar
COPY --from=build /app/service/target/*.jar /app/lib/org.example.service.jar

ENTRYPOINT java --module-path /app:/app/lib/org.example.service.jar:/app/lib/org.example.provider.jar -m consumer/org.example.consumer.Consumer