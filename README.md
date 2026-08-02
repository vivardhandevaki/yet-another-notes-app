# yet-another-notes-app

`yet-another-notes-app` is a Spring Boot notes application being built with the
Crucible v2 workflow. The repository currently contains the project foundation
only; note-management features and HTTP endpoints have not been implemented.

## Technology

- Java 17
- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- Bean Validation
- H2 in-memory database for the proof of concept
- JUnit 5 via Spring Boot Test

## Project layout

- `src/main/java` — Spring Boot application entry point
- `src/main/resources` — application configuration
- `src/test/java` — context-loading test

## Prerequisites

- Java 17 or later

The Maven Wrapper is included, so a separate Maven installation is not needed.

## Run locally

Start the application:

```bash
./mvnw spring-boot:run
```

The embedded server listens at http://localhost:8080. At this stage there are
no application endpoints.

## Test

```bash
./mvnw test
```

## Change workflow

Code, build, configuration, dependency, and test changes use the Crucible v2
workflow described in [AGENTS.md](AGENTS.md). Documentation-only repository
updates can follow the normal pull-request workflow.
