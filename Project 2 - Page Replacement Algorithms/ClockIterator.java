/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/

public class ClockIterator
{
	//Integer to track the index of the iterator
	private static int index;

	//Integer to track the cache capacity
	private int cacheCapacity;

	//Constructor for creating an iterator
	public ClockIterator(int cacheSize)
	{
		index = 0;
		cacheCapacity = cacheSize;
	}

	public void next()
	{
		if(cacheCapacity < index-1){
			index++;
		}
		if(cacheCapacity == index-1){
			index = 0;
		}
	}

	public static int getIndex()
	{
		return index;
	}
}