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

    int info;			// Our data
    IntSLLNode *next;	// Our Link
	
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

/*

	Our Un-Ordered Singly Linked List Class

	This object handles the adding of nodes to either the front or back
	of the list. The deleting from the front, back, or middle of the list.
	It can also print out the list and check to see if an element is in
	the list

*/
class IntSLList 
{
private:
	//
	// Our two special nodes that we will use to quickly acess
	// the front and back of the list
	//
    IntSLLNode *head, *tail;
	
public:

	//
	// Default Constructor
	//
	// Initializes its two memebers, head and tail to point to nothing
	//
    IntSLList() 
	{
        head = tail = 0;
    }

	//
	// Our Deconstructor
	//
	// This will make sure the list elements are freed when we no
	// longer need the list
	//
    ~IntSLList()
	{
		//
		// Create a node pointer
		// While the list isn't empty
		// start deleting nodess starting at the head
		for (IntSLLNode *p; !isEmpty(); ) 
		{
			p = head->next;	// set our temporary pointer to the next element
			delete head;	// delete the memory allocated to the head (note this doesn't kill our pointer)
			head = p;		// set the head to the new head (or nothing if this is the last node)
		}
	}

	//
	// Checks to see if the head is pointing nowhere (0)
	// if it does, then it is empty, otherwise the list is not empty
	//
    int isEmpty() 
	{
        return head == 0;
    }

    void addToHead(int data)
	{
		//
		// Add the new node to the front of the list at the head
		//
		// The node constructor handles the linking of the two
		// nodes together
		head = new IntSLLNode(data,head);
		
		/* Line above is same as these 3 below.
		IntSLLNode* temp = new IntSLLNode(data);
		temp->next = head;
		head = temp;*/

		//
		// Make tail also the head if it isn't already something else
		// 
		if (tail == 0)
		   tail = head;
	}

    void addToTail(int data) 
	{
		if (tail != 0) // if list not empty;
		{      
			//
			// Link the current tail to a new node
			//
			tail->next = new IntSLLNode(data);
			//
			// Make the tail the new node
			//
			tail = tail->next;
		}
		else 
			head = tail = new IntSLLNode(data);
	}

	// delete the head and return its info;
    int  deleteFromHead() 
	{
		int data = head->info;	// save the data to local variable
		IntSLLNode *tmp = head;	// create a pointer to head

		if (head == tail)		// if only one node on the list;
			 head = tail = 0;	// set the head and tail pointers to nothing
		else 
			head = head->next;	// set the new head

		delete tmp;				// free up the memory that was used by the old head
		return data;			// return the former heads data
	} 

	// delete the tail and return its info;
    int  deleteFromTail() 
	{
		int data = tail->info;	// get data from the tail node into local variable
		if (head == tail)		// if only one node on the list;
		{   
			 delete head;		// free up memory
			 head = tail = 0;	// head and tail pointers point nowhere
		}
		else					// if more than one node in the list,
		{                
			 IntSLLNode *tmp;	// find the predecessor of tail;
			 //
			 // Body-less for loop that will traverse the list
			 // to find the node that points to the tail
			 for (tmp = head; tmp->next != tail; tmp = tmp->next); // <-- note the semi-colon

			 delete tail;		// free up the memory at tail
			 tail = tmp;		// the predecessor of tail becomes tail;
			 tail->next = 0;	// set tail pointer to nothing
		}
		return data;
	} 

    void deleteNode(int data) 
	{
		//
		// check to see that the list isn't empty list
		//
		if (head != 0)                
		{
			//
			// if only one element in the list, head will equal tail
			// then we also check to see if this one node has the
			// data we are looking for
			//
			if (head == tail && data == head->info)  
			{
				//
				// Free up the memory at the head, aka tail,
				// and set the head and tail to point nowhere
				delete head;                       
				head = tail = 0;
			}
			else if (data == head->info)   
			{
				//
				// if more than one node on the list
				// check to see if the data is at the head
				// and delete the head if it is
				IntSLLNode *tmp = head;
				head = head->next;		// make the new head at the next node
				delete tmp;             // and delete the old head
			}
			else                        
			{
				//
				// if more than one node in the list and data is not in the head
				//
				IntSLLNode *pred, *tmp;

				//
				// An empty for loop that will get us to the node
				// we are looking for, and keeps track of the previous
				// node so that we can do some re-linking
				//
				// Step 1 (Keep track of the node we will be deleting)
				for (pred = head, tmp = head->next;			// grab the first two nodes
					tmp != 0 && !(tmp->info == data);		// check the second node for data
					pred = pred->next, tmp = tmp->next);	// move both nodes one down the list


				if (tmp != 0)					// make sure that we are pointing somewhere
				{
					pred->next = tmp->next;		// link around the node to be deleted (Step 2)

					if (tmp == tail)			// watch for the tail
						tail = pred;

					delete tmp;					// delete the node (Step 3)
				}
			}
		}
	}

    bool isInList(int data) const 
	{
		//
		// Ascertain if the data is in our list at this point in time
		//
		IntSLLNode *tmp;
		//
		// Our empty for loop again, starting at the head
		// traversing the list until it reaches the end
		// or finds the data we are looking for
		//
		for (tmp = head; tmp != 0 && !(tmp->info == data); tmp = tmp->next);
		//
		// A logical test to see if we found the element, or
		// went off the list
		//
		return tmp != 0;
	}

    void printAll() const 
	{
		//
		// Print the list
		for (IntSLLNode *tmp = head; tmp != 0; tmp = tmp->next)
			cout << tmp->info << " ";
		cout << endl;
	}
}; // end Singly Linked List - IntSLList

int main (void)
{
	IntSLList *theList = new IntSLList();

	cout << "Adding 10" << endl;
	theList->addToHead(10);
	cout << "Adding 25" << endl;
	theList->addToHead(25);
	cout << "Adding 15" << endl;
	theList->addToHead(15);
	cout << "Adding 20" << endl;
	theList->addToHead(20);
	cout << "Adding 100" << endl;
	theList->addToHead(100);

	cout << "The list: ";
	theList->printAll();

	cout << "Adding 99" << endl;
	theList->addToTail(99);
	cout << "Adding 54" << endl;
	theList->addToTail(54);
	cout << "Adding 33" << endl;
	theList->addToTail(33);

	cout << "The list: ";
	theList->printAll();

	if (theList->isInList(33))
		cout << "Found 33" << endl;

	cout << "Deleting from head: " << theList->deleteFromHead() << endl;
	cout << "Deleting from the tail: " << theList->deleteFromTail() << endl;

	cout << "Deleting 100" << endl;
	theList->deleteNode(100);
	cout << "Deleting 100 again" << endl;
	theList->deleteNode(100);

	cout << "Is the list empty?? " << theList->isEmpty() << endl;
	cout << "Is 100 in the list?? " << theList->isInList(100) << endl;	
	
	cout << "The list: ";
	theList->printAll();

	int pause;
	cin >> pause;

	return 0;
}

