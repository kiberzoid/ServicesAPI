FROM openjdk:8-jre-alpine
RUN mkdir -p /opt/services/log/
COPY wait-for /opt/services/wait-for
RUN chmod +x /opt/services/wait-for
COPY target/sms-service.jar /opt/services/sms-service.jar
EXPOSE 9091
ENTRYPOINT ["java","-jar","/opt/services/sms-service.jar"]