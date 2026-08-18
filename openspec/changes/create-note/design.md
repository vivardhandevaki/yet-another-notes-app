# Design: create-note

## Context

The Spring Boot application has no note domain or HTTP endpoints. Its existing dependencies already provide Spring MVC, Bean Validation, Spring Data JPA, H2, and JUnit 5, so the first endpoint should establish a conventional and dependency-free vertical slice.

## Decisions

- Model notes as a JPA entity with a generated identifier, title, and content. This gives the endpoint durable semantics without designing user ownership or lifecycle fields prematurely.
- Keep the entity name `Note` and verify rejected requests through the JPA persistence context. This makes the "not persist" requirement observable without adding an out-of-scope listing endpoint.
- Use a request DTO with Bean Validation annotations and let Spring MVC reject invalid input before the service persists it. This keeps validation rules explicit at the HTTP boundary.
- Return a response DTO rather than exposing the entity. This keeps persistence representation separate from the API as the application evolves.
- Exercise the endpoint with Spring Boot integration tests using MockMvc and the configured H2 database. The observable HTTP and persistence behavior is the contract; unit-testing controller internals is not sufficient.

## Risks / Trade-offs

- [H2 differs from a future production database] → The feature is limited to basic persistence with no vendor-specific SQL.
- [No ownership or authentication model exists] → The endpoint is intentionally unauthenticated for this first PoC slice; authorization is out of scope.
- [Returning the generated identifier requires a persistence flush] → Persist through JPA before mapping the response so the identifier is available.

## Migration Plan

No data migration is required. The H2 PoC schema is created from the JPA entity at application startup; rollback removes the endpoint and entity before any production database is introduced.
