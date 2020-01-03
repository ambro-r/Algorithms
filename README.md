# Algorithms

## Objectives: 

Implementation of various Algorithms in Java. 

## Graph Algorithms:

These are search algorithms used in searching graph-type structures.

* [Breath first search (BFS)][1]: Starting at a specific node, explore all the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.
* [Depth first search (DFS)][2]: Starting at a specific node, explore as far (deep) as possible along each branch before backtracking.
* [Iterative deepening depth first search (IDDFS)][3]: A depth-limited version of DFS that runs repeatedly with increasing depth limits until the goal is found. BFS is performed at each level. 
* [A-Star Search][4]: Find shortest path from a specified starting point to a specified destination, by finding a path that minimizes f(x) = g(x) + h(x)

[1]: https://en.wikipedia.org/wiki/Breadth-first_search
[2]: https://en.wikipedia.org/wiki/Depth-first_search
[3]: https://en.wikipedia.org/wiki/Iterative_deepening_depth-first_search
[4]: https://en.wikipedia.org/wiki/A*_search_algorithm

## Search Algorithms:

These are search algorithms that are used in searching liner-type functions. 

* [Bruce Force Search][5]: Systematically enumerate through all intervals on a range. In this case, find the max of a supplied simple function with a start and end x boundary, given a specific interval. 
* [Stochastic Search][6]: Similar to Brute Force Search, but instead it iterating through all intervals random points in the range are evaluated for a given number of iterations. 
* [Hill Climbing Search][7]: Similar to Brute Force Search, but instead of going through all intervals between the start and end, it stops once the **local** maximum is found.

[5]: https://en.wikipedia.org/wiki/Brute-force_search
[6]: https://en.wikipedia.org/wiki/Stochastic_optimization
[7]: https://en.wikipedia.org/wiki/Hill_climbing