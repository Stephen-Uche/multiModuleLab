FROM maven:3.8.7-eclipse-temurin-19

COPY . /app

WORKDIR /app





COPY  consumer/target/* /app/consumer
COPY  provider/target/* /app/lib/provider
COPY  service/target/* /app/lib/service








ENTRYPOINT ["java","--module-path","service","provider","-m","consumer/consumer.Consumer"]







