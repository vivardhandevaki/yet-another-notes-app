# Implementation tasks: create-note

- [ ] Add the `Note` JPA entity with generated id, title, and content.
- [ ] Add persistence access and a create-note service that saves the entity before building the response.
- [ ] Add request and response DTOs; enforce non-blank title and content at the HTTP boundary.
- [ ] Add `POST /notes` that delegates creation and returns HTTP 201 with id, title, and content.
- [ ] Run the sealed `NoteControllerIntegrationTest` oracle class and the full Maven test suite until green.
