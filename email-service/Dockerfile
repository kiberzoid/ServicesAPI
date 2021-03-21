FROM openjdk:15-jdk-alpine
RUN mkdir -p /opt/services/log/
COPY wait-for /opt/services/wait-for
COPY target/email-service.jar /opt/services/email-service.jar
EXPOSE 9092
ENTRYPOINT ["java","-jar","/opt/services/email-service.jar"]