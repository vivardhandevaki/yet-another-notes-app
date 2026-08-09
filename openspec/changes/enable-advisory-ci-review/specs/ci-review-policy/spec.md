# Spec delta: ci-review-policy

## ADDED Requirements

### Requirement: Explicit advisory CI-review policy [REQ-ci-review-policy-1]

The target-branch enforcement configuration SHALL set `review.ci_mode` to `advisory`.

#### Scenario: Target branch selects advisory mode

- **WHEN** the committed target-branch `crucible.yaml` is read by the P4-15 policy job
- **THEN** it selects advisory CI-review mode without depending on API-key presence or local settings
