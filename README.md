# DSW_Act3

Simple Web CRUD made with Spring Boot with user login.

## Requirements

- [Java JDK 17+](https://www.oracle.com/java/technologies/downloads/)
- [Apache NetBeans](https://netbeans.apache.org/download/index.html)
- [MySQL](https://dev.mysql.com/downloads/mysql/)

## How to run on local

### Using NetBeans

1. Clone the repo
   ```bash
   git clone https://github.com/hhenaor/DSW_Act3
   ```

2. Execute MySQL and create the database with the ``squema.sql`` file.

3. Open on NetBeans

4. Change ``application.properties`` (Default XAMPP settings)

``` env
spring.datasource.url=jdbc:mysql://localhost:3306/Actividad3?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

6. Run and open `http://localhost:8080`
