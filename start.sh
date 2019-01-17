#!/bin/bash

echo Discovery Service: BUILDING
cd discovery-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILDING
cd api-gateway
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Customer Service: BUILDING
cd customer-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Customer Service: BUILD DONE
echo Order Service: BUILDING
cd order-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Customer Service: BUILD DONE
echo Order Service: BUILD DONE
echo ---
echo Starting Application...
docker-compose up --build
