/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/

public class PageFile
{	

	//boolean for if the page has been written to
	public String action;

	//Integer to hold page ID value
	public int pID;

	//Constructs a new pageFile
	public PageFile(String pageAction, int pageID)
	{
		//Sets newWrite flag to provied value
		action = pageAction;

		//Sets pID value to the provided Page ID
		pID = pageID;
	}

	public boolean getWriteStatus()
	{
		if(this.action.equalsIgnoreCase("W"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getPageID()
	{
		return this.pID;
	}
}