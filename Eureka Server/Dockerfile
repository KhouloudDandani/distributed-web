FROM openjdk:11

EXPOSE 8001

ADD target/EurekaServer-0.0.1-SNAPSHOT.jar exec.jar

ENTRYPOINT ["java", "-jar", "exec.jar"]