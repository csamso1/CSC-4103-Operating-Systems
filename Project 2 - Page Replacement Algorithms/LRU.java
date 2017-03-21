/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/

public class LRU
{
	//Integer to track the Cache Size
	private int size;

	private int numPages;

	//Integer to track head of stack
	int head;

	int tail;

	//Integer to track tail of stack
	public class LRU(int capacity, Page[] pageTable)
	{
		size = capacity;
		numPages = 0;
		head = 0;
		tail = 0;
		Page pageStack[] = new Page[size];

	}

	//Maybe use this.. we will see
	public static void Schedule(){
		return;
	}

	//Pushes a new process to the top of the stack
	public void push(int processID, int modifyBit)
	{
		//Cache Hit
		if(searchStack(processID) >= 0)
		{
			//ToDo: move page to top of stack
		}
		//Cache Miss
		else{
			//ToDo: Evict Page
		}
	}

	public void remove(int index)
	{
		pageTable[index] = null
		for(int i = index; i < size; i++)
		{
			//ToDo: move all pages down so a new page can be pushed to the top of the stack
		}
	}

	//searches cache for the provided proecess ID, returns -1 if not found
	private int searchStack(int processID)
	{
		for(int i = 0; i < size; i++)
		{
			if(pageStack[i].getPageID() == processID){
				return i;
			}
		}
		else{
			return -1;
		}
	}
}