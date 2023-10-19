package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFStraversal {

  // Breadth
  // Level Wise traversal

  //             1                                level 0
  //         /       `
  //     2               6                        2 and 6 are at disatnce 1, level 1
  // /     `         /     `
  // 3       4       7       8
  //          `     /
  //             5

  // starting Node is 1 at level 0,
  // if starting node is 1=> then BSF 1 2 3 3 4 7 8 5
  // if starting node is 6=> then BSF 6 1 7 8 2 5 3 4

  //Initial configuration
  // Queue Ds and will store the first node
  // Create a visited array of size+1 ie if 10 nodes then array(0->10)
  // starting node mark has 1

  // taking out till the queue becomes empty
  //  add the elementd's neighbour list into the queue (if not visited)
  // and mark the visited array on these element as visited


// You've kept a visited array, and by looking it up, you decide whether to push a node into the queue or not. 
// Once visited, you don't push it again. So, how many nodes get pushed into the queue: (of course) V nodes. 
// And it's complexity is O(V).

// Now, each time, you take out a node from queue and visit all of its neighboring nodes.
// Now, following this way, for all of V nodes, how many node you'll come across. 
//Well, it's the number of edges if the graph is unidirectional, or, 2 * number of edges if the graph is bidirectional. 
//So, the complexity would be O(E) for unidirectional and O(2 * E) for bidirectional.

// So, the ultimate(i.e. total) complexity would be O(V + E) or O(V + 2 * E) or generally, we may say O(v + E).

// Share


  public ArrayList<Integer> bfs(
    int V,
    ArrayList<ArrayList<Integer>> adjacencyList,
    int startingIndex
  ) {
    boolean[] visited = new boolean[V];
    ArrayList<Integer> ans = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    visited[startingIndex] = true;
    queue.add(startingIndex);

    while (!queue.isEmpty()) {
      int currentVertex = queue.poll();
      ans.add(currentVertex);

      for (Integer ii : adjacencyList.get(currentVertex)) {
        if (!visited[ii]) {
          visited[ii] = true;
          queue.add(ii);
        }
      }
    }

    return ans;
  }
  // space 0(3N)
  // Time O(N) + O(2E)

}
