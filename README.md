
# Nurzhan-Zhumabekov-assignment-1-design-pattern

Assignment 1 – Algorithms Report
Student: Nurzhan Zhumabekov
Architecture Notes
In my implementation I tried to keep recursion depth under control. In QuickSort I always recurse on the smaller partition and iterate on the bigger one, so the maximum depth is O(log n) in most cases. In MergeSort the recursion depth is log n as well, but each level requires temporary arrays for merging. To avoid too many allocations, I reused a single buffer array instead of creating new ones each time. For Select (Median of Medians), the recursion goes only into one side, which also keeps the depth close to log n. In Closest Pair, the recursion splits points by halves, which again leads to log n depth.
Recurrence Analysis
MergeSort
Recurrence: T(n) = 2T(n/2) + Θ(n).
By the Master theorem (case 2), the result is Θ(n log n).
The merge step requires linear work, and the depth of recursion is log n.
The measurements matched the expected growth.
QuickSort
Recurrence (average): T(n) = T(n/2) + T(n/2) + Θ(n) = 2T(n/2) + Θ(n).
So average complexity is Θ(n log n).
Worst case (bad pivot) is T(n) = T(n-1) + Θ(n) = Θ(n²).
Using random pivots reduces the chance of the worst case.
The depth measured in experiments was around log n, as theory predicts.
Select (Median of Medians)
Recurrence: T(n) = T(n/5) + T(7n/10) + Θ(n).
By Akra–Bazzi, the result is Θ(n).
It only needs to recurse on one side, so it is more efficient for selection than full sorting.
In practice, the constants were higher because of splitting into groups and sorting them.
Closest Pair of Points
Recurrence: T(n) = 2T(n/2) + Θ(n).
By the Master theorem (case 2), this is Θ(n log n).
The merging step requires checking only a strip of O(n), not all pairs.
Experiments showed it grows slower than the quadratic brute force.
Plots and Observations
I measured running time for different n and also recorded recursion depth.
Time vs n showed that MergeSort and QuickSort grew close to n log n. QuickSort was a bit faster because of less copying.
Depth vs n showed a logarithmic growth for both algorithms. QuickSort had slightly smaller depth due to the smaller-first recursion.
Constant factors mattered: MergeSort had higher memory allocations due to arrays, while QuickSort benefited from cache locality. Java garbage collection also sometimes added spikes to timings.
Summary
In general, my results matched the theoretical expectations. MergeSort and QuickSort both behaved as Θ(n log n). QuickSort was faster in practice, but MergeSort was more stable. The Select algorithm showed linear behavior but with bigger constants. The Closest Pair algorithm was clearly faster than brute force and followed the Θ(n log n) curve. The measurements confirmed that theory gives the correct asymptotic picture, but in real code constant factors like memory reuse and recursion strategy make a big difference.
