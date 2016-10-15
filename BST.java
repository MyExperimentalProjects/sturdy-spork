class BST{
	
	private class Node{
		int data;
		Node left,right;
		Node(int d){
			data = d;
			left = null;
			right = null;
		}
	}

	Node root;

	public BST(){
		root = null;
	}

	private Node insert(Node node, int d){
		if(node == null){
			node = new Node(d);
			return node;
		}
		if(node.data == d){
			//throw Exception
		}
		if(d < node.data){
			node.left = insert(node.left,d);
		}else{
			node.right = insert(node.right,d);
		}
		return node;
	}

	private void print(Node node){
		if(node == null){
			return;
		}
		print(node.left);
		System.out.println(node.data);	
		print(node.right);
	}

	private Node delete(Node node, int d){
		if(node == null){
			return node;
		}
		if(d < node.data){
			node.left = delete(node.left,d);
		}
		else if(d > node.data){
			node.right = delete(node.right,d);
		}
		else {
			if(node.left == null && node.right == null){
				return null;
			}
			if(node.left == null){
				return node.right;
			}
			if(node.right == null){
				return node.left;
			}
			Node newNode = findMin(node.right);
			node.data = newNode.data;
			node.right = delete(node.right,newNode.data);
		}
		
		return node;
	}

	private Node findMin(Node node){
		if(node.left == null){
			return node;
		}
		return findMin(node.left);
	}


	public void print(){
		if(root == null){
			System.out.println("Tree is empty");
			return;
		}
		print(root);
	}

	public void insert(int d){
		root = insert(root,d);
	}

	public void delete(int d){
		if(root == null){
			System.out.println("Tree is empty");
			return;
		}
		root = delete(root,d);
	}

	public static void main(String[] args){
		BST b = new BST();
		b.insert(11);
		b.insert(6);
		b.insert(8);
		b.insert(19);
		b.insert(4);
		b.insert(5);
		b.insert(17);
		b.insert(43);
		b.insert(49);
		b.insert(31);
		b.print();
		b.delete(11);
		System.out.println("------------");
		b.print();
	}
}
