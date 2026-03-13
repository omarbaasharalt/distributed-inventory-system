AUTH Gateway
Overview


The API Gateway acts as the single entry point for all client requests in the distributed system. 
It routes incoming requests to the appropriate microservice, such as the Auth Service, Inventory Service, or Notification Service.
 This simplifies client interaction by providing one unified access point. 
The gateway forwards requests using route rules and enables centralized request handling. 
The API Gateway runs on port 8080.



This service is part of a microservice architecture that includes:

API Gateway

Auth Service

Inventory Service

Notification Service