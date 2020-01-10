# Algorithms

## Objectives: 

Implementation of various Algorithms in Java. 

## Tree Traversal Algorithms:

These are search algorithms used in traversing tree-type structures.

* [Breath first][1.1]: Starting at a specific node, explore all the leaf nodes at the present depth prior to moving on to the vertices at the next depth level.
* [Depth first][1.2]: Starting at a specific node, explore as far (deep) as possible along each branch before backtracking.
* [Iterative deepening depth first][1.3]: A depth-limited version of *Depth First* that runs repeatedly with increasing depth limits until the goal is found. *Breath First* is performed at each level. 
* [A-Star][1.4]: Find shortest path from a specified starting point to a specified destination, by finding a path that minimizes f(x) = g(x) + h(x)

[1.1]: https://en.wikipedia.org/wiki/Breadth-first_search
[1.2]: https://en.wikipedia.org/wiki/Depth-first_search
[1.3]: https://en.wikipedia.org/wiki/Iterative_deepening_depth-first_search
[1.4]: https://en.wikipedia.org/wiki/A*_search_algorithm

## Search Algorithms:

These are search algorithms that are used in searching liner-type functions. 

* [Bruce force][2.1] (Iterative): Systematically enumerates through all specified intervals on a range. For example, to find the maximum result of a function within a given start and end boundary for x, given a specific interval, each point is evaluated (this will find the **global** optimum).
* [Stochastic][2.2] (Metaheuristic): Similar to *Brute Force*, but instead it iterating through all intervals on the range, random points in the range are evaluated for a given number of iterations. The higher the number of iterations, the higher the probability of finding either the **local** or **global** optimum).
* [Hill climbing][2.3] (Iterative): Similar to *Brute Force*, but instead of going through all intervals on the range, it stops once the **local** optimum is found. This may not however be the **global** optimum.
* [Tabu][2.4] (Metaheuristic): Evaluates all adjacent options and choose the best one. Once an option has been chosen it's put into the front of the "Tabu" list (FIFO) for a period to prevent it from being re-selected. Unlike hill climbing search, worsening options can be accepted if no improving options is available (provided the option is not in the tabu list). 
* [Simulated annealing][2.5] (Metaheuristic): Similar to *Stochastic* in that it also uses random intervals on the range. Though unlike *Stochastic*, a worse result can be accepted depending on some probability based on a reducing "temperature".

Note: Metaheuristics sample a set of solutions which is too large to be completely sampled. Metaheuristics do not guarantee that a globally optimal solution, but do supply a sufficiently good solution. 

[2.1]: https://en.wikipedia.org/wiki/Brute-force_search
[2.2]: https://en.wikipedia.org/wiki/Stochastic_optimization
[2.3]: https://en.wikipedia.org/wiki/Hill_climbing
[2.4]: https://en.wikipedia.org/wiki/Tabu_search
[2.5]: https://en.wikipedia.org/wiki/Simulated_annealing

## Genetic Algorithms

A simple implementation of a genetic algorithm, to match a pre-defined sequence of values, using a random population using cross-overs and mutations of individuals within that population.

Essentially the steps followed are as followed:

1) Define a target solution, for example a sequence of 5 numbers ... {1, 2, 3, 4, 5}. 
2) Generate a population of random individuals, each with a random sequence of numbers (if the target sequence has 5 numbers, then the individuals random sequence will have 5 numbers). 
3) Establish the fitness of each individual. This is calculated by establishing how many values match between the individuals sequence and the target sequence (in the same position).
4) Create a new population by running two "tournaments" between a random subset of the original population and "breed" the winners of the two tournaments, adding the offspring to the new population (based on cross over rate). This is repeated until the new population reaches its capacity.
5) Randomly mutate individuals of the new population (based on mutation rate).
6) Repeat from 3, until maximum fitness is reached. 

## Problems:

These are problems which have been implemented using some of these algorithms

* [Traveling Salesman][3.1]

[3.1]: https://en.wikipedia.org/wiki/Travelling_salesman_problem