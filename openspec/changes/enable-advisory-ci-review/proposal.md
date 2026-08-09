# Proposal: enable-advisory-ci-review

## Why

The project is intentionally deferring paid CI reviewer credentials while retaining its deterministic verification and routing gates. The target branch needs an explicit, reviewable policy rather than inferring behavior from a missing secret.

## What Changes

- Add `review.ci_mode: advisory` to the target-branch enforcement configuration.
- Retain `verify` and `route` as required branch-protection checks.
- Make the policy change observable through a bound JUnit oracle that reads the committed enforcement configuration.

## Impact

- `crucible.yaml` becomes an explicitly advisory CI-review policy input.
- The P4-15 detached reviewer workflow will skip paid reviewer preparation, agent execution, and judgment after this reaches the target branch.
- Product HTTP behavior, persistence, existing `create-note` artifacts, and local review remain unchanged.

## Unspecified

Providing `OPENAI_API_KEY`, restoring required CI review, changing branch-protection settings beyond retaining `verify` and `route`, reviewer-model selection, and product functionality are out of scope.

## Seams

The change crosses the target-branch enforcement-config seam and the P4-15 detached reviewer workflow. The preserved `create-note` product change is concurrently in flight and must not be edited.
