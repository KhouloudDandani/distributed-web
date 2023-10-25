FROM openjdk:11

EXPOSE 8082

ADD target/Reclamation_MS-0.0.1-SNAPSHOT.jar exec.jar

ENTRYPOINT ["java", "-jar", "exec.jar"]