/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/

public class Page
{	

	//String representing the action preformed to this page
	private String action;

	//Integer to hold page ID value
	private int pID;

	//Boolean representing the action preformed to this page
	boolean modifyBit;

	//Boolean to determine if the page has been referenced recently
	boolean referenceBit;

	//Constructs a new Page
	public Page(String pageAction, int pageID)
	{
		//Sets newWrite flag to provied value
		action = pageAction;

		//Sets pID value to the provided Page ID
		pID = pageID;

		if(action.equalsIgnoreCase("W")){
			modifyBit = true;
		}
		else{
			modifyBit = false;
		}

		referenceBit = false;
	}

	//Method to return if the page has been modified
	public boolean getWriteStatus()
	{
		if(this.modifyBit == true)
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

	public boolean getReferenceBit()
	{
		if(referenceBit == true)
		{
			return true;
		}
		else{
			return false;
		}
	}

	public void setReferenceBit(boolean bit)
	{
		this.referenceBit = bit;
	}

	public void setActionToWrite(){
		this.action = "W";
	}
}