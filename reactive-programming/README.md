# Goals of this project

This is a minimal Spring Boot project demonstrating reactive programming with Flux and Mono.


## Getting the application up and running
You need a Postgres database. By default, the database name is "reactive". You have to create this database:

```
CREATE DATABASE reactive;
```

After that, the application automatedly creates the database table "EMPLOYEE".

The Java code is a simple Maven project running on Java 17. You can start it
- by running the commmand mvn spring-boot:run
- or by starting the class de.beyondjava.ReactiveProgrammingApplication.

There's also a small Postman collection of the API calls.

## Creating test data
The `src/main/typescript` folder contains a small script generating test data. Just open a terminal in this folder and run

```
npm run run
```

(no typo - I've really called the script "run" because it types fast).