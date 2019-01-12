# Alpine because it's lighter
FROM openjdk:8-jdk-alpine
MAINTAINER Ramamohan <polu.java@gmail.com>

# Set ENV variables
ENV PORT=8081
ENV DISCOVERY_URL="http://discovery:8083"

# Add JAR file and run it as entrypoint
ADD target/autoattendent-service.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port
EXPOSE 8081
