# Design: enable-advisory-ci-review

## Context

Notes is pinned to Crucible P4-15, whose detached reviewer reads a strict `review.ci_mode` field from the target branch. The project deliberately has no paid CI-review credential yet. P4-15 requires an explicit `advisory` policy; secret absence must never choose the mode.

## Decisions

- Add only `review.ci_mode: advisory` to `crucible.yaml`. The field is enforcement configuration, so the existing risk glob routes this change as critical.
- Bind a JUnit oracle to the committed configuration text. It is red before the field exists and becomes green only when the exact target-branch policy is added.
- Keep branch protection outside this diff: `verify` and `route` remain required operational controls, while `review-agent` and `judge` are deliberately not required during this temporary advisory posture.

Alternatives rejected: inferring advisory from an absent API key would weaken fail-closed behavior; deleting the reviewer workflow would erase the policy boundary; treating local review as merge evidence would violate the target-branch authority model.

## Risks / Trade-offs

- [No adversarial CI reviewer runs] → The policy result remains conspicuous, local review remains feedback only, and deterministic/oracle gates stay mandatory.
- [Configuration-text oracle is narrow] → The P4-15 workflow and framework tests establish scheduling behavior; the product oracle attests only to this project policy selection.
- [Future re-enablement requires coordination] → Add credentials, merge a separate `advisory` to `required` config change, validate the detached reviewer, then require its judge check.

## Migration Plan

1. Approve the sealed policy and red oracle.
2. Implement the single enforcement-config field and confirm the oracle passes.
3. Merge only with `verify` and `route` required.
4. Re-run the preserved `create-note` PR under the advisory target policy without editing its sealed bundle.
