#include<iostream>
#include<conio.h>
#include<stdlib.h>
#include<process.h>
using namespace std;

struct node
{
	int info;
	struct node *left;
	struct node *right;
};

class BIN_TREE
{
	node *tree;
	public : BIN_TREE()
			 {
				 tree=NULL;
			 }
			 struct node *maketree(node *tree,int data)
			 {
				 if(tree==NULL)
				 {
					 tree=new node;
					 tree->info=data;
					 tree->left=tree->right=NULL;
				 }

				 else if(tree->info==data)
					 cout<<"Duplicate key \n";
				 else if(data<tree->info)
					tree->left=maketree(tree->left,data);
				 else
					 tree->right=maketree(tree->right,data);

				 return tree;

			 }

			 void preorder(node *tree);
			 void inorder(node *tree);
			 void postorder(node *tree);
};

void BIN_TREE::preorder(node *tree)
{
	if(tree!=NULL)
	{
		cout<<tree->info<<"\t";
		preorder(tree->left);
		preorder(tree->right);
	}
}

void BIN_TREE::inorder(node *tree)
{
	if(tree!=NULL)
	{
		inorder(tree->left);
		cout<<tree->info<<"\t";
		inorder(tree->right);
	}
}

void BIN_TREE::postorder(node *tree)
{
	if(tree!=NULL)
	{
		postorder(tree->left);
		postorder(tree->right);
		cout<<tree->info<<"\t";
	}
}

int main()
{
	BIN_TREE b;
	int ch,ele;
	node *ptr=NULL;

	while(true)
	{
		cout<<"\n1.Insert\t 2.Preorder\t 3.Inorder\t 4.Postorder\t 5.Exit \n";
		cin>>ch;

		switch(ch)
		{
			case 1 : cout<<"Enter element \n";
					 cin>>ele;
					 ptr=b.maketree(ptr,ele);
					 break;
			case 2 : cout<<"Preorder traversal \n";
					 b.preorder(ptr);
					 break;
			case 3 : cout<<"Inorder traversal \n";
					 b.inorder(ptr);
					 break;
			case 4 : cout<<"Postorder traversal \n";
					 b.postorder(ptr);
					 break;
			case 5 : cout<<"Program execution complete \n";
					 getch();exit(0);
			default : cout<<"Invalid Entry \n";
		}
	}

	getch();
	return 0;
}

