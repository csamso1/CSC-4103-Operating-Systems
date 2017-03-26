/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/

import java.util.*;

public class Clock
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

	//Integer to track index of clock pointer
	private static int iterator;

	//Constructor for the clock data structure
	public Clock(int cacheCapacity, Page[] pageTable)
	{
		capacity = cacheCapacity;
		numPages = 0;
		timeElapsed = 0;
		numPageReferences = 0;
		numCacheMisses = 0;
		cacheMissTime = 0;
		cacheWriteBackTime = 0;
		iterator = 0;
	}

	//Method to schedule provided pages using the clock algorithm
	public static void Schedule(Page[] pageTable)
	{
		// System.out.printf("Clock.Schedule() has been called, not yet implmented.\n");
		for(int i = 0; i < pageTable.length; i++)
		{
			Clock.loadPage(pageTable[i]);
		}
		timeElapsed = cacheMissTime + cacheWriteBackTime;
		System.out.printf("Total Time Elapsed = %d Time Units\n", timeElapsed);
		System.out.printf("Total Cache Miss Time = %d Time Units\n", cacheMissTime);
		System.out.printf("Total Cache Write Back Time = %d Time Units\n", cacheWriteBackTime);
		System.out.printf("Total # of page references = %d\n", numPageReferences);
		System.out.printf("Total # of page misses = %d\n", numCacheMisses);
	}

	//Method for loading a Page File into the cache
	private static void loadPage(Page newPage)
	{
		numPageReferences++;
		int index = Clock.searchCache(newPage);
		//Cache Empty
		if(Clock.isFull() == false)
		{
			//Cache Miss while cache is not full
			if(index == -1){
				Clock.addPage(newPage);
				numCacheMisses++;
			}
			//Cache hit while cache is not full
			else{
				cache.get(index).setReferenceBit(true);
			}
		}
		//Cache full
		{
			//Cache Miss while cache is full
			if(index == -1){
				Clock.addPage(newPage, Clock.evictPage());
				numCacheMisses++;
			}
			//Cache Hit while cache is full
			else{
				cache.get(index).setReferenceBit(true);
			}
		}
	}

	//Helper method for choosing a victim to evict when cache miss and cache is full
	private static int evictPage()
	{
		ClockIterator arm = new ClockIterator(numPages);
		while(cache.get(arm.getIndex()).getReferenceBit() == true)
		{
			//If reference bit == true
			if(cache.get(arm.getIndex()).getReferenceBit() == true)
			{
				cache.get(arm.getIndex()).setReferenceBit(false);
				arm.next();
			}
		}
		if(cache.get(arm.getIndex()).getWriteStatus() == true){
			cacheWriteBackTime += 10;
		}
		cache.remove(arm.getIndex());
		numPages--;
		return arm.getIndex();
	}

	//Helper method for adding a new page to the cache at specified index
	private static void addPage(Page newPage, int index)
	{
		cache.add(index, newPage);
		cacheMissTime += 5;
		numPages++;
	}

	//Helper method for adding a new page to the cache
	private static void addPage(Page newPage)
	{
		cache.add(newPage);
		cacheMissTime += 5;
		numPages++;
	}

	//Determines if the chache is full or not
	private static boolean isFull()
	{
		if(cache.size() >= Clock.capacity) {
			return true;
		}
		else{
			return false;
		}
	}

	//Helper method for searching the cache, returns -1 if not found
	private static int searchCache(Page targetPage)
	{
		for(int i = 0; i < cache.size(); i++)
		{
			if(cache.get(i).getPageID() == targetPage.getPageID())
			{
				return i;
			}
		}
		return -1;
	}
}