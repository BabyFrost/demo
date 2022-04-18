FROM sgrio/java:jdk_11
MAINTAINER Voufack Harold (haroldvoufack@gmail.com)
COPY /target/demo-0.0.1-SNAPSHOT.jar /usr/local/service/target/demo.jar
WORKDIR /usr/local/service
ENTRYPOINT ["java","-jar","target/demo.jar"]