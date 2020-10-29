# SpringBootAdminLTE - Developer Notes



This is an example Java Web Application mainly using [SpringBoot 2](https://spring.io/projects/spring-boot) and [AdminLTE](https://adminlte.io/).



Reference Links:

* [2020-04-21 - Spring Boot 基于 JUnit 5 实现单元测试](https://www.jianshu.com/p/4648fd55830e)



## Developer Notes

The development environment:

  - OS: Windows 10 Pro 64-bit.
  - JDK: [Oracle JDK 8](https://www.oracle.com/java/technologies/javase-downloads.html)
  - Maven: [Apache Maven 3](https://maven.apache.org/)
  - IDE: 
    - [Spring Tools 4](https://spring.io/tools), or [Eclipse IDE for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/)
    - [IntelliJ IDEA](https://www.jetbrains.com/idea/)



This web application is created using [spring initializr](https://start.spring.io/), and integrate with AdminLTE-3.0.5.

Maven build commands:

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

# Run all test cases
mvn test

# Build the release package
# To skip unit testing, add parameter: -Dmaven.test.skip=true
mvn clean package

# Generate static site and reports
mvn site
```




## IDE Setup

Just setup like any standard Java application. 



## Database Setup

This example can use H2, and MySQL as back-end database. H2 is a file based database, it is mostly used in testing, while MySQL can be used in production.

The database connection is configured in `application.yml` under the main resources folder `src/main/resources`.


### H2

This is a file based database, the DB connection URL is set to: `database.url=jdbc:h2:~/h2/SpringBootAdminLTE` in resources file `application.properties`. The data folder  `~/h2` is in current user's home, and the data file will be created by Hibernate if not yet exist.

When this application is running, you can use the H2 database console via link: 

http://localhost:8080/h2-console



## Deployment

The following steps are for Windows, but they should also apply the same to Linux.

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



## What's Next

1. Bug: The "Flash Message" in "layout.html" is not working. When add or delete a customer, it should show a message. 
2. Feature: Add error handler pages for default error, like 404, 500 etc.
3. Feature: Support backend DB connection failure and recovery.
4. Feature: Add a demo for charts (like bar, pie, line etc.) using [echart](https://echarts.apache.org).  **<-- Done! Do not choose!**
5. Feature: Add a chart demo, display the localhost CPU & RAM usage in real time (background update, no page refresh needed).
6. Feature: Add a demo for displaying tables, including using [DataTables](https://www.datatables.net/), [jsGrid](http://js-grid.com/), with advanced features like sorting, filtering, data editing, validation etc.
7. Feature: Add a demo for inputting single date values (in ISO format YYYY-MM-DD), using a pop-up date picker. User are also capable of inputting by keyboard.
8. Feature: Add a demo for inputting date range (begin date plus end date), using a pop-up date picker. User are also capable of inputting by keyboard.
9. Feature: Add a demo for different kinds of input values (like: single line of text, multi line of text, phone number, email, password, integer value, float value, dropdown single choice, grouped single choice radio-box, grouped multi-choice checkbox, dropdown multi-choice combo-box, file upload, image upload etc.), required to:
   * Mark some input-box as mandatory.  Submit button is grey (disabled) if these input are empty.
   * In the controller Java class, we can validate the validate all the input, which can show error beside for each input box after submit. 
   * When submit button is clicked, it will trigger one POST action, and can prevent been clicked multiple times (it will cause big trouble in backend data processing).
10. Feature: Add Spring Security demo, user are required to login for accessing protected URL resources, with user and group permission control, and the data is stored in database.
11. Feature: Add a game demo, guessing the number (1 to 100).



