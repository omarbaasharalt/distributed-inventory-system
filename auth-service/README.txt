Auth Service 

The Auth Service handles basic authentication within the distributed system. 
It provides a login endpoint that validates user credentials and returns a simple token and role information. 
The service demonstrates basic authentication concepts used in distributed systems. 
It is accessed through the API Gateway and supports roles such as ADMIN and USER. This service runs on port 8081.

This service is part of a microservice architecture that includes:

API Gateway

Auth Service

Inventory Service

Notification Service