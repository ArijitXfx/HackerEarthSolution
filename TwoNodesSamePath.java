package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TwoNodesSamePath {

	public static void bfs(ArrayList<ArrayList<Integer>> graph, int N, int[] intime, int[] outtime) {
		int timer = 0;
		boolean[] visited = new boolean[N];
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(0);
		visited[0] = true;
		intime[0] = timer;
		while(!stack.isEmpty()) {
			timer++;
			int temp = stack.peek();
			
			boolean flag = true;
			for(int i:graph.get(temp)) {
				if(!visited[i]) {
					stack.push(i);
					intime[i] = timer;
					visited[i] = true;
					flag = false;
					break;
				}
			}
			if(flag) {
				outtime[stack.pop()] = timer;
			}
		}
		
	}
	
	public static boolean query(int[] intime, int[] outtime, int src, int dest) {
		return (intime[src]<intime[dest] && outtime[src]>outtime[dest] ||
				intime[src]>intime[dest] && outtime[src]<outtime[dest]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 7;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;i++)
			list.add(i,new ArrayList<Integer>());
		
		LinkedList<Integer> l0 = new LinkedList<Integer>();
		l0.add(1);
		l0.add(2);
		l0.add(3);
		list.get(0).addAll(l0);
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(4);
		list.get(1).addAll(l1);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.add(5);
		list.get(2).addAll(l2);
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		l3.add(6);
		list.get(3).addAll(l3);
		
		int[] intime = new int[N];
		int[] outtime = new int[N];
		bfs(list,N,intime,outtime);
		System.out.println(Arrays.toString(intime));
		System.out.println(Arrays.toString(outtime));
		
		System.out.println(query(intime,outtime,0,4));
		System.out.println(query(intime,outtime,3,6));
		System.out.println(query(intime,outtime,1,2));
		System.out.println(query(intime,outtime,4,6));
	}

}
