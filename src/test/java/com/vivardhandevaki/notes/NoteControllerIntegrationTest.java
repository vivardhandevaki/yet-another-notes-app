package com.vivardhandevaki.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class NoteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void createsNote() throws Exception {
        mockMvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"title":"Shopping","content":"Buy coffee"}
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.title").value("Shopping"))
                .andExpect(jsonPath("$.content").value("Buy coffee"));
    }

    @Test
    void rejectsBlankTitle() throws Exception {
        mockMvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"title":" ","content":"Buy coffee"}
                                """))
                .andExpect(status().isBadRequest());

        assertNoNotesPersisted();
    }

    @Test
    void rejectsBlankContent() throws Exception {
        mockMvc.perform(post("/notes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"title":"Shopping","content":" "}
                                """))
                .andExpect(status().isBadRequest());

        assertNoNotesPersisted();
    }

    private void assertNoNotesPersisted() {
        Long count = entityManager
                .createQuery("select count(note) from Note note", Long.class)
                .getSingleResult();
        assertThat(count).isZero();
    }
}
