


FROM maven:3.8.7-eclipse-temurin-19-alpine as build


COPY . /app
WORKDIR /app

FROM eclipse-temurin:19-allpine-jre
RUN mvn clean package
COPY --from=build /app/consumer/target/*.jar ./
COPY --from=build /app/provider/target/*.jar ./
COPY --from=build /app/service/target/*.jar ./

ENTRYPOINT["java","--module-path","provider\target\classes", "-m","org.example.consumer/org.example.consumer.Consumer"]
