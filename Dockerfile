FROM amazoncorretto:17-alpine-jdk
MAINTAINER MarceloZych
COPY target/login-0.0.1-SNAPSHOT.jar mozApp.jara
ENTRYPOINT ["java", "-jar", "/mozApp.jara"]