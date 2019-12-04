FROM gradle:5.4.1-jdk11-slim as compile

COPY . /src
WORKDIR /src
USER root
RUN chown -R gradle /src
USER gradle

RUN gradle clean build -x test

FROM openjdk:11-jdk-slim
COPY --from=compile /src/build/libs/hello*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
