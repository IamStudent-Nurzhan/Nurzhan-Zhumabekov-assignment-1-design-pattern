 Assignment 1 - Divide and Conquer Algorithms
Learning goals
In this project I implemented several classic divide and conquer algorithms.  
The main goals were to practice safe recursion, analyze recurrences using Master Theorem and Akra–Bazzi, and compare theoretical complexity with real measurements.  
I also collected metrics such as recursion depth, number of comparisons, and running time.  
 Implemented algorithms
1. MergeSort  
   1 Linear merge with reusable buffer  
   2 Small-n cutoff to switch to insertion sort  
   3 Complexity: Θ(n log n)  
2. QuickSort  
   1 Randomized pivot  
   2 Always recurse on the smaller partition, iterate on the larger one  
   3 Complexity: average Θ(n log n), worst case Θ(n^2)  
3. Deterministic Select (Median of Medians)  
   1 Group into blocks of 5, find median of medians as pivot  
   2 Recurse only into the needed side  
   3 Complexity: Θ(n)  
4. Closest Pair of Points (2D)  
   1 Divide by x coordinate, recursive split  
   2 Check strip by y order  
   3 Complexity: Θ(n log n)  
## Architecture notes
Each algorithm was implemented in its own class. A separate Metrics class keeps track of recursion depth, comparisons, and writes. QuickSort was modified to recurse only on the smaller partition, which bounds the recursion depth to O(log n).  
Recurrence analysis
1 MergeSort: T(n) = 2T(n/2) + Θ(n) → Θ(n log n)  
2 QuickSort: T(n) = T(k) + T(n-k-1) + Θ(n) → Θ(n log n) on average  
3 Select: T(n) = T(n/5) + T(7n/10) + Θ(n) → Θ(n)  
4 Closest Pair: T(n) = 2T(n/2) + Θ(n) → Θ(n log n)  
 Measurements
I measured time vs input size and recursion depth.  
1 MergeSort and QuickSort followed the expected n log n growth.  
2 QuickSort depth stayed close to 2*log2(n) as predicted.  
3 Select was linear but slower in practice due to large constants.  
4 Closest Pair matched n log n and was much faster than the quadratic baseline for n ≤ 2000.  
 Summary
The experiments confirmed the theoretical results. Small mismatches were caused by constant factors, cache effects, and the Java garbage collector. MergeSort was very stable, QuickSort was usually faster in practice, Select worked correctly but was slower than expected, and Closest Pair showed the expected asymptotic improvement.  
 GitHub workflow
The work was organized with feature branches: mergesort, quicksort, select, closest, metrics, util, docs, fix, and bench. The main branch contains only stable releases (v0.1, v1.0).  
 Testing
1 Sorting was tested on random and adversarial arrays  
2 QuickSort recursion depth was verified to be bounded  
3 Select was compared with Arrays.sort across 100 random trials  
4 Closest Pair was validated against the quadratic algorithm on small inputs  
