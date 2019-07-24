package tree;

import java.util.LinkedList;
import java.util.Queue;

public class HalfNode {

	static class Node{
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	public static int countHalfNode(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int count = 0;
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int child = 0;
			if(temp.left!=null) q.add(temp.left);
			else child++;
			if(temp.right!=null) q.add(temp.right);
			else child++;
			
			if(child==1) count++;
			
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(2);
		root.left = new Node(7);
		root.right = new Node(5);
		root.left.right = new Node(6);
		root.right.right = new Node(9);
		root.left.right.left = new Node(1);
		root.left.right.right = new Node(11);
		root.right.right.left = new Node(4);
		
		System.out.println(countHalfNode(root));
	}

}
