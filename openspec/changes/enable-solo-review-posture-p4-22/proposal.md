# Proposal: enable-solo-review-posture-p4-22

## Why

Notes is a solo-maintainer PoC without funded CI AI review; it needs explicit
external-review policy while retaining deterministic/oracle and fresh local review.

## What Changes

- Set advisory target CI/human review, required local review, and `verify` only.

## Impact

Only target enforcement, convenience settings, and managed workflows change.

## Unspecified

Credentials, external-review restoration, reviewer selection, GitHub settings beyond `verify`, and product behavior.

## Seams

Target config, managed workflows, local review; PR #8 remains untouched.
