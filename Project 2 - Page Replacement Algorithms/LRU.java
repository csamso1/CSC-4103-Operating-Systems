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
	private static int capacity;

	//Interger to track time units used
	private static int timeElapsed;

	//Integer to track time elapsed for cache misses
	private static int cacheMissTime;

	//Integer to track the time elapsed during writing pages back to hard drive
	private static int cacheWriteBackTime;

	//Integer to track the number of page files in the cache
	private static int numPages;

	//Integer to track the total number of page references
	private static int numPageReferences;

	//Integer to tack the total number of cache misses (page misses)
	private static int numCacheMisses;

	//Linked List to cache page files
	private static LinkedList<Page> cache = new LinkedList<Page>();

	//Constructor for LRU cache structure
	public LRU(int cacheCapacity, Page[] pageTable)
	{
		capacity = cacheCapacity;
		numPages = 0;
		timeElapsed = 0;
		numPageReferences = 0;
		numCacheMisses = 0;
		cacheMissTime = 0;
		cacheWriteBackTime = 0;
	}

	//Method to schedule the provided pages using LRU algorithm
	public static void Schedule(Page[] pageTable)
	{
		//Print statment for testing
		//System.out.printf("LRU.Schedule() called!\n");
		for(int i = 0; i < pageTable.length; i++)
		{
			LRU.loadPage(pageTable[i]);
		}
		timeElapsed = cacheMissTime + cacheWriteBackTime;
		System.out.printf("Total Time Elapsed = %d Time Units\n", timeElapsed);
		System.out.printf("Total Cache Miss Time = %d Time Units\n", cacheMissTime);
		System.out.printf("Total Cache Write Back Time = %d Time Units\n", cacheWriteBackTime);
		System.out.printf("Total # of page references = %d\n", numPageReferences);
		System.out.printf("Total # of page misses = %d\n", numCacheMisses);
	}

	//Loads a new Page File into cache
	public static void loadPage(Page newPage)
	{
		//Print statment for testing
		//System.out.printf("loadPage Method called! page: %b %d\n", newPage.getWriteStatus(), newPage.getPageID());
		
		numPageReferences++;
		int index = LRU.searchCache(newPage);
		
		//Print statment for testing
		//System.out.printf("index = %d\n", index);
		
		//Cache Empty
		if(LRU.isFull() == false){
			//Print statment for testing
			// System.out.printf("LRU.isFull() returned false!\n");

			//Cache Miss
			if(index == -1){
				LRU.addPage(newPage);
				numCacheMisses++;
				//Print statment for testing
				// System.out.printf("New Page added to non empty cache. Page = %s\n", newPage);
			}
			//Cache Hit
			else{
				moveToTop(index);
			}
		}

		//Cache is full
		//Print statment for testing
		// System.out.printf("LRU.isFull() returned true\n");

		//Cache Hit
		else{
			if(index >= 0)
			{
				moveToTop(index);
				//Print statement for testing
				//System.out.printf("Cache Hit! Page moved to top of stack.\n");
			}
			//Cache Miss
			else{
				LRU.evictPage();
				LRU.addPage(newPage);
				numCacheMisses++;
				//Print statment for testing
				//System.out.printf("Cache is full, and cache miss, page evited and newPage added\n");
			}
		}
	}

	//Helper method for choosing a victim to evict when cache miss and cache is full
	private static void evictPage()
	{
		//Increments the time unit based on modify bit
		if(cache.peekFirst().getWriteStatus() == true){
			cacheWriteBackTime += 10;
			// System.out.printf("dirty page written back to memory, page = %s %s\n", cache.peekFirst().getWriteStatus(), cache.peekFirst().getPageID());
		}
		// System.out.printf("clean page removed, not written back to memory, page = %s %s\n", cache.peekFirst().getWriteStatus(), cache.peekFirst().getPageID());
		cache.remove(0);
		numPages--;
	}

	//Helper method for adding a new page to the top of the cache
	private static void addPage(Page newPage)
	{
		// System.out.printf("addPage() called, new page = %s %s\n", newPage.getWriteStatus(), newPage.getPageID());
		cache.add(newPage);
		cacheMissTime += 5;
		numPages++;
	}

	//Helper method for moving a page to the top of the stack, used in cache hit senario
	private static void moveToTop(int pageIndex)
	{

		//System.out.printf("stack before move: %s\n", cache.toString());
		Page thePage = cache.get(pageIndex);
		// System.out.printf("stack after 'get' is called: %s\n", cache.toString());
		// System.out.printf("moveToTop called, page = %s %s\n", thePage.getWriteStatus(), thePage.getPageID());
		cache.remove(pageIndex);
		cache.add(thePage);
		// System.out.printf("stack after move operatoins: %s\n", cache.toString());
		//Print statement for testing
		//System.out.printf("Page moved to top of stack!\n");

	}

	//Determines if the chache is full or not
	private static boolean isFull()
	{
		if(cache.size() >= LRU.capacity) {
			return true;
		}
		else{
			return false;
		}
	}
	
	//Helper method for searching the cache, returns -1 if not found
	private static int searchCache(Page targetPage)
	{
		//Print statment for testing
		//System.out.printf("searchCache called!\n");
		int targetPageID = targetPage.getPageID();

		for(int i = 0; i < cache.size(); i++)
		{
			if(cache.get(i).getPageID() == targetPageID)
			{
				return i;
			}
		}
		return -1;
	}
}