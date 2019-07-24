package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {
	
	
	static class Graph{
		int v;
		List<Integer>[] list;
		
		@SuppressWarnings("unchecked")
		public Graph(int v) {
			this.v = v;
			list = new LinkedList[v];
			for(int i=0;i<v;i++)
				list[i] = new LinkedList<Integer>();
		}
	}

	public static void addEdge(Graph g, int src, int dest) {
		g.list[src].add(dest);
		g.list[dest].add(src);
	}
	
	public static void depthFirstSearch(Graph g) {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[g.v];
		s.add(1);
		System.out.println(1);
		visited[1] = true;
		while(!s.isEmpty()) {
			int temp = s.peek();
			boolean flag = true;
			for(int i:g.list[temp]) {
				if(!visited[i]) {
					System.out.println(i);
					s.add(i);
					visited[i] = true;
					flag = false;
					break;
				}
			}
			if(flag) s.pop();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(7);
		addEdge(g, 1, 2);
		addEdge(g, 1, 3);
		addEdge(g, 2, 4);
		addEdge(g, 2, 5);
		addEdge(g, 3, 5);
		addEdge(g, 4, 5);
		addEdge(g, 4, 6);
		addEdge(g, 5, 6);
		
		depthFirstSearch(g);
	}

}
