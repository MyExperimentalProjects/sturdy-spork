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

	public static void main(String[] args){
		Node tree1 = new Node(11);
		tree1.left = new Node(2); 
		tree1.right = new Node(3); 
		tree1.left.left = new Node(4); 
		tree1.left.right = new Node(5); 

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
	}
}
