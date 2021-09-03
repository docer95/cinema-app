# Cinema app

The project was designed for cinemas. In this application the possibility to add new films, 
create movie sessions and define them in the hall where they will take place the realized. Also realized possibility 
of the user to register and buy a ticket for a particular movie session of interest.

### Technologies in this project:
* MySQL
* Hibernate
* Tomcat
* Spring (Core, MVC)
* JSON

### Setup
1. Download and install IntelliJ IDEA Ultimate
2. Download and install MySQL
3. Download and install Tomcat
4. Open this project
5. In this project, open the file that is located at the address cinema/src/main/resources/db.properties 
   and change fields (db.url - address behind which your database, db.user - your login,
   db.password - your password, db.driver - path for JDBC driver)
6. Add Configurations -> add new run configuration... -> Tomcat Server -> Local.
   After than go to tab "Deployment" -> to push button "fix" -> cinema:war exploded.
   After than scroll below, in field "Application context" -> write - "/"
7. Push "Run"
