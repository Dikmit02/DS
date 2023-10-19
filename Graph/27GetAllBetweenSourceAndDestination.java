public static int allPath(int src,int dest,boolean[] vis,int weight,String ans){
	if(src == dest){
		System.out.println(ans + src + " @ " + weight);
		return 1;
	}

	vis[src]=true;
	
	int count = 0;
	for(Edge e: graph[src]){
		if(!vis[e.v])
		  count += allPath(e.v,dest,vis,weight + e.w,ans + src + " ");
	}

	vis[src] = false;

	return count;
}