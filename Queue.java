import java.util.Scanner;

class Queue{

	private class Node{

		int data;
		Node next;

		Node(int data){

			this.data=data;
			this.next=null;
		}
	}

	Node front = null;
	Node rear = null;

	void add(int item){

		Node n = new Node(item);
		if(rear!=null){
			rear.next=n;	
		}
		rear=n;

		if(front==null)
			front=rear;

		System.out.println("Item added: "+item);
	}

	void remove(){

		if(front==null)
		{
			System.out.println("Queue Empty");
			return;
		}

		int del = front.data;
		front = front.next;
		if(front==null)
			rear=front;

		System.out.println("Item removed:"+del);
	}

	int peek(){

		if(front==null){
			System.out.println("Queue Empty");
			return 0;
		}
			return front.data;
	}

	boolean isEmpty(){
		return front==null;
	}

	void display(){
		if(front==null){
			System.out.println("Empty Queue");
			return;
		}

		Node current=front;
		while(current!=null){
			System.out.println(current.data);
			current=current.next;
		}
	}

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		Queue obj = new Queue();
		obj.front = null;
		obj.rear = null;

		while(true){

			System.out.println(" 1.Insert\n 2.Remove\n 3.Peek\n 4.Display\n 5.isEmpty ?\n 6.Exit\n");
			int ch=sc.nextInt(); 
			int item;

			switch(ch){

				System.out.println("------------------------------------------------------------");
				case 1: System.out.println("Enter item to be added \n"); 
						item=sc.nextInt();
						obj.add(item); break;
				case 2: obj.remove(); break;
				case 3: System.out.println("Element on top = " + obj.peek()); break;
				case 4: obj.display(); break;
				case 5: System.out.println(obj.isEmpty()); break;
				case 6: System.exit(0);
			}
		}
	}
}