# Alpine because it's lighter
FROM openjdk:8-jdk-alpine
MAINTAINER Rama Mohan <polu.java@gmail.com>

# Set ENV variables
ENV PORT=8083

# Add JAR file and run it as entrypoint
ADD target/discovery-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port
EXPOSE 8083