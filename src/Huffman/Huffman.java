package Huffman;

import java.util.*;

public class Huffman {
	public class Node{
		public char c;
		public Node left;
		public Node right;
		public double freq;
		
		public Node(char c, double freq){
			this.c=c;
			this.freq=freq;
			this.left=null;
			this.right=null;
		}
		
		public Node(Node left,Node right){
			this.left=left;
			this.right=right;
			this.c=0;
			this.freq=left.freq+right.freq;
		}
	}
	
	LinkedList<Node> list;
	Node treeRoot;
	
	public Huffman(){
		list=new LinkedList<Node>();
	}
	
	public void add(char c, double freq){
		list.add(new Node(c,freq));
	}
	
	public void createTree(){
		Iterator<Node> nowNode;
		while (list.size()>=2) {
			Node minNode,secondMinNode,temp;
			nowNode=list.iterator();
			minNode=(Node)nowNode.next();
			secondMinNode=(Node)nowNode.next();
			if (minNode.freq>secondMinNode.freq){
				temp=minNode;
				minNode=secondMinNode;
				secondMinNode=temp;
			}
			while(nowNode.hasNext()){
				temp=(Node)nowNode.next();
				if(temp.freq<minNode.freq){
					secondMinNode=minNode;
					minNode=temp;
				}else if(temp.freq<secondMinNode.freq){
					secondMinNode=temp;
				}
			}
			list.add(new Node(minNode,secondMinNode));
			list.remove(minNode);
			list.remove(secondMinNode);
		}
		nowNode=list.iterator();
		if (list.size()==1) treeRoot=(Node)nowNode.next();
		list.clear();
	}
	
	public int n;
	public void printout(Node x){
		if(x!=null){
			for(int i=0;i<n;i++)
				System.out.print("   ");
			n++; 
			System.out.print((x.c==0?'-':x.c)+x.freq);
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

	}
	
	public String decode(String input){
		Node nowNode=treeRoot;
		int pointer=0;
		StringBuffer result=new StringBuffer();
		while (pointer<input.length()){
			if (input.charAt(pointer)=='0'){
				nowNode=nowNode.left;
				if (nowNode.c!=0){
					result.append(nowNode.c);
					nowNode=treeRoot;
				}
			}else{
				nowNode=nowNode.right;
				if (nowNode.c!=0){
					result.append(nowNode.c);
					nowNode=treeRoot;
				}
			}
			pointer++;
		}
		return result.toString();
	}
	
	public static void main(String []ar){
		Huffman h=new Huffman();
		h.add('A', .26);
		h.add('G', .25);
		h.add('H', .14);
		h.add('.', .13);
		h.add(',', .10);
		h.add('?', .07);
		h.add('!', .05);
		h.createTree();
		//h.printout(h.treeRoot);
		System.out.println(h.decode("01111001010111000010111011010110111100001111100011"));
	}

	
	
}
