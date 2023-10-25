# Hotels
## _Hotel Management System_

Hotel Management System is a web application in which we've used the microservice architecture,
Angular application powered by springBoot & Keycloack.

## Physical architecture

- The eureka server used as discovery Service
- Reservation Microservice using MySQL Database
- Forum Microservice using MySQL Database
- Reclamation Microservice powered by H2 Database
- API Gateway for inter-communicating all services 

The front end application has been developped by the latest version of Angular.

> The whole application has been dockorized
> for each instance of database we have created a standalone container


In Order to launch the application you'll need to have docker installed on your machine and then just type the following command on your terminal:
`docker-compose up`

By default, the Docker will expose port 8090 for the API Gateway, 8001 for the eurka in order to monitor available services connected.