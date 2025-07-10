FROM maven:3.9.6-eclipse-temurin-17 as build

RUN mkdir -p /root/.m2
COPY pom.xml .
COPY src ./src
COPY settings.xml /root/.m2/settings.xml
RUN mvn -s /root/.m2/settings.xml clean install

FROM eclipse-temurin:17
WORKDIR ./app
COPY --from=build /target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]