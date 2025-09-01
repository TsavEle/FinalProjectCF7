This is my project for Coding Factory 7.
It is an SSR Java application, using MySQL.

Open MySQL Workbench -> Go to File → Open SQL Script, select db/TsavlisFullDump.sql
Click Execute.

Database connection for the app:

spring.datasource.url="jdbc:mysql://localhost:3306/test_schema?serverTimeZone=UTC"
spring.datasource.username="lawyer_admin"
spring.datasource.password="Lawyer12345!"

You can run with mvn clean and mvn jetty:run
The dump includes empty tables for lawyers and lawyers_skills.
It also includes the tables cities, skills and tha data needed for the app to run properly.

These are the requirements for the app:
Java 17+
Maven
MySQL 8+
IntelliJ
