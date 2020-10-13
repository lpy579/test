# SpringBootAdminLTE - Developer Notes



This is an example Java Web Application mainly using [SpringBoot 2](https://spring.io/projects/spring-boot) and [AdminLTE-3.0.5](https://adminlte.io/).



## Developer Notes

The development environment:

  - OS: Windows 10 Pro 64-bit.
  - JDK: [Oracle JDK 8](https://www.oracle.com/java/technologies/javase-downloads.html)
  - Maven: [Apache Maven 3](https://maven.apache.org/)
  - IDE: 
    - [Spring Tools 4](https://spring.io/tools), or [Eclipse IDE for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/)
    - [IntelliJ IDEA](https://www.jetbrains.com/idea/)


Maven build commands:

1. Create the web application at [spring initializr](https://start.spring.io/).

2. Build the web application.

   ```shell
   # Check jar dependency, useful in finding the conflicting jars
   mvn dependency:tree
   
   # Download dependencies, including source code
   mvn dependency:sources -DdownloadSources=true -DdownloadJavadocs=false
   
   # Run spring-boot application as a standalone application, 
   # URL at http://localhost:8080/
   mvn spring-boot:run
   
   # Clean up target folder (delete all)
   mvn clean
   
   # Build (include testing) and install to local repository
   mvn install
   
   # Build the release package
   # To skip unit testing, add parameter: -Dmaven.test.skip=true
   mvn clean package
   
   # Generate static site and reports
   mvn site
   ```



## IDE Setup

Just setup like a standard Java application. 



## Database Setup

This example can use H2, and MySQL as back-end database. H2 is a file based database, it is mostly used in testing, while MySQL is used in production.

The database connection is configured in `application.yml` under the main resources folder `src/main/resources`.


### H2

This is a file based database, the DB connection URL is set to: `database.url=jdbc:h2:~/h2/SpringBootAdminLTE` in resources file `application.properties`. The data folder  `~/h2` is in current user's home, and the data file will be created by Hibernate if not yet exist.

When this application is running, you can use the H2 database console via link: 

http://localhost:8080/h2-console



## Deployment

The following steps are for Windows, but they should apply the same to Linux.

Before deployment, we should have generated the release package `SpringBootAdminLTE-0.0.1-SNAPSHOT.jar` in target folder:

```shell
mvn clean package -Dmaven.test.skip=true
```

Since this is a Spring boot application, it uses the embedded Tomcat, so simple run this jar to launch it.

```shell
java -jar SpringBootAdminLTE-0.0.1-SNAPSHOT.jar
```

Open a browser, enter this URL to access the web application: http://localhost:8080/

If anything goes wrong, check the web application log in `logs` folder.



To stop Jetty, just press "Ctrl+C" to terminate the process.



## Know problems

1. The "Flash Message" in "layout.html" is not working. When add or delete a customer, it should show a message.
2. 

