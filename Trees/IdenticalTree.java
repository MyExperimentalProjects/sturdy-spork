/* Check if identical */

class Node{
	int label;
	Node left;
	Node right;
	Node(int l){
		label = l;
		left = null;
		right = null;
	}
}


public class IdenticalTree{
	public static boolean isIdentical(Node r1, Node r2){
		if(r1 == null && r2 == null){
			return true;
		}
		if(r1 == null || r2 == null){
			return false;
		}
		return (r1.label == r2.label) && isIdentical(r1.left, r2.left) && isIdentical(r1.right,r2.right);
	}

	public static int size(Node root){
		if(root == null){
			return 0;
		}
		return size(root.left) + size(root.right) + 1;
	}

	public static void inOrder(Node root){
		if(root == null){
			return;
		}
		inOrder(root.left);
		System.out.print(root.label + " --> ");
		inOrder(root.right);
	}

	public static void preOrder(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.label + "--> ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(Node root){
		if(root == null){
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.label + "--> ");
	}

	public static void main(String[] args){
		Node tree1 = new Node(11);
		tree1.left = new Node(2); 
		tree1.right = new Node(3); 
		tree1.left.left = new Node(4); 

		Node tree2 = new Node(1);
		tree2.left = new Node(2); 
		tree2.right = new Node(3); 
		tree2.left.left = new Node(4); 
		tree2.left.right = new Node(5);

		if(isIdentical(tree1,tree2)){
			System.out.println("Trees are identical");
		}else{
			System.out.println("Trees are not identical");
		}
		System.out.println("Tree1 is of size "+ size(tree1));
		System.out.println("Tree2 is of size "+ size(tree2));
		System.out.println("-----");
		inOrder(tree1);
		System.out.println("-----");
		inOrder(tree2);
		System.out.println("-----");
		preOrder(tree1);
		System.out.println("-----");
		preOrder(tree2);
		System.out.println("-----");
		postOrder(tree1);
		System.out.println("-----");
		postOrder(tree2);
		System.out.println("-----");
	}
}