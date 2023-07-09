package Graph;

class ConnectedComponents {
  // Graph Traversal
  // In the upcoming topics, we’ll be learning about a lot of algorithms.
  // Now, assume a traversal algorithm. Any traversal algorithm will always use a visited array.
  //For the same example, we will create an array of size 11 (n+1) starting with the zeroth index.
  //Initialize this visited array to zero, indicating that all the nodes are unvisited.
  //Then follow the following algorithm. If a node is not visited, then call the traversal algorithm.

  //   for(i:1 t 10){
  // 	if(!visited[i])
  // 		traveral(i)

  // 	}

  //Why can’t we just call traversal(1)?

  //We cannot just call traversal(node) because a graph can have multiple components and traversal algorithms are designed in such a
  //way that they will traverse the entire connected portion of the graph. For example, traversal(1) will traverse only the
  //connected nodes, i.e., nodes 2, 3, and 4, but not the connected components.

}
