#include <iostream>

using namespace std;

/*
	Our Singly Linked List Node object, that holds an integer as its Data

	+---------------+-----------+
	|				|			|
	|  DATA			|	LINK	|
	|				|			|
	+---------------+-----------+

*/
class IntSLLNode 
{
public:

    int info;				// Our data
    class IntSLLNode *next;	// Our Link
	
	//
	// Constructor
	//
	// Takes an integer to be stored in info
	// and a pointer if provided, it is an optional
	// parameter that defaults to zero
	//
    IntSLLNode(int data, IntSLLNode *ptr = 0) 
	{
        info = data; 
		next = ptr;
    }
};

class linkedStack
{
private:
	IntSLLNode *top; // our single entrance point into the stack

public:
	linkedStack()
	{
		//
		// set the list to empty
		top = 0;
	}

	bool isEmpty()
	{
		return top == 0;
	}

	void push(int data)
	{
		//
		// Add data to the stack by creating a node with that data
		IntSLLNode *temp = new IntSLLNode(data);

		//
		// Then placing the node onto the stack
		//
		// If the stack is empty, then the stack is the new node
		if (isEmpty())
			top = temp;
		else
		{
			//
			// Otherwise the new node is on top of the stack
			// and the new node points to the previous top of the stack
			temp->next = top;
			top = temp;
		}
	}

	int pop()
	{
		//
		// If the stack is empty return a sentinel value
		if (isEmpty())
			return -999;
				
		//
		// Get the data to return from the top of the stack
		int intReturn = top->info;
		//
		// Create a pointer to keep track of the top node
		IntSLLNode *temp;
		temp = top;
		//
		// Move the top of the stack to the next element
		// or null if there is no next element
		top = top->next;
		//
		// Free up memory
		delete temp;

		//
		// Send back the data
		return intReturn;
	}

	void print()
	{
		cout << "The stack (from the top): ";

		for(IntSLLNode *temp = top; temp != 0; temp=temp->next)
			cout << temp->info << " ";
		cout << endl;
	}		
}; // end linkedStack

int main (void)
{
	//
	//			Stacks
	//
	// A stack is a linear data structure that can be accessed
	// only at one end. A stack is a LIFO structure, where the
	// the Last In First Out logic applies. So if we put in
	// item A, then B, then C, when we take an item out, it will be C
	//
	//
	// The basic stack operations are known as push and pop
	// Push: place an item onto the top of the stack
	// Pop: take an item from the top of the stack
	//
	//
	/*
			Example Stack (There is only one actual stack
			I am just showing the progression.


		|    |	|    |	|    |	|    |	|    |	|    |	|    |	
		|    |	|    |	|    |	|    |	|    |	|    |	|    |	
		|    |	|    |	|    |	|    |	|    |	|    |	|    |	
		|    |	|    |	|    |	|    |	|    |	|    |	|    |	
		|    |	|    |	|    |	|    |	|    |	|    |	|    |	
		|    |	| 25 |	|    |	| 20 |	|    |	|    |	|    |	
		| 10 |	| 10 |	| 10 |	| 10 |	| 10 |	|    |	| 35 |	
		+----+  +----+  +----+  +----+  +----+  +----+  +----+  
		  1		   2	  3		   4	   5	   6	  7	
							States:

		theStack.push(10);	// State 1  1 item on stack
		theStack.push(25);	// State 2	2 items on stack
		theStack.pop();		// State 3  1 item on stack
		theStack.push(20);	// State 4	2 items on stack
		theStack.pop();		// State 5  1 item on stack
		theStack.pop();		// State 6  0 items on stack
		theStack.push(35);	// State 7  1 item on stack

	*/

	/***********************************************************************
	*		Working with linkedStack
	***********************************************************************/

	linkedStack linkedImplementation;

	cout << "\nWorking with the linked list implementation of the stack.\n";

	cout << "Pushing 10 onto the stack:\n";
	linkedImplementation.push(10);
	linkedImplementation.print();

	cout << "Pushing 25 onto the stack:\n";
	linkedImplementation.push(25);
	linkedImplementation.print();

	cout << "Popping from the stack: " << linkedImplementation.pop() << endl;
	linkedImplementation.print();

	cout << "Pushing 20 onto the stack:\n";
	linkedImplementation.push(20);
	linkedImplementation.print();

	cout << "Popping from the stack: " << linkedImplementation.pop() << endl;
	linkedImplementation.print();
	
	cout << "Popping from the stack: " << linkedImplementation.pop() << endl;
	linkedImplementation.print();

	cout << "Is the stack empty: " << linkedImplementation.isEmpty() << endl;
	
	cout << "Pushing 35 onto the stack:\n";
	linkedImplementation.push(35);
	linkedImplementation.print();

	cout << "Pushing 10000 elements onto the stack.";
	for (int i = 0; i < 10000; i++)
	{
		linkedImplementation.push(i);
		cout << ".";
	}
	cout << "\nPress 0<ENTER> to continue.";
	int pause;
	cin >> pause;

	linkedImplementation.print();

	cout << "\nPress 0<ENTER> to continue.";
	cin >> pause;

	return 0;
}