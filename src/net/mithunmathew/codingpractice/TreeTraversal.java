package net.mithunmathew.codingpractice;
class Node{
	int val;
	Node left, right;
		
	public Node(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}

public class TreeTraversal {
	Node root = null;
	
	public void preorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.val + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void inorder(Node node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
	}
	
	public void postorder(Node node) {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.val + " ");
	}
	
	public void rPreorder(Node node) {
		if(node == null) {
			return;
		}
		rPreorder(node.right);
		rPreorder(node.left);
		System.out.print(node.val + " ");
	}
	
	public void rInorder(Node node) {
		if(node == null) {
			return;
		}
		rInorder(node.right);
		System.out.print(node.val + " ");
		rInorder(node.left);
	}
	
	public void rPostorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.val + " ");
		rPostorder(node.right);
		rPostorder(node.left);
	}
	
	public static void main(String args[]) {
		TreeTraversal tree = new TreeTraversal();
		
		/*
		 * 						1
		 * 					   / \
		 * 					  /   \
		 * 					 2	   3
		 * 					/ \
		 * 				   /   \
		 * 				  4     5	
		 */
		
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        
        System.out.println("Preorder traversal of binary tree is "); 
        tree.preorder(tree.root); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.inorder(tree.root); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.postorder(tree.root);
        
        System.out.println("\nReverse Preorder traversal of binary tree is "); 
        tree.rPreorder(tree.root); 
  
        System.out.println("\nReverse Inorder traversal of binary tree is "); 
        tree.rInorder(tree.root); 
  
        System.out.println("\nReverse Postorder traversal of binary tree is "); 
        tree.rPostorder(tree.root);
	}
}
