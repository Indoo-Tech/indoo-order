FROM openjdk:21-jdk-alpine

WORKDIR /order

COPY build/libs/order-0.0.1-SNAPSHOT.jar /order/order-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/order/order-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
