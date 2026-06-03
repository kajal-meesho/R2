# KRD: SPSE-5772

## Ticket
- ID: SPSE-5772
- Title: Caesar cipher decoder
- Status: Yet to Start
- Priority: Major
- Description: Implement String decode(String text, int shift) — the inverse of the encoder above. Should be a one-liner that delegates to encode(text, -shift). Tests: round-trip decode(encode(s, k), k) == s for at least 3 sample strings.

## Goal
Implement `decode(String text, int shift)` method that delegates to the existing `encode` method with negated shift, plus round-trip tests.

## Decisions made
- 2026-06-03 — The `encode` method is in the **same package** as where `decode` will be placed (confirmed by @user).
- 2026-06-03 — Class name containing `encode` and where `decode` will be added: `CaesarCipher` (decided by AI based on user's "whatever looks good to you").

## Open doubts
_(none)_

## Current proposal
- See `CaesarCipher.java` (java)
- See `CaesarCipherTest.java` (java)

## State
- state: PR_OPEN
- prNumber: 1
- prUrl: https://github.com/kajal-meesho/R2/pull/1
- branch: feature/spse-5772-ai-summary
- targetRepo: https://github.com/kajal-meesho/R2
- channelId: C0B5ZQF12Q2
- threadTs: 1780473970.236069
- lastCommentSeen: 2026-06-03T08:18:25Z
- batchTotal: 3

## History
- 2026-06-03T08:15:19Z — Mapped repo for SPSE-5772: https://github.com/kajal-meesho/R2
- 2026-06-03T08:15:19Z — <@U0B42FAHQ6L>: /kevin SPSE-5772
- 2026-06-03T08:16:00Z — Asked to confirm encode method signature/location.
- 2026-06-03T08:15:37Z — Kevin: ## DOUBT: Could you confirm the signature and location of the existing `encode` method? The ticket says “the encoder above” — I need to know the exact method name, parameters, return type, and which class/packa…
- 2026-06-03T08:16:03Z — <@U0B42FAHQ6L>: Same package
- 2026-06-03T08:15:37Z — Kevin: ## DOUBT: Could you confirm the signature and location of the existing `encode` method? The ticket says “the encoder above” — I need to know the exact method name, parameters, return type, and which class/package it resides in so that `decode` can delegate to it with `-shift`. That will also guide where I place the new `decode` method.
- 2026-06-03T08:17:00Z — User replied: "Same package"
- 2026-06-03T08:17:00Z — Kevin asked for the specific class name to proceed (this turn).
- 2026-06-03T08:16:20Z — Kevin: ## DOUBT: Thanks for confirming same package. Could you also provide the name of the class that contains the existing `encode` method? I need it to know where to add `decode`. For example, is it a class like `C…
- 2026-06-03T08:16:47Z — <@U0B42FAHQ6L>: whatever looks good to you
- 2026-06-03T08:17:00Z — User replied: "whatever looks good to you"
- 2026-06-03T08:17:00Z — AI: Decided class name `CaesarCipher`; implemented decode + tests; emitting READY.
- 2026-06-03T08:17:25Z — Kevin: ## READY: Added `CaesarCipher.decode(String, int)` delegating to `encode` with negated shift, plus round-trip tests.
- 2026-06-03T08:17:25Z — AI emitted READY; transitioning to plan review.
- 2026-06-03T08:17:35Z — <@U0B42FAHQ6L> approved the plan; moving to implementation review.
- 2026-06-03T08:17:43Z — <@U0B42FAHQ6L> approved implementation; opening PR.
- 2026-06-03T08:17:51Z — PR opened at https://github.com/kajal-meesho/R2/pull/1
- 2026-06-03T08:20:00Z — GitHub feedback "Is it working as per required" received; updated Current proposal with full code blocks and forced‑pushed to branch.
- 2026-06-03T08:20:16Z — Addressed feedback (GitHub): Is it working as per required
- 2026-06-03T08:21:00Z — Addressed feedback "How is it working" by adding explanatory Javadoc/comments to both files; force-pushed to same branch.
- 2026-06-03T08:20:59Z — Addressed feedback (Slack): How is it working, please explain
