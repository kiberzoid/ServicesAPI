FROM openjdk:8-jre-alpine
RUN mkdir -p /opt/services/log/
COPY wait-for /opt/services/wait-for
RUN chmod +x /opt/services/wait-for
COPY target/gateway-service.jar /opt/services/gateway-service.jar
EXPOSE 9095
ENTRYPOINT ["java","-jar","/opt/services/gateway-service.jar"]