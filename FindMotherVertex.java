package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FindMotherVertex {

	public static void dfs(ArrayList<ArrayList<Integer>> g, int N, int start, boolean[] visited) {
		Stack<Integer> s = new Stack<Integer>();
		s.add(start);
		visited[start] = true;
		while(!s.isEmpty()) {
			int temp = s.peek();
			boolean flag = true;
			for(int i:g.get(temp)) {
				if(!visited[i]) {
					s.add(i);
					visited[i] = true;
					flag = false;
				}
			}
			if(flag) s.pop();
		}
	}
	
	public static int findMotherVertex(ArrayList<ArrayList<Integer>> g, int N) {
		boolean[] visited = new boolean[N];
		int motherVertex = -1;
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				dfs(g,N,i,visited);
				motherVertex = i;
			}
		}
		Arrays.fill(visited, false);
		dfs(g,N,motherVertex,visited);
		for(boolean i:visited)
			if(!i) return -1;
		return motherVertex;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<7;i++)
			g.add(i,new ArrayList<Integer>());
		
		g.get(0).addAll(Arrays.asList(1,2));
		g.get(1).addAll(Arrays.asList(3));
		g.get(4).addAll(Arrays.asList(1));
		g.get(5).addAll(Arrays.asList(2,6));
		g.get(6).addAll(Arrays.asList(0,4));
		
		System.out.println(findMotherVertex(g,7));
	}

}
