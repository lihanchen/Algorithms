package BinarySearchTree;

public class BinarySearchTreee<Key extends Comparable<Key>, Value>{
	
		Node root;
        public class Node{
                public  Key element;
                public  Value val;
                public  Node leftchild,rightchild;
                public  int size;
                public Node(Key element, Value val, int size){
                        this.element=element; this.val=val; this.size=size;
                }
        }
        public Node insert(Node x, Key element, Value val){
                if(x==null)
                        return  new Node(element,val,0);
                int c=element.compareTo(x.element);
                if(c==0)
                        x.val=val;
                else if(c>0)
                        x.rightchild = insert(x.rightchild,element,val);
                else if(c<0)
                        x.leftchild = insert(x.leftchild,element,val);
                x.size=size(x);
                return x;
        }
        
        public int size(Node x){
                int n=0;
                if(x==null)
                        return -1;
                else
                        if(x.leftchild!=null)
                                n += 1+ size(x.leftchild);
                        if(x.rightchild!=null)
                                n += 1+ size(x.rightchild);
                return n;
        }
  

        public int numLess(Node x, Key v){
                if(x==null)
                        return 0;
                int cmp=x.element.compareTo(v);
                if(cmp==0)
                		if(x.leftchild!=null)
                			return  x.leftchild.size+1;
                		else
                			return 0;
                else if(cmp>0)
                        return  numLess(x.leftchild,v);
                else if(cmp<0)
                	if(x.leftchild!=null)
                		return  x.leftchild.size+2+numLess(x.rightchild,v);
            		else
            			return numLess(x.rightchild,v)+1;
                       
                return -1;
        }

        public Key identify(Node x, int k){
        	if(x.leftchild!=null)
        		if(x.leftchild.size==k-2)
        			return x.element;
        		else if(x.leftchild.size<k-2)
        			return identify(x.rightchild,k-x.leftchild.size-2);
        		else 
        			return identify(x.leftchild,k);
        	else
        		if(k==1)
        			return x.element;
        		else
        			return identify(x.rightchild,k-1);
        }
        
    	static int n=0;
    	public void printout(Node x){

    		if(x!=null){
    			for(int i=0;i<n;i++)
    				System.out.print("   ");
    			n++; 
    			System.out.print(x.element);
    			System.out.print(x.size);
    			System.out.println();
    			if(x.leftchild!=null){
    				printout(x.leftchild);
    			}else{
    				for(int i=0;i<n;i++)
    					System.out.print("   ");
    				System.out.print("empty left");
    			}
    			System.out.println();
    			if(x.rightchild!=null){
    				printout(x.rightchild);
    			}else{
    				for(int i=0;i<n;i++)
    					System.out.print("   ");
    				System.out.print("empty right");
    			}
    			n--;
    		}

    	}
        
        public static void main(String[] args){
        	int num=0;
        	BinarySearchTreee<Character,Integer> b=new BinarySearchTreee<Character,Integer>();
        	String s="gfdsaqwertyuiop";
        	b.root=null;
        	while(num<s.length()){
        		b.root=b.insert(b.root, s.charAt(num), 0);
        		num++;
        	}
        	b.printout(b.root);
        
        	num=b.numLess(b.root,'z');
        	System.out.println(num);
        	
        	char result=b.identify(b.root,6);
        	System.out.println(result);
        	
        }
}

