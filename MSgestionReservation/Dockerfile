FROM openjdk:11

EXPOSE 8080

ADD target/MSgestionReservation-0.0.1-SNAPSHOT.jar exec.jar

ENTRYPOINT ["java", "-jar", "exec.jar"]