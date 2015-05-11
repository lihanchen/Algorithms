package RedBlackTree;


public class RedBlackTree<Key> {
	
	public final boolean BLACK=false;
	public final boolean RED=true;
	
	private Node treeRoot=null;
	
	private class Node{
		Key key;
		char value;
		Node left,right;
		int N;
		boolean color;

		public Node(Key key, char value, boolean color){
			this.key=key;
			this.value=value;
			this.color=color;
			this.N=1;
		}
	}

	public boolean isRed(Node x){
		if (x==null) return false;
		return x.color;
	}

	public int size(Node x){
		if(x==null) return 0;
		return 1+ size(x.left)+size(x.right);

	}

	public Node rotateLeft(Node x){
		Node y=x.right;
		x.right=y.left;
		y.left=x;
		y.color=x.color;
		x.color=RED;
		y.N=x.N;
		x.N=1+size(x.left)+size(x.right);
		return y;
	}

	public Node rotateRight(Node x){
		Node y=x.left;
		x.left=y.right;
		y.right=x;
		y.color=x.color;
		x.color=RED;
		y.N=x.N;
		x.N=1+size(x.left)+size(x.right);
		return y;
	}

	public void flipColors(Node x){
		x.left.color=BLACK;
		x.right.color=BLACK;
		x.color=RED;
	}

	public void insert(Key key,char value){
		if (treeRoot==null){
			treeRoot=new Node(key,value,BLACK);
		}else{
			treeRoot=insert(treeRoot,key,value);
		}
	}

	private Node insert(Node x,Key key,char value){
		if (x==null) return new Node(key,value,RED);

		if (x.value>value) {
			x.left=insert(x.left,key,value);
		}else if (x.value<value){
			x.right=insert(x.right,key,value);
		}else x.value=value;

		if (isRed(x.right) && !isRed(x.left)) x=rotateLeft(x);
		if (isRed(x.left) && isRed(x.left.left)) x=rotateRight(x);
		if (isRed(x.left) && isRed(x.right)) flipColors(x);

		x.N=size(x);
		return x;
	}

	public int n=0;
	public void printout(Node x){
		if(x!=null){
			for(int i=0;i<n;i++)
				System.out.print("   ");
			n++; 
			System.out.print(x.value);
			System.out.print(x.N);
			System.out.print(x.color);
			System.out.println();
			if(x.left!=null){
				printout(x.left);
			}else{
				for(int i=0;i<n;i++)
					System.out.print("   ");
				System.out.print("empty left");
			}
			System.out.println();
			if(x.right!=null){
				printout(x.right);
			}else{
				for(int i=0;i<n;i++)
					System.out.print("   ");
				System.out.print("empty right");
			}
			n--;
		}
		if (n==0) System.out.print("\n\n");
	}
	
	public static void main(String []args){
		RedBlackTree<Integer> tree=new RedBlackTree<Integer>();
		tree.insert(0,'S');
		tree.printout(tree.treeRoot);
		tree.insert(1,'E');
		tree.printout(tree.treeRoot);
		tree.insert(2,'A');
		tree.printout(tree.treeRoot);
		tree.insert(3,'R');
		tree.printout(tree.treeRoot);
		tree.insert(4,'C');
		tree.printout(tree.treeRoot);
		tree.insert(5,'H');
		tree.printout(tree.treeRoot);
		tree.insert(6,'X');
		tree.printout(tree.treeRoot);
		tree.insert(7,'M');
		tree.printout(tree.treeRoot);
		tree.insert(8,'P');
		tree.printout(tree.treeRoot);
		tree.insert(9,'L');
		tree.printout(tree.treeRoot);
	}
}
