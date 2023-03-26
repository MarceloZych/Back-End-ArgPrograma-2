FROM amazoncorretto:17-alpine-jdk
MAINTAINER MarceloZych
COPY target/login-0.0.1-SNAPSHOT.jar mozApp.jar
ENTRYPOINT ["java", "-jar", "/mozApp.jar"]