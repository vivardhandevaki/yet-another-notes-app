# Design: enable-solo-review-posture-p4-22

## Context

Notes is solo-maintained: external review defaults required, `verify` is the sole GitHub check, and `create-note` is separate.

## Decisions

- Set target `ci_mode`/`human_mode` to `advisory` explicitly.
- Require local Codex review after verification, outside CI evidence.
- Regenerate workflows without advisory jobs; retain deterministic verification and use a JUnit file-reading policy oracle.

## Risks / Trade-offs

- [No external gate] → Deterministic/oracle checks and local review remain.
- [Local review is not CI evidence; concurrent `create-note`] → State the limit and leave that work intact.

## Migration Plan

Seal, configure, regenerate, verify, merge, then rerun `create-note`.
