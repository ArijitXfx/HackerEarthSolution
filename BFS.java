package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static class Graph{
		int v;
		LinkedList<Integer>[] adj;
		
		@SuppressWarnings("unchecked")
		public Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for(int i=0;i<v;i++)
				adj[i] = new LinkedList<Integer>();
		}
	}
	
	public static void addEdge(Graph g, int src, int dest) {
		g.adj[src].add(dest);
		g.adj[dest].add(src);
	}
	
	public static void breathFirstSearch(Graph g) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[g.v];
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.println(temp);
			for(int i:g.adj[temp]) {
				if(!visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(7);
		addEdge(g, 1, 2);
		addEdge(g, 1, 3);
		addEdge(g, 2, 4);
		addEdge(g, 2, 5);
		addEdge(g, 3, 5);
		addEdge(g, 4, 5);
		addEdge(g, 4, 6);
		addEdge(g, 5, 6);
		
		breathFirstSearch(g);
	}

}
