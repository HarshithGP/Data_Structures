/* Basic Stack Implementation */

/*
class Stack{
	
	static int stack[]=new int[10];
	static int top=-1;

	static void push(int item){

		if(top<10){
			stack[++top]=item;
			System.out.println("Pushed:"+item);
		}
		else
			System.out.println("Stack Limit reached");
	}

	static void pop(){
		int x;
		if(top==-1)
			System.out.println("Stack Underflow");
		else{
			x=stack[top--];
			System.out.println("Popped:"+x);
		}
	}

	static void peek(){

		if(top==-1)
			System.out.println("Stack Empty");
		else
			System.out.println("Top Element: "+stack[top]);
	}

	static void isEmpty(){

		 if(top == -1)
		 	System.out.println("Empty");
		 else 
		 	System.out.println("Not empty");
	}

	static void display(){

		int i;
		for(i=top;i>=0;i--)
			System.out.println(stack[i]+" ");

		System.out.println("");
	}

	public static void main(String args[]){

		push(10);push(20);push(30);push(40);

		display();

		pop();
		display();
		peek();
		isEmpty();
		pop();pop();pop();
		isEmpty();
	}
}

*/


import java.io.*;
import java.util.Scanner;
class Stack {

	private class Node{

		int data;
		Node below;
		Node(int data){
			this.data=data;
			this.below=null;
		}
	}

	private Node top;

	int pop(){

		if(top==null)
		{
			System.out.println("Stack Underflow");
				return 0;
		}

		int item = top.data;
		top=top.below;
		System.out.println("Popped Item:"+item);
		return item;
	}

	void push(int item){

		Node n = new Node(item);
		n.below=top;
		top=n;
		System.out.println("Pushed:"+item);
	}

	int peek(){

		if(top==null){
			System.out.println("Stack Empty ");
			return 0;
		}
			return top.data;
	}

	boolean isEmpty(){
		return top==null;
	}

	void display(){
		if(top==null){
			System.out.println("Empty Stack");
			return;
		}

		System.out.println("Elements of Stack :");
		Node current=top;
		while(current!=null){
			System.out.println(current.data);
			current=current.below;
		}
		
	}

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		Stack obj = new Stack();
		obj.top = null;

		while(true){

			System.out.println(" ---------------------------------------------------------------------------------");
			System.out.println(" 1.Push\n 2.Pop\n 3.Peek\n 4.Display\n 5.isEmpty ?\n 6.Exit\n");
			int ch=sc.nextInt(); 
			int item;

			switch(ch){

				case 1: System.out.println("Enter item to be added \n"); 
						item=sc.nextInt();
						obj.push(item); break;
				case 2: obj.pop(); break;
				case 3: System.out.println("Element on top = " + obj.peek()); break;
				case 4: obj.display(); break;
				case 5: System.out.println(obj.isEmpty()); break;
				case 6: System.exit(0);
			}
		}
	}
}