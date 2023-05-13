FROM maven:3.8.7-eclipse-temurin-19-alpine as build

COPY . /app
WORKDIR /app

FROM eclipse-temurin:19-jre-alpine


COPY --from=build /app/service/target/*.jar /lib/service.jar

COPY --from=build /app/provider/target/*.jar /lib/provider.jar
COPY --from=build /app/consumer/target/*.jar /consumer.jar





ENTRYPOINT ["java", "-p", "provider\target\classes", "-m", "org.example.consumer", "org.example.consumer.Consumer"]







