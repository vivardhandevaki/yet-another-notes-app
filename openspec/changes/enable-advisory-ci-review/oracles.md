# Oracles

## ORC-ci-review-policy-001: Target branch explicitly selects advisory mode

**Given** the Notes enforcement configuration is committed at the repository root
**When** the configuration policy oracle reads `crucible.yaml`
**Then** it finds `review.ci_mode` set to `advisory`

```yaml crucible-binding
requirement: REQ-ci-review-policy-1
kind: unit
runner: junit
target: com.vivardhandevaki.notes.CiReviewPolicyTest#selectsAdvisoryCiReviewMode
```

