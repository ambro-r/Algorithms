# Algorithms

## Objectives: 

Implementation of various Algorithms in Java. 

## Graph Algorithms:

These are search algorithms used in searching graph-type structures.

* [Breath first search][1]: Starting at a specific node, explore all the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.
* [Depth first search][2]: Starting at a specific node, explore as far (deep) as possible along each branch before backtracking.
* [Iterative deepening depth first search][3]: A depth-limited version of *Depth First* that runs repeatedly with increasing depth limits until the goal is found. *Breath First* is performed at each level. 
* [A-Star Search][4]: Find shortest path from a specified starting point to a specified destination, by finding a path that minimizes f(x) = g(x) + h(x)

[1]: https://en.wikipedia.org/wiki/Breadth-first_search
[2]: https://en.wikipedia.org/wiki/Depth-first_search
[3]: https://en.wikipedia.org/wiki/Iterative_deepening_depth-first_search
[4]: https://en.wikipedia.org/wiki/A*_search_algorithm

## Search Algorithms:

These are search algorithms that are used in searching liner-type functions. 

* [Bruce Force Search][5]: Systematically enumerate through all specified intervals on a range. For example, to find the maximum result of a function within a given start and end boundary for x, given a specific interval, each point is evaluated (this will find the **global** maximum).
* [Stochastic Search][6]: Similar to *Brute Force*, but instead it iterating through all intervals on the range, random points in the range are evaluated for a given number of iterations. 
* [Hill Climbing Search][7]: Similar to *Brute Force*, but instead of going through all intervals on the range, it stops once the **local** maximum is found.
* [Tabu Search][8]: Evaluate all adjacent options and choose the best one. Once an option has been chosen it's put into the front of the "Tabu" list (FIFO) for a period to prevent it from being re-selected. Unlike hill climbing search, worsening options can be accepted if no improving options is available (provided the option is not in the tabu list). 

[5]: https://en.wikipedia.org/wiki/Brute-force_search
[6]: https://en.wikipedia.org/wiki/Stochastic_optimization
[7]: https://en.wikipedia.org/wiki/Hill_climbing
[8]: https://en.wikipedia.org/wiki/Tabu_search