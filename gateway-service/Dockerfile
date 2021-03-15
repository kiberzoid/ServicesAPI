FROM openjdk:15-jdk-alpine
RUN mkdir -p /opt/services/log/
COPY target/gateway-service.jar /opt/services/gateway-service.jar
EXPOSE 9095
ENTRYPOINT ["java","-jar","/opt/services/gateway-service.jar"]