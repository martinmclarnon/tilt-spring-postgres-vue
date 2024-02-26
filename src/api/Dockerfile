FROM gradle:jdk17 as gradleimage

COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM amazoncorretto:17-alpine-jdk

#ENV SPRING_DATASOURCE_USERNAME=${DATABASE_USERNAME:POSTGRES}
#ENV SPRING_DATASOURCE_PASSWORD=${DATABASE_PASSWORD:ADMIN}
#ENV SPRING_DATASOURCE_URL=${DATABASE_URL:JDBC:POSTGRESQL://DB:5432/RESTFUL-API}

COPY --from=gradleimage /home/gradle/source/build/libs/api-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "app.jar"]