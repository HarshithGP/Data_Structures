class SinglyLinkedList{

	//Node head;
	static class Node{

		int data;
		Node next;
		Node(int d){
			this.data=d;
		}
	}

	static void printList(Node head){

		Node n=head;
		if(head==null){
			System.out.println("List Empty");
			return;
		}
		System.out.println("Linked List");
		while(n!=null){
			System.out.print(n.data+" ");
			n=n.next;
		}
		System.out.println(" ");
	}

	static Node insertFront(Node head, int d){

		Node n = new Node(d);
		n.next=head;
		head=n;
		return head;
	}

	static Node insertAfter(Node head, int val, int d){

		Node n = new Node(d);
		Node i = head;
		while(i.data!=val)
			i=i.next;

		Node temp=i.next;
		i.next=n;
		n.next=temp;

		return head;

	}

	static Node insertEnd(Node head, int d){
		
		if(head==null){
			head=new Node(d);
			head.next=null;
			return head;
		}

		Node n = new Node(d);
		Node i=head;
		while(i.next!=null)
			i=i.next;
		i.next=n;
		n.next=null;
		return head;
	}

	static Node delete(Node head, int d){

		if(head==null){
			System.out.println("Empty List : Nothing to Delete");
			return null;
		}

		Node prev=null;
		Node current=head;
		
		
		while(current.data!=d){
			prev=current;
			current=current.next;
		}

		prev.next=current.next;
		return head;

	}

	public static void main(String args[]){


		//LL list = new LL();
		//list.head = new Node(10);
		Node head = new Node(15);
		Node second = new Node(20);
		Node third = new Node(25);

		//list.head.next=second;
		head.next=second;
		second.next=third;
		third.next=null;

		head=insertFront(head,10);
		head=insertAfter(head,20,22);
		head=insertEnd(head,50);
		head=delete(head,20);

		//printList(list.head);
		printList(head);

	}		
}