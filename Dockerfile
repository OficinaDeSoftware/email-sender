FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

COPY . .

RUN mvn clean package -DskipTests && \
    rm -rf /root/.m2/repository &&  \
    rm -rf /target/*sources.jar

FROM eclipse-temurin:17-jre-alpine

EXPOSE 5054

COPY --from=build /target/email-sender-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
