#include<stdio.h>
#include<conio.h>
#include<process.h>
#define max 5
int queue[max];
int front=-1;
int rear=-1;
void Insert();
void Delete();
void Display();

void main()
{
	int ch;
	while(true)
	{
		printf("* * * Queue * * *\n");
		printf("1.Insert \n2.Delete \n3.Display \n4.Exit \n");
		scanf("%d",&ch);

		switch(ch)
		{
			case 1: Insert();break;
			case 2: Delete();break;
			case 3: Display();break;
			case 4: printf("Program execution complete \n");getch();exit(0);
			default: printf("Invalid Entry \n");
		}
	}
	getch();
}

void Insert()
{
	if(rear==max-1)
	{
		printf("queue Full : Insertion not possible \n");
		return;
	}

	if(front==-1)
		front=0;

	printf("Enter the element to be inserted into the queue \n");
	scanf("%d",&queue[++rear]);
}

void Delete()
{
	if(front==-1||front>rear)
	{
		printf("Empty queue : Deletion not possible \n");
		return;
	}
	else 
	{
		printf("The deleted element is %d \n",queue[front]);
		front++;
	}
}

void Display()
{
	if(front==-1||front>rear)
	{
		printf("Empty queue : Nothing to display \n");
		return;
	}

	else
	{
		printf("The elements in the queue \n");
		for(int i=front;i<=rear;i++)
			printf("%d\t",queue[i]);
		printf("\n");
	}
}
