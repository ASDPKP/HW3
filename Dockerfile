FROM eclipse-temurin:17
LABEL MAINTAINER="asdpkp@gmail.com"
WORKDIR /app
COPY target/HW3-0.0.1-SNAPSHOT.jar /app/swe645hw3.jar
ENTRYPOINT ["java", "-jar", "swe645hw3.jar"]