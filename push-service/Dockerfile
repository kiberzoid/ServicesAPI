FROM openjdk:15-jdk-alpine
RUN mkdir -p /opt/services/log/
COPY target/push-service.jar /opt/services/push-service.jar
EXPOSE 9093
ENTRYPOINT ["java","-jar","/opt/services/push-service.jar"]