# Oracles

## ORC-create-note-001: Create a valid note through the HTTP API

**Given** the application is running with its configured persistence store
**When** a client posts a non-blank title and content to `/notes`
**Then** the response is HTTP 201 and returns the persisted note's generated identifier, title, and content

```yaml crucible-binding
requirement: REQ-notes-create-1
kind: integration
runner: junit
target: com.vivardhandevaki.notes.NoteControllerIntegrationTest#createsNote
```

## ORC-create-note-002: Reject a note with a blank title

**Given** the application is running with its configured persistence store
**When** a client posts a blank title and non-blank content to `/notes`
**Then** the response is HTTP 400 and no note is persisted

```yaml crucible-binding
requirement: REQ-notes-validation-2
kind: integration
runner: junit
target: com.vivardhandevaki.notes.NoteControllerIntegrationTest#rejectsBlankTitle
```

## ORC-create-note-003: Reject a note with blank content

**Given** the application is running with its configured persistence store
**When** a client posts a non-blank title and blank content to `/notes`
**Then** the response is HTTP 400 and no note is persisted

```yaml crucible-binding
requirement: REQ-notes-validation-2
kind: integration
runner: junit
target: com.vivardhandevaki.notes.NoteControllerIntegrationTest#rejectsBlankContent
```
