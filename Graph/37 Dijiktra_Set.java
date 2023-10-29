// Approach:

// We’ll be using Set in this approach for finding the shortest distances from the source node to every other node through Dijkstra’s Algorithm.

// Initial configuration:

// Source Node: Before starting off with the Algorithm, we need to define a source node from which the shortest distances to every other node would be calculated.
// Set: Define a Set that would contain pairs of the type {dist, node}, where ‘dist’ indicates the currently updated value of the shortest distance from the source to the ‘node’.
// Dist Array: Define a dist array initialized with a large integer number at the start indicating that the nodes are unvisited initially. This array stores the shortest distances to all the nodes from the source node.