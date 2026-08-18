package com.vivardhandevaki.notes;

record NoteResponse(Long id, String title, String content) {
    static NoteResponse from(Note note) {
        return new NoteResponse(note.getId(), note.getTitle(), note.getContent());
    }
}
