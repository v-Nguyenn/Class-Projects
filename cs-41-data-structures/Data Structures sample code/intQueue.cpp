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

class linkedQueue
{
private:
	IntSLLNode *front, *back;

public:
	linkedQueue()
	{
		front = back = 0;
	}

	bool isEmpty()
	{
		return front == 0;
	}

	void enqueue(int data)
	{
		//
		// Create our new node with its data
		IntSLLNode *temp = new IntSLLNode(data);
		//
		// Add the node to the back of the queue
		//
		// First check to see that there is a node first
		// if there isn't this is the first node
		// so set the back to it, otherwise, add it to the
		// back
		if (back == 0)
		{
			front = back = temp;
		}
		else
		{
			back->next = temp;
			//
			// Update the back to the new node
			back = temp;
		}
	}

	int dequeue()
	{
		//
		// check to see if the queue is empty
		if (isEmpty())
			return -999;

		//
		// create our empty node so that we can free up memory
		IntSLLNode *temp;
		//
		// get the data from the queue and hold onto it for a sec
		int intReturn = front->info;
		//
		// assign the temp to the front
		temp = front;
		//
		// reset the front to the next element in the queue 
		// (or null if there is no next element)
		front = front->next;
		//
		// return memory to the free store
		delete temp;

		return intReturn;
	}

	void print()
	{
		cout << "The queue, from front to back: ";
		for (IntSLLNode *temp = front; temp != 0; temp = temp->next)
			cout << temp->info << " ";
		cout << endl;
	}

}; // end linkedQueue

class arrayQueue
{
private:
	int front;
	int back;
	int nodeCount; // used for isEmpty() & enqueue & dequeue for load checking
	const static int MAX_QUEUE_SIZE = 100;
	int queue[MAX_QUEUE_SIZE];

public:
	arrayQueue()
	{
		//
		// Initialize the front and back of the queue to the 
		// first element of the array
		front = back = nodeCount = 0;
	}

	bool isEmpty()
	{
		return nodeCount == 0;
	}

	bool enqueue(int data)
	{
		//
		// Check to see if we have maxed out
		if (nodeCount++ == MAX_QUEUE_SIZE)
		{
			nodeCount--; // set nodeCount back to MAX_QUEUE_SIZE
			cout << "Error queue has hit its max size.\n";
			cout << "Front: " << front << endl
				<< "Back: " << back << endl
				<< "nodeCount: " << nodeCount << endl;
			return false;
		}
		//
		// Put our value into the back of the queue
		queue[back++] = data;
		
		//
		// rotate the queue around to the front of the array
		if (back >= MAX_QUEUE_SIZE)
			back = 0;
		
		return true;
	}

	int dequeue()
	{
		//
		// Check to see that we have a node to dequeue
		if (isEmpty())
			return -999;

		nodeCount--;
		int intReturn = queue[front++];

		//
		// rotate the queue around to the front of the array
		if (front > MAX_QUEUE_SIZE)
			front = 0;

		return intReturn;
	}

	void print()
	{
		//
		// This will break when the queue wraps around the array
		cout << "The values in the queue are, from front to back: ";
		for (int i = front; i < back; i++)
			cout << queue[i] << " ";
		cout << endl;
	}
}; // end arrayQueue

/***************************************************************************
									Queues

	A queue is similar to a stack, except that in stead of only having
	one point of entry, we now have two. We will use one end to add new
	nodes to, and the other end to take nodes from. So we add to the back
	of the line, and take from the front, just like at the airport, or
	for a printer. So this is a FIFO structure, First In First Out.

	Here is a schematic:

	enqueue(10);
	Front/Back
	+-----+
	|  10 |-->/
	+-----+

	enqueue(20);
	Front		Back
	+-----+		+-----+	
	|  10 |-->	|  20 |-->\
	+-----+		+-----+

	enqueue(15);
	Front					Back
	+-----+		+-----+		+-----+	
	|  10 |-->	|  20 |-->	|  15 |-->\
	+-----+		+-----+		+-----+

	dequeue();
	Front		Back
	+-----+		+-----+		
	|  20 |-->	|  15 |-->\	
	+-----+		+-----+		


***************************************************************************/
int main (void)
{
	/***********************************************************************
						Using a Queue via an array
	***********************************************************************/

	cout << "The queue operations, using an array.\n";
	arrayQueue arrayImplementation;

	cout << "Enqueue 10\n";
	arrayImplementation.enqueue(10);
	arrayImplementation.print();

	cout << "Enqueue 20\n";
	arrayImplementation.enqueue(20);
	arrayImplementation.print();

	cout << "Enqueue 15\n";
	arrayImplementation.enqueue(15);
	arrayImplementation.print();

	cout << "Dequeing " << arrayImplementation.dequeue() << endl;
	arrayImplementation.print();

	cout << "Filling up the queue: ";
	while (arrayImplementation.enqueue(25))
		cout << "."; // testing the limits of the array
	cout << endl;

	/***********************************************************************
						Using a Queue via a linked list
	***********************************************************************/

	cout << "The queue operations, using a linked list.\n";

	linkedQueue linkedImplemenation;

	cout << "\nEnqueue 10\n";
	linkedImplemenation.enqueue(10);
	linkedImplemenation.print();

	cout << "\nEnqueue 20\n";
	linkedImplemenation.enqueue(20);
	linkedImplemenation.print();

	cout << "\nEnqueue 15\n";
	linkedImplemenation.enqueue(15);
	linkedImplemenation.print();

	cout << "Dequeing " << linkedImplemenation.dequeue() << endl;
	linkedImplemenation.print();

	cout << "Dequeing " << linkedImplemenation.dequeue() << endl;
	linkedImplemenation.print();

	cout << "Dequeing " << linkedImplemenation.dequeue() << endl;
	linkedImplemenation.print();

	cout << "Dequeing " << linkedImplemenation.dequeue() << endl;
	linkedImplemenation.print();

	cout << "Enqueuing 1000 nodes\n";
	for (int i = 0; i < 1000; i++)
		linkedImplemenation.enqueue(i);

	linkedImplemenation.print();

	int pause;
	cout << "Enter 0<ENTER> to continue.";
	cin >> pause;
	return 0;
}
