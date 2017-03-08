/**
 * @author Clayton Samson
 * CSC 4103 Sudoku Solution Checker
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class SudokuSolutionChecker
{
    //Creates 2D array used to store the provided solution.
    public static int[][] solution = new int[9][9];
    //Creates global varriable to track if the provided solution is valid.
    public static boolean valid = true;

    //Begin Thread work
    public static class RowObject{
        int row;
        RowObject(int row){
            this.row = row;
        }
    }

    public static class ColumnObject{
        int columnVal;
        ColumnObject(int columnVal){
            this.columnVal = columnVal;
        }
    }

    public static class GridObject{
        int row;
        int column;
        GridObject(int row, int column){
            this.row = row;
            this.column = column;
        }
    }

    //Thread checks rows for duplicate valies
    public static class RowValidate extends RowObject implements Runnable{
        RowValidate(int row){
            super(row);
        }

        //Run code logic for Row Validation
        @Override
        public void run(){
            int i = row;
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;
            int num6 = 0;
            int num7 = 0;
            int num8 = 0;
            int num9 = 0;
            int num5 = 0;
            boolean rowValid = true;
            // System.out.printf("RowValidate thread started! row: %d\n", i);
            for(int j = 0; j < 9; j++){
                if(solution[i][j] == 1){
                    num1++;
                }
                if(solution[i][j] == 2){
                    num2++;
                }
                if(solution[i][j] == 3){
                    num3++;
                }
                if(solution[i][j] == 4){
                    num4++;
                }
                if(solution[i][j] == 5){
                    num5++;
                }
                if(solution[i][j] == 6){
                    num6++;
                }
                if(solution[i][j] == 7){
                    num7++;
                }
                if(solution[i][j] == 8){
                    num8++;
                }
                if(solution[i][j] == 9){
                    num9++;
                }
            }
            //Tests frequency array for duplicate values
            if(num1 > 1 || num2 > 1 || num3 > 1 || num4 > 1 || num5 > 1 || num6 > 1 || num7 > 1 || num8 > 1 || num9 > 1){
                valid = false;
                rowValid = false;
                int[] frequencies = new int[9];
                frequencies[0] = num1;
                frequencies[1] = num2;
                frequencies[2] = num3;
                frequencies[3] = num4;
                frequencies[4] = num5;
                frequencies[5] = num6;
                frequencies[6] = num7;
                frequencies[7] = num8;
                frequencies[8] = num9;
            }
            if(rowValid == false){
                System.out.printf("Row is not valid. Issue on Row: %d\n", i);
                return;
            }
            else{
                // System.out.printf("Row %d is valid.\n", i);
                return;
            }
        }
    }

    //Run logic for Column Validation
    public static class ColumnValidate extends ColumnObject implements Runnable{
        ColumnValidate(int columnVal){
            super(columnVal);
        }

        //Run logic for Column Validation
        @Override
        public void run(){
            int j = columnVal;
            int i = 0;
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;
            int num6 = 0;
            int num7 = 0;
            int num8 = 0;
            int num9 = 0;
            int num5 = 0;
            boolean columnValid = true;
            // System.out.printf("ColumnValidate thread started! Column: %d\n", j);
            for(i = 0; i < 9; i++){
                if(solution[i][j] == 1){
                    num1++;
                }
                if(solution[i][j] == 2){
                    num2++;
                }
                if(solution[i][j] == 3){
                    num3++;
                }
                if(solution[i][j] == 4){
                    num4++;
                }
                if(solution[i][j] == 5){
                    num5++;
                }
                if(solution[i][j] == 6){
                    num6++;
                }
                if(solution[i][j] == 7){
                    num7++;
                }
                if(solution[i][j] == 8){
                    num8++;
                }
                if(solution[i][j] == 9){
                    num9++;
                }
            }
            //Tests frequency array for duplicate values
            if(num1 > 1 || num2 > 1 || num3 > 1 || num4 > 1 || num5 > 1 || num6 > 1 || num7 > 1 || num8 > 1 || num9 > 1){
                valid = false;
                columnValid = false;
                int[] frequencies = new int[9];
                frequencies[0] = num1;
                frequencies[1] = num2;
                frequencies[2] = num3;
                frequencies[3] = num4;
                frequencies[4] = num5;
                frequencies[5] = num6;
                frequencies[6] = num7;
                frequencies[7] = num8;
                frequencies[8] = num9;
            }
            if(columnValid == false){
                System.out.printf("Column is not valid. Issue on Column: %d\n", j);
                return;
            }
            else{
                // System.out.printf("Column %d is valid.\n", j);
                return;
            }
        }
    }

    //Checks 3x3 grids for duplicate valies
    public static class GridValidate extends GridObject implements Runnable{
        GridValidate(int rowVal, int columnVal){
            super(rowVal, columnVal);
        }

        //Run logic for Grid Validation
        @Override
        public void run(){
            int i = row;
            int j = column;
            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;
            int num6 = 0;
            int num7 = 0;
            int num8 = 0;
            int num9 = 0;
            int num5 = 0;
            boolean gridValid = true;
            // System.out.printf("ColumnValidate thread started! Row: %d Column: %d \n", i, j);
            for(i = row; i <= row+2; i++){
                for(j = column; j <= column+2; j++){
                    if(solution[i][j] == 1){
                        num1++;
                    } 
                    if(solution[i][j] == 2){
                        num2++;
                    }
                    if(solution[i][j] == 3){
                        num3++;
                    }
                    if(solution[i][j] == 4){
                        num4++;
                    }
                    if(solution[i][j] == 5){
                        num5++;
                    }
                    if(solution[i][j] == 6){
                        num6++;
                    }
                    if(solution[i][j] == 7){
                        num7++;
                    }
                    if(solution[i][j] == 8){
                        num8++;
                    }
                    if(solution[i][j] == 9){
                        num9++;
                    }
                }
            }
            if(num1 > 1 || num2 > 1 || num3 > 1 || num4 > 1 || num5 > 1 || num6 > 1 || num7 > 1 || num8 > 1 || num9 > 1){
                valid = false;
                gridValid = false;
                int[] frequencies = new int[9];
                frequencies[0] = num1;
                frequencies[1] = num2;
                frequencies[2] = num3;
                frequencies[3] = num4;
                frequencies[4] = num5;
                frequencies[5] = num6;
                frequencies[6] = num7;
                frequencies[7] = num8;
                frequencies[8] = num9;
            }
            if(gridValid == false){
                System.out.printf("Grid starting at index: [%d][%d] is not valid.\n", i, j);
                return;
            }
            else{
                // System.out.printf("Grid at index [%d][%d] is valid.\n", i, j);
                return;
            }
        }

    }
    //END Thread logic

    //MAIN Class
    public static void main(String[] args) throws FileNotFoundException
    {
        //Prompts users for file name and scans input file into 2D array
        System.out.printf("Provide input file name:");
        Scanner scn = new Scanner(System.in);
        String inputFileName = scn.nextLine();
        Scanner scan = new Scanner(new File(inputFileName));
        int i, j = 0;
        for(i = 0; i < 9; i++){
            for(j = 0; j < 9; j++){
                solution[i][j] = scan.nextInt();
            }
        }
        
        //Prints input solution to console
        System.out.printf("Input Solution:\n");
        for(i = 0; i < 9; i++){
            for(j = 0; j < 9; j++){
                System.out.printf("%s ", solution[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        //THREAD Logic in main
        //Creating and starting threads
        int threadIndex = 0;
        Thread[] threads = new Thread[27];

        //Creates RowValidate Threads
        for(i = 0; i < 9; i++){
            threads[i] = new Thread(new RowValidate(i));
        }

        //Creates ColumnValidate Threads
        j = 0;
        for(i = 9; i < 18; i++){
            threads[i] = new Thread(new ColumnValidate(j++));
        }

        //Creates GridValidate Threads
        int rowIndex = 0;
        int columnIndex = 0;
        int threadArrayIndex = 18;
        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                // System.out.printf("Calling threads[%d] GridValidate(%d, %d)\n", threadArrayIndex, rowIndex, columnIndex);
                threads[threadArrayIndex] = new Thread(new GridValidate(rowIndex, columnIndex));
                columnIndex = columnIndex + 3;
                threadArrayIndex++;
            }
            rowIndex = rowIndex + 3;
            columnIndex = 0;
        }

        //Starts all threads
        for(i = 0; i < 27; i++){
            threads[i].start();
        }

        //Joins all threads to force everything else to wait for thread completion
        for(i = 0; i < 27; i++){
            try{
                threads[i].join();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        //END THREAD logic in main

        //Prints weather the solution is valid or not to the console.
        if(valid == false){
            System.out.printf("\nSOLUTION IS NOT VALID.\n");
        }
        else{
            System.out.printf("\nSOLUTION IS VALID!\n");
        }
    }
}