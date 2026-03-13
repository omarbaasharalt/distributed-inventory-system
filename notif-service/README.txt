Notification Service
Overview

The Notification Service is responsible for receiving and storing system alerts. 
In this project it mainly handles low-stock alerts sent from the Inventory Service. 
When inventory levels drop below a defined threshold, the Inventory Service sends a REST request to this service. 
The service records the notification and provides an endpoint to retrieve alert history. This microservice runs on port 8082.

This service is part of a microservice architecture that includes:

API Gateway

Auth Service

Inventory Service

Notification Service