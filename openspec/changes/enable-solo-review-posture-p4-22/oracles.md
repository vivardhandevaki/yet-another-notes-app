# Oracles

## ORC-solo-review-posture-001: Select the explicit solo review posture

**Given** the Notes repository contains its committed Crucible configuration
**When** the policy oracle reads enforcement and convenience configuration
**Then** it observes advisory CI/human modes, required local review, and deterministic verification

```yaml crucible-binding
requirement: REQ-solo-review-posture-1
kind: unit
runner: junit
target: com.vivardhandevaki.notes.SoloReviewPosturePolicyTest#selectsSoloReviewPosture
```
