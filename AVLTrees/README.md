# AVLTrees

Build an AVL tree using the data from the input file. The program should do the appropriate rotations when inserting data into the tree. Only insertions into the tree need to be handled (i.e., use an input file that specifies only insertions, and no deletions). The tree should be ordered by student 
last name (use a case-insensitive comparison). There are only unique records in the input file. Each node must contain the student data (exclude the operation code), 
a left child pointer, and a right child pointer. A parent pointer is optional, but might prove useful for some operations.

Traverse the binary search tree recursively, printing out the nodes in ascending logical order; i.e. do a depth-first, in-order tree traversal. Print the node data 
to a text file.

Traverse the binary search tree, starting at the top level (the root node), proceeding downwards level-by-level. At each level print out the nodes from left to right.
In other words, do a breadth-first traversal. You may have to use a queue to implement this. Print the node data to a text file.

## How to use the AVLTrees Java Program

1. Compile the program:
	- In command-line, navigate to the directory containing the following source code files;
	  (AppDriver.java, Utility.java, AVLTree.java, Node.java, Queue.java) 
	  
	- In the command-line, execute the following command: javac *.java
	
2. Run the program:
	- In command-line, execute the following command (specify the input/output file names): java AppDriver inputFileName outputFileName1 outputFileName2
