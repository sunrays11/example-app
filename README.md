# Spring-boot-h2 Swagger
In this example I have used H2 as in memory database and rest web services are exposed via Swagger-UI.
Project can be executed as follows: 

 - mvn clean
 - mvn install
 - mvn spring-boot:run

After the project is up and running DB, Service and Swagger-UI can be accessed as follows:

 - DB
	 - Access localhost:8080/h2-console     with schema jdbc:h2:mem:testdb  connect and see tables data.
 
 - Service

	 - Student
		 - GET  localhost:8080/student
	 	 - GET  localhost:8080/student/{studentid}
		 - POST localhost:8080/student
		 - PUT  localhost:8080/student
		 - DELETE localhost:8080/student/{studentid}	

		 
 - Swagger-UI
	 - localhost:8080/swagger-ui.html
