FROM openjdk:latest
COPY target/transaction-0.0.1-SNAPSHOT.jar transaction.jar
ENTRYPOINT [ "java","-jar", "/transaction.jar" ]
