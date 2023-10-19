https://www.pepcoding.com/resources/online-java-foundation/graphs/has-path-official/ojquestion

// 1. You are given a graph, a src vertex and a destination vertex.
// 2. You are required to find if a path exists between src and dest. If it does, print true 
//      otherwise print false.


compexlity O(E)
static class Edge {
	int src;
	int nbr; //neighbour
	int wt;

	Edge(int src, int nbr, int wt) {
	   this.src = src;
	   this.nbr = nbr;
	   this.wt = wt;
	}
 }


public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited)
{
	// mere se mere tak ka path
	if(src==dest) return true;
	visited[src]=true;

	for (Edge e : graph[src]) {

		if(!!visited[e.nbr]){
			boolean nbrHasPath = hasPath(graph, e.nbr, dest, visited);
            if (nbrHasPath) {
               return true;
            }
		}
	}
    return false;
}

bool hasPath(int src, int desti, vector<bool> &vis)
{
    if (src == desti)
        return true;

    bool res = false;
    vis[src] = true; //mark

    for (Edge *e : graph[src])
        if (!vis[e->v])
            res = res || hasPath(e->v, desti, vis);

    return res;
}


bool hasPath(int src, int desti, vector<bool> isVisited, string ans)
{
    if (src == desti)
    {
        cout << ans << " -> ";
        return true;
    }

    isVisited[src] = true;
    for (Edge *e : graph[src])
    {
        if (isVisited[e->v2])
            continue;

        bool res = hasPath(e->v2, desti, isVisited, ans + to_string(src) + " ");
        if (res)
        {
            return true;
        }
    }

    return false;
}
