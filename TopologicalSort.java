package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort {
	
	static int[] topoSort(ArrayList<ArrayList<Integer>> list, int N)
    {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[N];
		Stack<Integer> res = new Stack<Integer>();
		for(int v=0;v<N;v++) {
			if(!visited[v]) {
				s.add(v);
				visited[v] = true;
				while(!s.isEmpty()) {
					int temp = s.peek();
					int count = 0;
					for(int i:list.get(temp)) {
						if(!visited[i]) {
							s.add(i);
							visited[i] = true;
							break;
						}
						count++;
					}
					if(count==list.get(temp).size()) {
						res.add(s.pop());
					}
				}
			}
		}
//		res.forEach(i->System.out.print(i+" "));
//		System.out.println();
		int count = N;
		int[] arr = new int[N];
		while(!res.isEmpty()) {
			arr[--count] = res.pop();
		}
		return arr;
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
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(7);
		list.get(1).addAll(l1);
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
		ArrayList<Integer> l8 = new ArrayList<Integer>();
		l8.add(2);
		list.get(8).addAll(l8);
		ArrayList<Integer> l9 = new ArrayList<Integer>();
		l9.add(4);
		list.get(9).addAll(l9);
		System.out.println(Arrays.toString(topoSort(list, 10)));
	}

}
