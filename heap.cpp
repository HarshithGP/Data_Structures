#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<process.h>
#define max 7
using namespace std;

int insertHeap(int data,int HeapArray[],int n)
{
	int childPos,parentPos;
	if(n==max)
	{
		printf("Heap full : Cannot insert \n");
		return n;
	}

	childPos=n;
	parentPos=(childPos-1)/2;
	while(childPos!=0&&data>HeapArray[parentPos])
	{
		HeapArray[childPos]=HeapArray[parentPos];
		childPos=parentPos;
		parentPos=(childPos-1)/2;
	}
	HeapArray[childPos]=data;
	return n+1;
}

void Display(int heap[],int n)
{
	if(n==0)
	{
		printf("Empty Heap\n");
		return;
	}

	printf("The heap elements are \n");
	for(int i=0;i<n;i++)
		printf("%d\t",heap[i]);
	printf("\n");
}

void main()
{
	int ch,ele,n=0;
	int a[max];

	while(true)
	{
		printf("1.Insert\t 2.Display\t 3.Exit \n");
		scanf("%d",&ch);

		switch(ch)
		{
			case 1: printf("Enter element to be inserted into the heap \n");
					scanf("%d",&ele);
					n=insertHeap(ele,a,n);
					break;
			case 2:Display(a,n);break;
			case 3: printf("Program execution complete \n");getch();exit(0);
			default:printf("Invalid Entry \n");
		}
	}
	getch();
}