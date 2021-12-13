## Resource Server
Ejemplo de resource server utilizando el framework OAuth2 implementado con Spring Boot y Spring Security.
Tambien contiene la API Rest de Courses.

La autenticación de un usuario se hace siguiendo el flujo [grant type password](https://oauth.net/2/grant-types/password/).

#### Configuración Authorization Server
Para poder acceder a los recursos el servicio se conecta al [authorization server](https://github.com/fhbustos/authorization-server) para validar los tokens. Los parámetros de configuración son los siguientes:
```
URL: http://localhost:9080/oauth/check_token
client-id: resourceserver
client-secret: resourceserversecret
```
Estos datos se pueden cambiar en el archivo `resources/application.yml`.

#### Configuración MySQL
El servidor está preparado para conectarse a una servidor de base de datos MySQL, los datos de conexión son: 
```
URL: localhost:3306
Username: root
Passowrd: rootpass
```
Estos datos se pueden cambiar en el archivo `resources/application.yml`.

#### Courses
Al iniciar el servidor el mismo realiza una precarga de cursos en la base de datos. Los datos utilizados para la carga se encuentran en el archivo `resources/data.sql`.


#### Build and Run
Para compilar y desplegar el proyecto se debe ejecutar por consola el comando:

```
mvn clean install
```
Luego para correr el servidor:

```
mvn spring-boot:run
```
El servidor quedará corriendo en la URL:
`http://localhost:9090/`

#### Testing
Se puede obtener más información de las pruebas en el proyecto [Course API Postman](https://github.com/fhbustos/Course-API-Postman).

### Referencias
* [Spring Security in Action](https://www.manning.com/books/spring-security-in-action)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-security)
* [Spring Security OAuth2](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#web.security.oauth2)
* [Baeldung Spring Security](https://www.baeldung.com/category/spring/spring-security/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
