package com.vivardhandevaki.notes;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class SoloReviewPosturePolicyTest {

    @Test
    void selectsSoloReviewPosture() throws IOException {
        String enforcement = Files.readString(Path.of("crucible.yaml"));
        String settings = Files.readString(Path.of(".crucible/settings.yaml"));
        String workflow = Files.readString(Path.of(".github/workflows/crucible.yml"));

        assertThat(enforcement).containsPattern(
                "(?ms)^review:\\R\\s+ci_mode:\\s+advisory\\s*$\\R\\s+human_mode:\\s+advisory\\s*$");
        assertThat(settings).containsPattern("(?m)^review:\\R\\s+local_mode:\\s+required\\s*$");
        assertThat(workflow).contains("\n  verify:\n");
        assertThat(workflow).doesNotContain("\n  route:\n");
        assertThat(Files.exists(Path.of(".github/workflows/crucible-review.yml"))).isFalse();
    }
}
