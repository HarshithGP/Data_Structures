#include<iostream>
#include<conio.h>
#include<process.h>
using namespace std;

struct node
{
	int info;
	struct node *link;
};
typedef struct node *NODE;

class list
{
	private : NODE f;
	public  : list()
			  {
				  f=NULL;
			  }
			  void Insert(int num);
			  void Delete();
			  void Display();
};

void list::Insert(int num)
{
	NODE p;
	p=new node;
	p->info=num;
	p->link=f;
	f=p;
	cout<<"Insertion Successful \n";
}

void list::Delete()
{
	if(f==NULL)
		cout<<"Empty list: deletion not possible \n";
	
	else
	{
		cout<<"Deleted item is "<<f->info;
		f=f->link;
	}
}

void list::Display()
{
	NODE temp;
	temp=f;
	if(f==NULL)
		cout<<"Empty list :Nothing ot diplay\n";

	else
	{
		cout<<"Elements of the list are \n";
		while(temp!=NULL)
		{
			cout<<temp->info<<"\t";
			temp=temp->link;
		}
		cout<<"\n";
	}
}

int main()
{
	int ch,ele;
	list ob;
	while(true)
	{
		cout<<"1.Insert\t 2.Delete\t 3.Display\t 4.Exit \n";
		cin>>ch;

		switch(ch)
		{
			case 1 : cout<<"Enter element to be inserted \n";
					 cin>>ele;
					 ob.Insert(ele);
					 break;
			case 2 : ob.Delete();
					 break;
			case 3 : ob.Display(); 
					 break;
			case 4 : cout<<"Program execution complete \n";
					 getch();
					 exit(0);
			default : cout<<"Invalid Entry \n";
		}
	}

	getch();
	return 0;
}

