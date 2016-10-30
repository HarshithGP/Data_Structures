#include<iostream>
#include<conio.h>
#include<process.h>
#include<malloc.h>

struct node
{
	int info;
	struct node *llink;
	struct node *rlink;
};
typedef struct node *NODE;

NODE getnewnode()
{
	NODE newnode;
	newnode=(NODE)malloc(sizeof(struct node));
	if(newnode==NULL)
	{
		printf("Insufficient memory \n");
		getch();
		exit(0);
	}
	return newnode;
}

NODE insertfront(NODE head,int data)
{
	NODE temp,current;
	temp=getnewnode();
	temp->info=data;

	current=head->rlink;
	head->rlink=temp;
	temp->llink=head;
	temp->rlink=current;
	current->llink=temp;

	return head;
}

NODE insertleft(NODE head,int key)
{
	NODE previous,temp,current;
	int data;

	if(head->rlink==head)
	{
		printf("Empty list \n");
		return head;
	}

	current=head->rlink;
	while(current!=head)
	{
		if(current->info==key)
			break;

		current=current->rlink;
	}

	if(current==head)
	{
		printf("node with element %d not found \n",key);
		return head;
	}

	else
	{
		previous=current->llink;
		printf("Enter the value for node to be inserted to the left of node with data element %d\n",key);
		scanf("%d",&data);

		temp=getnewnode();
		temp->info=data;

		temp->rlink=current;
		current->llink=temp;
		temp->llink=previous;
		previous->rlink=temp;
		return head;
	}
}

NODE Delete(NODE head,int key)
{
	NODE previous,current,next;

	if(head->rlink==head)
	{
		printf("Empty list : Nothing to delete \n");
		return head;
	}

	current=head->rlink;
	while(current!=head)
	{
		if(current->info==key)
			break;

		current=current->rlink;
	}

	if(current==head)
	{
		printf("node with element %d not found \n",key);
		return head;
	}

	else
	{
		previous=current->llink;
		next=current->rlink;

		previous->rlink=next;
		next->llink=previous;
		printf("The node with data element %d is deleted \n",current->info);
		free(current);
		return head;
	}
}

void Display(NODE head)
{
	if(head->rlink==head)
	{
		printf("Empty list : Nothing to display \n");
		return;
	}
		
	NODE temp;
	temp=head->rlink;

	printf("The linked list elements are \n");
	while(temp!=head)
	{
		printf("%d\t",temp->info);
		temp=temp->rlink;
	}
	printf("\n");
}

void main()
{
	int ch,ele;
	NODE head;
	head=getnewnode();
	head->llink=head->rlink=head;
	while(true)
	{
		printf("1.InsertFront\t 2.InsertLeft \t3.Delete \t4.Display \t5.Exit \n");
		scanf("%d",&ch);

		switch(ch)
		{
			case 1 : printf("enter element to be inserted \n");
					 scanf("%d",&ele);
					 head=insertfront(head,ele);
					 break;

			case 2 :printf("Enter the key element to be searched for \n");
					 scanf("%d",&ele);
					 head=insertleft(head,ele);
					 break;
			case 3 : printf("Enter element to be deleted \n");
					 scanf("%d",&ele);
					 head=Delete(head,ele);
					 break;
			case 4 : Display(head);break;
			case 5 : printf("Program execution complete \n");
					 getch();exit(0);
			default : printf("Invalid entry \n");
		}
	}
	getch();
}





	

