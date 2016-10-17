/* Stacks - Last In First Out (LIFO)
 * 
 * Operations
 * 
 * Push: Inserts an element at the Top
 * Pop: deletes the Element on Top
 * Peek: returns element at the top without deleting
 * 
 * 
 * 
 * 
 * 
 */
import java.io.*;
import java.util.*;

public class stack
{
    	private String[] Stack_Array; //stack to store string items
    	private int Stack_Size; //size of stack
    	private int Top_Of_Stack = -1; //initially empty stack

    	//constructor to initialize the stack
    	stack(int size)
    	{
    			Stack_Size = size;
    			Stack_Array = new String[size];
    	}	
    	
    	
    	//  PUSH operation
    	public void push(String input)
    	{
    		//check for stack overflow
    			if(Top_Of_Stack+1 < Stack_Size)
    			{
    					Stack_Array[++Top_Of_Stack] = input;
    					System.out.println("PUSH OPERATION : " + input + " was pushed onto the Stack");
    					displayStack_Object();
    			} 
    			
    			else
    				System.out.println("Stack Overflow: "+input+ " Cannot be Pushed");
    	}
  
    	//POP operation
    	public  void pop()
    	{
    			//check for stack underflow
    			if(Top_Of_Stack < 0)
    			{
    					System.out.println("Stack UnderFlow: No item to be delected");
    					displayStack_Object();
    			}
    			else 
    			{
    					System.out.println("POP OPERATION : " + Stack_Array[Top_Of_Stack--] + " was popped from the Stack");
    					displayStack_Object();
    			}
    	}
    	
    	public void peek()
    	{
    			if(Top_Of_Stack==-1)
    				System.out.println("Stack Empty");
    			else
    					System.out.println("PEEK: " + Stack_Array[Top_Of_Stack] + " is at the Top of the Stack");
    	}
    	
    	// push multiple values
    	public void pushMany(String multipleValues)
    	{
    			String[] tempString = multipleValues.split(" ");
    			for(int i = 0; i < tempString.length; i++)
    					push(tempString[i]);
    	}
    	
    	// pop all stack contents
    	public void popAll()
    	{
    			if(Top_Of_Stack<0)
    					System.out.println("Stack Empty");
    			else
    					for(int i = Top_Of_Stack; i >= 0; i--)	
    							pop();
    	}
    	
    	public void displayStack_Object()
    	{
    		if(Top_Of_Stack==-1)
    				System.out.println("Empty Stack");
    		else
    		{
            		System.out.println("The elements of the stack: ");
            		for(int i=Top_Of_Stack;i>=0;i--)
            				System.out.println(Stack_Array[i]);	
            		for(int i=0;i<100;i++)
            			System.out.print("-");
            		System.out.println();
    		}
    	}
    	
    	public static void main(String[] args)throws IOException
    	{
    			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    			stack Stack_Object = new stack(10);
    			
    			int x=0,ch=0;
    			while(x==0)
    			{
    					System.out.println("----------Stack----------");
    					System.out.println("1. Push");
    					System.out.println("2. Push Many");
    					System.out.println("3. Pop");
    					System.out.println("4. Pop All");
    					System.out.println("5. Peek");
    					System.out.println("6. Display");
    					System.out.println("0. Exit");
    					System.out.println("Enter your choice of operation : ");
    					String inp=br.readLine();
    					try
    					{
    						//input validation
    						ch=Integer.parseInt(inp);
    						if(ch>=0 && ch<=6)
    							x=1;
    						else
    							System.out.println("Incorrect Input Choice \n");
    					}
    					catch(NumberFormatException e)
    					{
    							System.out.println(e);
    					}
    					
    					if(x==1)
    					{
    							x=0;
    						
    							switch(ch)
    							{
    									case 1: 
    													System.out.println("Enter element to be pushed");
    													inp=br.readLine();
    													Stack_Object.push(inp);
    													break;
    									
    									case 2:   System.out.println("Enter the elements to be pushed");
														inp=br.readLine();
														Stack_Object.pushMany(inp);
    													break;
    													
    									case 3:  Stack_Object.pop(); 
    													break;
    													
    									case 4:  Stack_Object.popAll();
										                break;
										
    									case 5:  Stack_Object.peek();
													    break;
													    
    									case 6: Stack_Object.displayStack_Object(); break;
													    
    									case 0: System.out.println("Have a nice day ");
    													System.exit(0);
    						}// end of switch
    						
    					}//end of if
    						
    			}//end of while

    	}//end of main()
    	
}// end of class stack