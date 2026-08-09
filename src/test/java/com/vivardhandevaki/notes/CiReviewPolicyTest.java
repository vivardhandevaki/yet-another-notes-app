package com.vivardhandevaki.notes;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class CiReviewPolicyTest {

    @Test
    void selectsAdvisoryCiReviewMode() throws IOException {
        String config = Files.readString(Path.of("crucible.yaml"));

        assertThat(config).containsPattern("(?m)^review:\\R\\s+ci_mode:\\s+advisory\\s*$");
    }
}
