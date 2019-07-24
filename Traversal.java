package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
	
	static class Node{
		int data;
		Node left;
		Node right;
		int visited;
		
		public Node(int data) {
			this.data = data;
			left = right = null;
			this.visited = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
//		root.left.right.right = new Node(6);
		
//		levelOrderTraversal(root);
//		inOrderTraversal(root);
		reverseLevelOrder(root);
	}

	private static void levelOrderTraversal(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			System.out.println(temp.data);
			if(temp.left!=null) q.add(temp.left);
			if(temp.right!=null) q.add(temp.right);
		}
	}
	
	private static void reverseLevelOrder(Node root) {
		Stack<Node> s = new Stack<Node>();
		Stack<Node> res = new Stack<Node>();
		
		s.add(root);
		while(!s.isEmpty()) {
			Node temp = s.peek();
			if(temp.visited==0) {
				if(temp.left!=null)
					s.add(temp.left);
				temp.visited++;
			}else if(temp.visited==1) {
				if(temp.right!=null)
					s.add(temp.right);
				temp.visited++;
			}else {
				res.add(s.pop());
			}
		}

		for(Node i:res)
			System.out.print(i.data+" ");
	}
	
	private static void inOrderTraversal(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.add(root);
		while(!s.isEmpty()) {
			Node temp = s.peek();
			if(temp.visited==0) {
				if(temp.left!=null) {
					s.add(temp.left);
				}
				temp.visited++;
			}else if(temp.visited==1) {
				System.out.println(temp.data);
				if(temp.right!=null) {
					s.add(temp.right);
				}
				temp.visited++;
			}else {
				s.pop();
			}
		}
	}

}
