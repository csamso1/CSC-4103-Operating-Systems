Clayton Samson
CS410385
csamso1@lsu.edu

This is a multithreaded java program to check if a provided Sudoku solution is valid.


To compile and execute this java program use the following console commands:

javac SudokuSolutionChecker.java
java SudokuSolutionChecker

The program will prompt you for an input file name, please provide an input file name like the examples below:

input.txt
badInput.txt

The program will then check the provided solution's validity, the program will print to the console when it finds an issue with a row, column, or 3x3 grid.  After the evaulation is complete the program prints the solutions validity to the console.


The input file should contain only the input valies in a 9x9 grid like the examples below, and sample input files contained in this submission:

//Sample valid input file
5 7 8 9 1 3 6 4 2
1 6 9 2 7 4 3 5 8
3 2 4 8 6 5 9 1 7
9 5 6 4 2 7 8 3 1
4 8 1 3 9 6 7 2 5
7 3 2 5 8 1 4 9 6
6 9 5 7 3 2 1 8 4
2 1 3 6 4 8 5 7 9
8 4 7 1 5 9 2 6 3

//Sample invalid input file
5 7 8 9 1 3 6 4 2
1 6 9 2 7 4 3 5 8
3 2 4 8 6 5 9 1 7
9 5 6 4 2 7 8 3 1
4 8 3 3 9 6 7 2 5
7 3 2 5 8 1 4 9 6
6 9 5 7 3 2 1 8 4
2 1 3 6 4 8 5 7 9
8 4 7 1 5 9 2 6 3