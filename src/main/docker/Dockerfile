FROM adoptopenjdk/openjdk8:latest
MAINTAINER kamuscoin@protonmail.com
ADD interfell-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]