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
echo Autoattendent Service: BUILDING
cd autoattendent-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Huntgroup Service: BUILD DONE
echo Huntgroup Service: BUILDING
cd huntgroup-service
mvn clean install -U
cd ..
clear

echo Discovery Service: BUILD DONE
echo API Gateway: BUILD DONE
echo Autoattendent Service: BUILD DONE
echo Huntgroup Service: BUILD DONE
echo ---
echo Starting Application...
docker-compose up --build
