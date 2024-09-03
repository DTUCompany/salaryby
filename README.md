# salaryby
# Spring application for managing and manipulating customer's payments 

# To build  project open powershell in main directory and execute commands


cd .\api-gateway\
./gradlew clean build -x test
cd ./..
cd .\discovery-service\
./gradlew clean build -x test
cd ./..
cd .\agreement-service\
./gradlew clean build -x test
cd ./..
cd .\invitation-service\
./gradlew clean build -x test
cd ./..
cd .\organisation-service\
./gradlew clean build -x test
cd ./..
cd .\user-agreement-service\
./gradlew clean build -x test
cd ./..
cd .\user-service\
./gradlew clean build -x test

cd ./..

# To create network for docker containers execute

docker network create salaryby

# To create images for services execute 

cd .\postgres\
docker build -t salary-postgres .
cd ./..
cd .\api-gateway\
docker build -t api-gateway .
cd ./..
cd .\mongo\
docker build -t salary-mongo .
cd ./..
cd .\discovery-service\
docker build -t discovery-service .
cd ./..
cd .\agreement-service\
docker build -t agreement-service .
cd ./..
cd .\invitation-service\
docker build -t invitation-service .
cd ./..
cd .\organisation-service\
docker build -t organisation-service .
cd ./..
cd .\user-agreement-service\
docker build -t user-agreement-service .
cd ./..
cd .\user-service\
docker build -t user-service .

# To run application execute

docker run -p 27017:27017 -d --name salary-mongo --network salaryby salary-mongo
docker run -p 5432:5432 -d --name salary-postgres --network salaryby salary-postgres
docker run -p 27017:27017 -d --name salary-mongo --network salaryby api-gateway
docker run -p 8761:8761 -d --name discovery-service --network salaryby discovery-service
docker run -p 8081:8081 -d --name agreement-service --network salaryby agreement-service
docker run -p 8082:8082 -d --name invitation-service --network salaryby invitation-service
docker run -p 8083:8083 -d --name organisation-service --network salaryby organisation-service
docker run -p 8084:8084 -d --name user-agreement-service --network salaryby user-agreement-service
docker run -p 8085:8085 -d --name user-service --network salaryby user-service

# Access to services by addresses:
localhost:8761 - discovery service, eureka
localhost:8081 - agreement-service
localhost:8082 - invitation-service
localhost:8083 - organisation-service
localhost:8084 - user-agreement-service
localhost:8085 - user-service

# Swagger: 
localhost:<port>/swagger-ui.html