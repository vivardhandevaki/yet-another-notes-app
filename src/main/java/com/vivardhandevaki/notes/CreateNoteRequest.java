package com.vivardhandevaki.notes;

import jakarta.validation.constraints.NotBlank;

record CreateNoteRequest(
        @NotBlank String title,
        @NotBlank String content
) {
}
