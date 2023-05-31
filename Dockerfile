

FROM maven:3.8.7-eclipse-temurin-19-alpine as build
COPY . /app
WORKDIR /app
RUN mvn clean compile
FROM eclipse-temurin:19-jre-alpine
COPY --from=build /app/consumer/target/classes /app/consumer
COPY --from=build /app/provider/target/classes /app/lib/provider
COPY --from=build /app/service/target/classes /app/lib/service
ENTRYPOINT ["java", "-p", "/app/consumer:/app/lib/provider:/app/lib/service", "-m", "org.example.consumer/org.example.consumer.Consumer"]
