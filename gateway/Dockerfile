# FROM openjdk:11

# EXPOSE 8080

# ADD target/gateway-0.0.1-SNAPSHOT.jar exec.jar

# ENTRYPOINT ["java", "-jar", "exec.jar"]

FROM maven:3.8.3-openjdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8090
ENTRYPOINT ["java","-jar","/home/app/target/gateway-0.0.1-SNAPSHOT.jar"]