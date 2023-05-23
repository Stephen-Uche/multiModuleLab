


FROM maven:3.8.7-alpine:3 as build


COPY . /app
WORKDIR /app
RUN mvn clean package

FROM alpine:3

COPY --from=build /app/consumer/target/*.jar ./app
COPY --from=build /app/provider/target/*.jar ./app
COPY --from=build /app/service/target/*.jar ./app

ENTRYPOINT["java","--module-path","provider\target\classes", "-m","org.example.consumer/org.example.consumer.Consumer"]
