import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	Node parent;
	Node(int d){
		data = d;
		left = null;
		right = null;
		parent = null;
	}
	Node(int d, Node p){
		data = d;
		left = null;
		right = null;
		parent = p;
	}
	public String toString(){
		return "("+data+")";
	}
}

class Tree{
	Node root;
	Tree(){
		root = null;
	}
	public void bfs(){
		if(root == null){
			return;
		}
		Queue<Node> bfsQ = new LinkedList<>();
		bfsQ.offer(root);
		while(!bfsQ.isEmpty()){
			Node curr = bfsQ.poll();
			System.out.println(curr.data);
			if(curr.left != null){
				bfsQ.offer(curr.left);
			}
			if(curr.right != null){
				bfsQ.offer(curr.right);
			}
		}
	}

	public boolean checkIfNodeInSubTree(Node r, Node p){
		if(r == null || p == null){
			return false;
		}
		if(r == p){
			return true;
		}
		return checkIfNodeInSubTree(r.left,p) || checkIfNodeInSubTree(r.right,p);
	}

	public Node commonAncestor(Node r, Node p, Node q){
		if(r == null || !checkIfNodeInSubTree(r,p) || !checkIfNodeInSubTree(r,q)){
			return null;
		}
		boolean isPOnLeft = checkIfNodeInSubTree(r.left,p);
		boolean isQOnLeft = checkIfNodeInSubTree(r.left,q);
		if((!isPOnLeft && isQOnLeft) || (isPOnLeft && !isQOnLeft)){
			return r;
		}
		if(isPOnLeft){
			return commonAncestor(r.left,p,q);
		}
		return commonAncestor(r.right,p,q);
	}

	public Node commonAncestor(Node p, Node q){
		return commonAncestor(root,p,q);
	}

	public boolean isBST(){
		return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private boolean isBST(Node r, int min, int max){
		if(r == null){
			return true;
		}
		if(r.data < min || r.data > max){
			return false;
		}
		return isBST(r.left,min,r.data-1) && isBST(r.right,r.data+1,max);
	}

	public void dfs(Node r){
		if(r == null){
			return;
		}
		System.out.println(r);
		dfs(r.left);
		dfs(r.right);
	}

	public void dfs(){
		dfs(root);
	}

	public void paths(Node r, int sum, String s){
		
		if(r == null && sum != 0){
			return;
		}
		if(sum < 0 || r == null){
			return;
		}
		sum = sum - r.data;
		s = s + r + "->";

		if(sum == 0){
			System.out.println(s);
			return;
		}

		if(r.left != null){
			paths(r.left,sum,s);
		}
		
		if(r.right != null){
			paths(r.right,sum,s);
		}
	}

	public void paths(int sum){
		paths(root,sum,"");
	}


	public ArrayList<LinkedList<Integer>> getLevels(){
		if(root == null){
			return null;
		}
		ArrayList<LinkedList<Integer>> levels = new ArrayList<>();
		LinkedList<Integer> currList = new LinkedList<>();
		Queue<Node> bfsQ = new LinkedList<>();
		Queue<Node> bfsNextQ = new LinkedList<>();
		bfsQ.offer(root);
		while(!bfsQ.isEmpty()){
			Node currNode = bfsQ.poll();
			currList.add(currNode.data);
			if(currNode.left != null){
				bfsNextQ.offer(currNode.left);
			}
			if(currNode.right != null){
				bfsNextQ.offer(currNode.right);
			}
			if(bfsQ.isEmpty()){
				levels.add(currList);
				currList = new LinkedList<>();
				while(!bfsNextQ.isEmpty()){
					bfsQ.offer(bfsNextQ.poll());
				}
			}
		}
		return levels;
	}

	public Node inOrderNext(Node n){
		if(root == null || n == null){
			return null;
		}
		if(n.right != null){
			return findLowest(n.right);
		}
		Node curr = n;
		Node parent = curr.parent;
		while(parent != null && curr != parent.left){
			curr = parent;
			parent = parent.parent;
		}
		return parent;
	}

	public Node findLowest(Node n){
		if(n == null){
			return null;
		}
		while(n.left != null){
			n = n.left;
		}
		return n;
	}
}

class BFS{
	public static void main(String[] args){
		Tree t = new Tree();
		t.root = new Node(16,null);	

		t.root.left = new Node(3,t.root);

		t.root.left.left = new Node(2,t.root.left);

		t.root.left.left.left = new Node(3,t.root.left.left);

		t.root.left.right = new Node(5,t.root.left);

		t.root.left.right.right = new Node(10,t.root.left.right);

		t.root.right = new Node(18,t.root);

		t.root.right.left = new Node(17,t.root.right);

		t.root.right.right = new Node(20,t.root.right);

		t.root.right.right.left = new Node(19,t.root.right.right);

		//System.out.println(t.inOrderNext(t.root.left.left.left));

		//t.dfs();
		t.paths(24);
	}
}