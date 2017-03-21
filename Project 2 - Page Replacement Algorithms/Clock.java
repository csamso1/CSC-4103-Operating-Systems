/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/

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

	
}