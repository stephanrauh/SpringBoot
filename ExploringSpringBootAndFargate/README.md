# Goals of this project

This is a minimal Spring Boot project demonstrating how to use Lombok along with MapStruct, Java Bean Validation,
and domain-oriented layering.

## Compiling a local docker image
```
mvn compile jib:build
```

## Domain-oriented layering
Traditionally, Java developers use horzontal layering. There's a controller layer, a service layer, and entity layer,
and possibly several others. This project does it the other way round. Technology has evolved to a point we don't
need these horizontal layers any more. Instead, the challenges are in the business domain, so it makes sense to put
the classes which belong together in a common package.

## Mapstruct
Mapstruct takes the string out of mapping entities to DTO. The reason for adding DTOs in this project is avoiding
technical informations, such as primary keys.

## Lombok
Lombok seems to be a first-class citizen of Spring Boot nowadays, so let's use it to reduce the amount of boiler-plate code.

I'm also experimenting the Lombok's `val` keyword. It's a pity that `val` didn't make it to the Java language,
but it seems `val` is a useful workaround. There's even IntelliJ support for it.

## Using records instead of Lombok
By definition, DTOs are immutable data classes, so it sounds like a good idea to implement the DTO as a record. Mapstruct
generates the ugly parts of the code (i.e. using the constructur which may have dozens of parameters)
and hides it from you. So you're working with code that looks clean enough.

The only challenge is you need to convince your code formatter to format the record definition nicely. By default,
the entire record definition is single line, which looks a bit weird for a data class.

## Creating records directly from a JPA query in a repository
You can also return records from a repository:
```java
@Query("""
       SELECT new de.beyondjava.business.projects.ProjectDto(
              p.name, p.description)
       FROM Project p
       WHERE LOWER(p.name) = LOWER(:projectName)
       """)
List<ProjectDto> findProjectDtosByProjectName(
                     @Param("projectName") String projectName);
```

## Java Bean Validation
Controllers, DTOs, and Entities make use of the bean validation annotations. There's also a global error handler
converting the technical messages Spring generates to more user-friendly messages.

## Global and local error handlers
The project has two global error handlers, one of them catching validation errors, the other catching the 
"ElementNotFoundException" thrown by Optional.orElseThrow().

For the sake of demonstration, there's also an exception handler in a controller.

## Getting the application up and running
It's a simple Maven project running on Java 17. You can start it
- by running the commmand mvn spring-boot:run
- or by starting the class de.beyondjava.ExploringMapStructApplication.

There's also a small Postman collection of the API calls.

## Creating test data
The `src/main/typescript` folder contains a small script generating test data. Just open a terminal in this folder and run

```
npm run run
```

(no typo - I've really called the script "run" because it types fast).