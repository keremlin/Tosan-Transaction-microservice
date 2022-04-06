FROM openjdk:latest
MAINTAINER Arash
COPY target/transaction-0.0.1-SNAPSHOT.jar transaction.jar
ENTRYPOINT [ "java","-jar", "-Dspring.profiles.active=${DATASOURCE} -Dspring.profiles.active=${DBUNAME} -Dspring.profiles.active=${DBPASS}","/customer.jar" ]
