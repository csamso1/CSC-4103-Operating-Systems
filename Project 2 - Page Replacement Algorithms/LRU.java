/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/
import java.util.*;

public class LRU
{
	//Integer to track the Cache Size
	private int capacity;

	private int numPages;

	//Integer to track head of stack
	int head;

	//Integer to track tail of stack
	int tail;

	//Constructor for LRU cache structure
	public LRU(int cacheCapacity, Page[] pageTable)
	{
		capacity = cacheCapacity;
		numPages = 0;
		head = 0;
		tail = 0;
		List cache = new LinkedList<Page>();
	}

	//Maybe use this.. we will see
	public static void Schedule(){
		return;
	}

	//Loads a new Page File into cache
	public void loadPage(Page newPage)
	{
		int index = cache.indexOf(newPage);
		//Cache Empty
		if(isFull(cache) == false){
			//Cache Miss
			if(index == -1){
				cache.add(newPage);	
				//INCREMENT TIME UNIT
				
				//Print statment for testing
				System.out.printf("New Page added to non empty cache.\n");
			}
			//Cache Hit
			else{
				moveToTop(newPage, index);
			}
		}

		//Cache Hit
		if(index >= 0)
		{
			moveToTop(newPage, index);
			//Increment TIME UNIT
			//Print statement for testing
			System.out.prinf("Cache Hit! Page moved to top of stack.");
		}
		//Cache Miss
		else{
			cache.evictPage();
			cache.add(newPage);
		}
	}

	//Helper method for choosing a victim to evict when cache miss and cache is full
	public void evictPage(){
		cache.remove(cache.size() - 1);
		//INCREMENT Time unit based on modify bit

	}


	//Helper method for moving a page to the top of the stack, used in cache hit senario
	public void moveToTop(Page thePage, int pageIndex)
	{
		cache.remove(pageIndex);
		cache.add(thePage);
		//Print statement for testing
		System.out.printf("Page moved to top of stack!\n");

	}

	public boolean isFull(LinkedList stack)
	{
		if(stack.size() > stack.capacity) {
			return false;
		}
		else{
			return true;
		}
	}
}