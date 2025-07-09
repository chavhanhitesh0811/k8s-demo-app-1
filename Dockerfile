FROM maven:3.9.6-eclipse-temurin-17 as build

COPY pom.xml ./pom.xml
COPY src ./src
RUN mvn clean install

FROM eclipse-temurin:17
WORKDIR ./app
COPY --from=build /target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]