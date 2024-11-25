FROM amazoncorretto:17-alpine-jdk

WORKDIR /app
COPY target/*.jar app.jar

ENTRYPOINT ["java","-Xmx512m", "-jar", "app.jar"]

EXPOSE 8180
