FROM openjdk:8-jre-alpine
RUN mkdir -p /opt/services/log/
COPY wait-for /opt/services/wait-for
RUN chmod +x /opt/services/wait-for
COPY target/push-service.jar /opt/services/push-service.jar
EXPOSE 9093
ENTRYPOINT ["java","-jar","/opt/services/push-service.jar"]