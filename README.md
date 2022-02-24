Test para Interfell 

Lanzar maven clean install para buildar la aplicacion 
Lanzar mvn spring-boot:run  para deployar con el tomcat puerta 8090

http://localhost:8090/swagger-ui.html#/  -> Ubicacion del Swagger 

http://localhost:8090/h2-console   -> Ubicacion de la base de datos en RAM 



Para arrancarlo con Docker 
 mvn clean package

 docker run -d -p 8080:8080 --name microservicio interfell/interfell-backend-0.0.1-SNAPSHOT
