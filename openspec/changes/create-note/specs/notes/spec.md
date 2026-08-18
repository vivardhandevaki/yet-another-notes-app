# notes

## ADDED Requirements

### Requirement: Create a note [REQ-notes-create-1]

The system SHALL create and persist a note when `POST /notes` receives a request with a non-blank title and non-blank content, and SHALL return HTTP 201 with the created note's identifier, title, and content.

#### Scenario: Create a valid note

- **WHEN** a client posts `{ "title": "Shopping", "content": "Buy coffee" }` to `/notes`
- **THEN** the response is HTTP 201 and contains a generated identifier, title `Shopping`, and content `Buy coffee`

### Requirement: Reject an invalid note [REQ-notes-validation-2]

The system SHALL reject a create-note request whose title or content is blank with HTTP 400 and SHALL not persist a note.

#### Scenario: Reject a blank title

- **WHEN** a client posts `{ "title": " ", "content": "Buy coffee" }` to `/notes`
- **THEN** the response is HTTP 400 and no note is persisted

#### Scenario: Reject blank content

- **WHEN** a client posts `{ "title": "Shopping", "content": " " }` to `/notes`
- **THEN** the response is HTTP 400 and no note is persisted
