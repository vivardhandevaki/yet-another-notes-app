# Proposal: create-note

## Why

The Notes application has only its foundation today, so users cannot create a note. A small creation endpoint establishes the first useful note-management capability and validates the governed workflow against a real Spring Boot feature.

## What Changes

- Add `POST /notes` accepting a title and content.
- Validate that both fields are present and non-blank.
- Persist the note in the configured database.
- Return the created note with an HTTP 201 response.

## Impact

- Adds a note domain model, persistence repository, service, controller, and request/response API types.
- Adds JUnit oracle tests for successful creation and invalid input.
- Does not add dependencies; Spring Web, Bean Validation, JPA, H2, and JUnit are already present.

## Unspecified

Editing, deleting, listing, authentication, note ownership, pagination, tags, and production database configuration are out of scope.

## Seams

The HTTP API crosses the Spring MVC validation boundary and the JPA/H2 persistence boundary. No external service or concurrent product change is known.
