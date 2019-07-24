package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class DirectionOfUndirectedGraph {
	static int[] arr;
	public static int[] topologicalSort(ArrayList<ArrayList<Integer>> g, int N) {
		
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> res = new Stack<Integer>();
		boolean[] visited = new boolean[N];
		
		for(int j=0;j<N;j++) {
			if(!visited[j]) {
				s.add(j);
				visited[j] = true;
				while(!s.isEmpty()) {
					int temp = s.peek();
					int count = 0;
					for(int i:g.get(temp)) {
						if(!visited[i]) {
							s.add(i);
							visited[i] = true;
							break;
						}
						count++;
					}
					if(count==g.get(temp).size())
						res.add(s.pop());
				}
			}
		}
		arr = new int[N];
		int index = N;
		while(!res.isEmpty())
			arr[--index] = res.pop();
		return arr;
	}
	
	public static void setDirection(ArrayList<ArrayList<Integer>> g, int a, int b) {
		int a_i = -1;
		int b_i = -1;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==a) a_i = i;
			if(arr[i]==b) b_i = i;
		}
		if(a_i<b_i) {
			System.out.println(a+"->"+b);
			g.get(a).add(b);
		}
		else {
			System.out.println(b+"->"+a);
			g.get(b).add(a);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<10;i++)
			list.add(i,new ArrayList<Integer>());
		ArrayList<Integer> l0 = new ArrayList<Integer>();
		l0.add(1);
		l0.add(5);
		list.get(0).addAll(l0);
//		ArrayList<Integer> l1 = new ArrayList<Integer>();
//		l1.add(7);
//		list.get(1).addAll(l1);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(2);
		l3.add(4);
		l3.add(8);
		list.get(3).addAll(l3);
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l4.add(8);
		list.get(4).addAll(l4);
		ArrayList<Integer> l6 = new ArrayList<Integer>();
		l6.add(0);
		l6.add(1);
		l6.add(2);
		list.get(6).addAll(l6);
//		ArrayList<Integer> l7 = new ArrayList<Integer>();
//		l7.add(1);
//		list.get(7).addAll(l7);
		ArrayList<Integer> l8 = new ArrayList<Integer>();
		l8.add(2);
		list.get(8).addAll(l8);
		ArrayList<Integer> l9 = new ArrayList<Integer>();
		l9.add(4);
		list.get(9).addAll(l9);
		System.out.println(Arrays.toString(topologicalSort(list, 10)));
		setDirection(list,7,1);
		System.out.println(Arrays.toString(topologicalSort(list, 10)));
	}
}
