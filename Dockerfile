FROM maven:3.8.7-eclipse-temurin-19 as build
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:19-jre-alpine
COPY --from=build consumer/target/classes .
COPY --from=build provider/target/classes .
COPY --from=build service/target/classes .



ENTRYPOINT ["java","--module-path","service/target/classes","consumer/target/classes","provider/target/classes","-m"," org.example.consumer/org.example.consumer.Consumer"]







