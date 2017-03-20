/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PageReplacementAlgorithms
{
	//MAIN Class
    public static void main(String[] args) throws FileNotFoundException
    {
    	int cacheSize = 0;
    	String algorithm;
    	Scanner scn = new Scanner(System.in);
    	System.out.printf("Provide input file name: \n");
    	String inputFileName = scn.nextLine();
    	Scanner scan = new Scanner(new File(inputFileName));
    	PageFile page0 = new PageFile(scan.next(), scan.nextInt());
    	System.out.printf("page0 = %b pID: %d\n", page0.getWriteStatus(), page0.getPageID());
    }

    //Class for CLOCK algorithm
    public static void clock()
    {
    	//ToDo
    }

    //Class for LRU algorithm
    public static void lru()
    {
    	//ToDo
    }
}