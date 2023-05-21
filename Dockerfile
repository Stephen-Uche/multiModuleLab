


FROM eclipse-temurin:19-jre-jammy

COPY . /app
WORKDIR /app



COPY  consumer/target/classes  /app/org.example.consumer
COPY  provider/target/classes  /app/lib/org.example.provider
COPY  service/target/classes   /app/lib/org.example.service

ENTRYPOINT ["java","--module-path","consumer\target\classes","provider\target\classes","service\target\classes","-m","org.example.consumer/org.example.consumer.Consumer"]