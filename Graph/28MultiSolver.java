// https://www.pepcoding.com/resources/online-java-foundation/graphs/mutilsovler-graph-official/ojquestion

// 1. You are given a graph, a src vertex and a destination vertex.
// 2. You are give a number named "criteria" and a number "k".
// 3. You are required to find and print the values of 
// 3.1 Smallest path and it's weight separated by an "@"
// 3.2 Largest path and it's weight separated by an "@"
// 3.3 Just Larger path (than criteria in terms of weight) and it's weight separated by an "@"
// 3.4 Just smaller path (than criteria in terms of weight) and it's weight separated by an "@"
// 3.5 Kth largest path and it's weight separated by an "@"

public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
	if (src == dest) {
	   if(wsf < spathwt){
		  spathwt = wsf;
		  spath = psf;
	   }

	   if(wsf > lpathwt){
		  lpathwt = wsf;
		  lpath = psf;
	   }

	   if(wsf < criteria && wsf > fpathwt){
		  fpathwt = wsf;
		  fpath = psf;
	   }

	   if(wsf > criteria && wsf < cpathwt){
		  cpathwt = wsf;
		  cpath = psf;
	   }

	   if(pq.size() <  k){
		  pq.add(new Pair(wsf, psf));
	   } else if(wsf > pq.peek().wsf){
		  pq.remove();
		  pq.add(new Pair(wsf, psf));
	   }
	   return;
	}

	visited[src] = true;
	for (Edge e : graph[src]) {
	   if (!visited[e.nbr]) {
		  multisolver(graph, e.nbr, dest, visited, criteria, k, psf + e.nbr, wsf + e.wt);
	   }
	}
	visited[src] = false;
 }
}