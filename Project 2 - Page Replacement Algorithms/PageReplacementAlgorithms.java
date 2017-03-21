/*
Name:		Samson, Clayton
Project: 	PA-2 (Page Replacement Algorithms)
File:		pageref.txt
Instructor:	Feng Chen
Class:		cs4103-sp17
LoginID:	cs410385
*/

import java.io.*;
import java.util.*;
import java.util.*;

public class PageReplacementAlgorithms
{
	//MAIN Class
    public static void main(String[] args) throws FileNotFoundException, Exception
    {
        //Uses command line arguments to set algorithm, cache size, and the input file name
        try{
            String algorithm = args[0];
            int cacheSize = Integer.parseInt(args[1]);
            String inputFileName = args[2];
        } catch(Exception e){
            throw new Exception("ERROR: Invalid command line args.\nPlease provide Algorithm (String), Cache Size (Integer), Input File Name (String) as command line arguments.", e);
        }
        String algorithm = args[0];
        int cacheSize = Integer.parseInt(args[1]);
        String inputFileName = args[2];
    	Scanner scan = new Scanner(new File(inputFileName));
        Scanner scn = new Scanner(new File(inputFileName));
        int numPagesToSchedule = 0;
        while(scn.hasNextLine() == true)
        {
            numPagesToSchedule++;
            scn.nextLine();
        }
        Page pageTable[] = new Page[numPagesToSchedule];   //Array to hold all imported Page Files
        int i = 0;
        while(scan.hasNext() == true)
        {  
            pageTable[i] = new Page(scan.next(), scan.nextInt());
            //Print statment for testing
            //System.out.printf("page%d added to pageTable :: %b pID: %d\n", i, pageTable[i].getWriteStatus(), pageTable[i].getPageID());
            i++;
        }
        //END scanning page files

        //Print statments for verification
        System.out.printf("System Cache Size: %d\n", cacheSize);
        System.out.printf("Algorithm to use: %s\n", algorithm);

        //BEGIN Scheduling
        if(algorithm.equalsIgnoreCase("lru") == true || algorithm.equalsIgnoreCase("Leas Recently Used") == true)
        {
            LRU cache = new LRU(cacheSize, pageTable);
            cache.Schedule(pageTable);
        }
        else if(algorithm.equalsIgnoreCase("clock") == true)
        {
            Clock cache = new Clock(cacheSize, pageTable);
            cache.Schedule(pageTable);
        }
        else{
            System.out.printf("Algorithm inproperly defined, please provide 'LRU' or 'CLOCK' as algorithm argument.\n");
        }
        //END Scheduling
    }
}