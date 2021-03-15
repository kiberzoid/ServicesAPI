FROM openjdk:15-jdk-alpine
RUN mkdir -p /opt/services/log/
COPY target/discovery-service.jar /opt/services/discovery-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/opt/services/discovery-service.jar"]