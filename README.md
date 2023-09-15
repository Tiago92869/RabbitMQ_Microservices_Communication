# RabbitMQ_Microservices_Communication
Demonstration on how to make communications between microservices using RabbitMQ


The demo is composed by two java spring projects:
-appointment-service
-user-service


To run the demo, just run in a terminar in user-service the command "docker-compose up", it will start the rabbitmq image and the postgres. 

After that you need to create the userDB in postgres (sorry)

After that you can run the user-service application and it should be working just fine.

After that you run again "docker-compose up" but this time in the appointment-service terminal to start the postgres image in docker. 

After that you need to create the appointmentDB in postgres (sorry again)

After you can run the appointment-service application and it should be workig just fine.

The communication example is when you delete a user, in the user-service, the service will send a message to the application-service, via rabbitmq, to delete all appointments that have the same userId as the one that was deleted.