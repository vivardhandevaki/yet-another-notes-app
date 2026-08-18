package com.vivardhandevaki.notes;

import org.springframework.stereotype.Service;

@Service
class NoteService {

    private final NoteRepository noteRepository;

    NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    NoteResponse create(CreateNoteRequest request) {
        Note saved = noteRepository.save(new Note(request.title(), request.content()));
        return NoteResponse.from(saved);
    }
}
