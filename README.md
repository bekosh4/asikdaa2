# Assignment 2 — Algorithmic Analysis and Peer Code Review  
**Student A — Insertion Sort (Optimized for Nearly-Sorted Data)**

## 1. Algorithm Overview
This project implements an optimized version of the **Insertion Sort** algorithm with several improvements:
- Binary search to find the insertion point (`O(log i)` comparisons).
- Half-exchange optimization (block shifting instead of swaps).
- Early-termination if the array is already sorted.
- Sentinel skip when consecutive elements are already in order.

The algorithm is **in-place** and **stable**, optimized for **nearly-sorted arrays**.

---

## 2. Theoretical Complexity Analysis
| Case | Comparisons | Moves | Time Complexity | Space Complexity |
|------|--------------|-------|----------------|------------------|
| Best (already sorted) | Θ(n) | Θ(1) | **Θ(n)** | O(1) |
| Average (random input) | ~n²/4 | ~n²/4 | **Θ(n²)** | O(1) |
| Worst (reverse-sorted) | ~n²/2 | ~n²/2 | **O(n²)** | O(1) |

**Mathematical derivation:**
For each iteration *i*, at most *i-1* comparisons and shifts occur:  
`T(n) = Σ(i-1) = n(n-1)/2 = Θ(n²)`.

The binary-search optimization reduces comparisons to *O(n log n)*  
but total moves remain *Θ(n²)*, keeping the same asymptotic bound.

---

## 3. Implementation Details
Project uses a modular structure with:
- `algorithms/InsertionSortOptimized.j
