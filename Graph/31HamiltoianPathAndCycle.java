// 1. You are given a graph and a src vertex.
// 2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."

// Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
// Note -> Print in lexicographically increasing order.

//https://www.pepcoding.com/resources/online-java-foundation/graphs/hamiltonian-official/ojquestion

psvm(){

	hamintonianPathCycle(2,2,0,0,vis,"");
}
public static int findEdge(int u, int v) {
	for (int i = 0; i < graph[u].size(); i++) {
		Edge e = graph[u].get(i);
		if (e.v == v)
			return i;
	}

	return -1;
}

// HOW MANY PATHA ND CYCLE ARE PRESENT
public static int hamintonianPathCycle(int src, int osrc, int vtxCount, int wt, boolean[] vis, string ans)
{   if(vtxCount==N-1){
       int isEdgePresent=findEdge(src,osrc)
	   if(isEdgePresent){

		syso("It's a cycle "+ans)
	   }else{
	
		syso("It's a path "+ans)
	   }
	   return 1;
}   int totalPaths = 0;
	vis[src] = true;
	for(Edge e: graph[src]){
		if(!vis[e.v]){
			totalPaths += hamintonianPath(e.v,osrc,vtxCount+1,vis,ans + src + " ");
		}
	}

	vis[src] = false;
	return totalPaths;
}


void hamintonianPathCycle(int src, int osrc, int cnt, int wt, vector<bool> &vis, string ans)
{
    if (cnt == graph.size() - 1)
    {
        cout << ans + to_string(src); // path print
        for (Edge *e : graph[src])
        {
			// agr mera koi bedge original src k equal hai toh its a cycle
            if (e->v == osrc)
            {
                cout << " -> Cycle";
            }
        }
        cout << endl;
        return;
    }

    //mark.
    vis[src] = true;
    for (Edge *e : graph[src])
    {
        int nbr = e->v;
        int w = e->w;
        if (!vis[nbr])
        {
            hamintonianPathCycle(nbr, osrc, cnt + 1, wt + w, vis, ans + to_string(src));
        }
    }

	//unmark.
    vis[src] = false;
}