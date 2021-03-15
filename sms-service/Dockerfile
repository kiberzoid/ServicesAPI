FROM openjdk:15-jdk-alpine
RUN mkdir -p /opt/services/log/
COPY target/sms-service.jar /opt/services/sms-service.jar
EXPOSE 9091
ENTRYPOINT ["java","-jar","/opt/services/sms-service.jar"]