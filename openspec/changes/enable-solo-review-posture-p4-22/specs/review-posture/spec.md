# Spec delta: review posture

## ADDED Requirements

### Requirement: Explicit solo review posture [REQ-solo-review-posture-1]

The Notes repository SHALL configure `review.ci_mode` and `review.human_mode`
as `advisory` in target-branch `crucible.yaml`, and SHALL configure
`review.local_mode` as `required` in `.crucible/settings.yaml`. Deterministic
verification and all bound oracle tests MUST remain required merge evidence.

#### Scenario: Solo policy is read from committed configuration

- **WHEN** the policy oracle reads the repository committed Crucible configuration
- **THEN** it finds advisory CI/human modes, required local review, and unchanged deterministic verification
