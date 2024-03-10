FROM gradle:jdk17 as gradleimage

COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM amazoncorretto:17-alpine-jdk

#ENV SPRING_DATASOURCE_USERNAME     # hydrated at deployment via manifest
#ENV SPRING_DATASOURCE_PASSWORD     # hydrated at deployment via manifest
#ENV SPRING_DATASOURCE_URL          # hydrated at deployment via manifest

COPY --from=gradleimage /home/gradle/source/build/libs/api-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "app.jar"]