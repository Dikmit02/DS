https://leetcode.ca/2017-04-03-490-The-Maze/

// There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

// Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.


// Time complexity :O(mn). Complete traversal of maze will be done in the worst case. Here, m and n refers to the number of rows and coloumns of the maze.
// Space complexity :O(mn). visited array of size m*n is used.


public boolean hasPath(int[][] maze, int[] start, int[] destination) {

	int n = maze.length, m = maze[0].length, sr = start[0], sc = start[1], er = destination[0], ec = destination[1];
	LinkedList<Integer> que = new LinkedList<>();
	boolean[][] vis = new boolean[n][m];
	int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	que.add(sr * m + sc);
	vis[sr][sc] = true;

	while (que.size() != 0) {
		int size = que.size();
		while (size-- > 0) {
			int idx = que.removeFirst(), i = idx / m, j = idx % m;
			for (int[] d : dir) {

				int r = i, c = j;

				// continue without hiiting
				while (r >= 0 && c >= 0 && r < n && c < m && maze[r][c] == 0) {
					r += d[0];
					c += d[1];
				}

				// out of scope due to continue withoure hiiting 
				// therefore -1 
				r -= d[0];
				c -= d[1];
				if (r == er && c == ec)
					return true;

				if (vis[r][c])
					continue;

				vis[r][c] = true;
				que.addLast(r * m + c);
				
			}

		}
	}

	return false;
}
