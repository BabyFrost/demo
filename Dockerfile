FROM sgrio/java:jdk_11
MAINTAINER Voufack Harold (haroldvoufack@gmail.com)
ENV	CONFIG_SOURCE_SERVICE_URL = ""
COPY /target/demo-0.0.1-SNAPSHOT.jar /usr/local/service/target/demo.jar
WORKDIR /usr/local/service
ENTRYPOINT ["java","-jar","target/demo.jar","--SOURCE_SERVICE_URL=${CONFIG_SOURCE_SERVICE_URL}"]