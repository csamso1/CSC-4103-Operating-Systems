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
        PageFile pageQueue[] = new PageFile[550];
        int i = 0;
        while(scan.hasNext() == true)
        {  
            pageQueue[i] = new PageFile(scan.next(), scan.nextInt());
            // PageFile page0 = new PageFile(scan.next(), scan.nextInt());
            System.out.printf("page%d added to pageQueue :: %b pID: %d\n", i, pageQueue[i].getWriteStatus(), pageQueue[i].getPageID());
            i++;
        }
        //END scanning page files


        //Print statments for verification
        System.out.printf("System Cache Size: %d\n", cacheSize);
        System.out.printf("Algorithm to use: %s\n", algorithm);

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