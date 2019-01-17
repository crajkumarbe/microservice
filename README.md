Spring Microservices :-
Example of a microservice architecture using Spring Cloud

Overview
The architecture is composed by four services:
* discovery-service: Service Discovery Server created with Eureka
* api-gateway: API Gateway created with Zuul that uses the discovery-service to send the requests to the services. It uses Ribbon as Load Balancer
* huntgroup-service: Simple REST service created with Spring Boot to use as an example
* autoattendent-service: Simple REST service created with Spring Boot to use as an example
The services: api-gateway, article-service and author-service are already configured with Hystrix (latency and fault tolerance library) and are providing a stream that you can use to monitor with a Hystrix/Turbine dashboard. You can check the Hystrix Stream accessing the service URL with /hystrix.stream (example: http://localhost:8080/hystrix.stream)

How to use
To test this architecture you will need to have: JDK 8+, Docker and Maven installed
* Clone this repo and enter it 
* Run the start.sh script, it will use Maven to build the .jar file for each service and then use Docker to build the containers with the .jar files 
In the default configuration you will have:
* Discovery Service running on port 8083, access http://localhost:8083 to see the dashboard
* API Gateway running on port 8080, you will send the requests to this service
* Two Article Services running on ports: 8081 
* Two Author Services running on ports: 8082

Note:- For running the indivisual java applications use fallowing commad.
  mvn spring-boot-run

API Url:-


API Url:- 
Open browser or curl hit the fallowing urls 
* http://localhost:8080/api/autoattendents
* http://localhost:8080/api/huntgroups
