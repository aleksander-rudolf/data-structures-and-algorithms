/*
 * Information from https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/, W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 * Modified by ALeksander Rudolf.
 */

public class BinaryTree {

	private Node root;
	private int size;
	
	/*
	 * Constructor
	 */
	public BinaryTree() {
		this.root = null;
	}
	
	/**
	 * Insert a new node into its proper position of the binary search tree.
	 * @param studentData
	 */
	public void insert(String studentData) {
		// Assumes root is an instance variable
		Node newNode = new Node(studentData);
		Node current = root;
		Node parent = null;  

		//Determines which sub-tree to insert into.
		while (current != null) {
			parent = current;
			if (studentData.substring(7,32).toLowerCase().compareTo(current.data.substring(7,32).toLowerCase()) > 0 ) {
				current = current.right;
			}
			else {
				current = current.left;
			}
		}
	
		//If the tree is empty, the insert the new node as the root.
		if (root == null) {
			root = newNode;
		}
		
		//If the new node is greater than its parent, insert to the parents right child.
		else if (studentData.substring(7,32).toLowerCase().compareTo(parent.data.substring(7,32).toLowerCase()) > 0) {
			parent.right = newNode;
			newNode.parent = parent;
		}
		
		//If the new node is less than or equal to its parent, insert to the parents left child.
		else {
			parent.left = newNode;
			newNode.parent = parent;
		}
		
		this.size++;
	}
	
	/**
	 * This method calls deleteRec()
	 * @param studentData
	 */
    public void delete(String studentData) { 
    	this.root = deleteData(this.root, studentData);
    	this.size--;
    }
 
    /* A recursive function to
     * delete an existing key in BST
     */
    /**
     * Recursive function to delete an existing node in the binary search tree.
     * @param root
     * @param studentData
     * @return Node
     */
    public Node deleteData(Node root, String studentData) {
    	
        //Base Case: If the tree is empty
        if (root == null)
            return root;
 
        //Otherwise, recur down the tree
        if (studentData.substring(7,32).toLowerCase().compareTo(root.data.substring(7,32).toLowerCase()) < 0)
            root.left = deleteData(root.left, studentData);
        else if (studentData.substring(7,32).toLowerCase().compareTo(root.data.substring(7,32).toLowerCase()) > 0)
            root.right = deleteData(root.right, studentData);
 
        //If key is same as the root's key, then This is the node to be deleted
        else {
        	
            //Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            //Node with two children: Get the inOrder successor (smallest in the right subtree)
            root.data = minValue(root.right);
 
            //Delete the inOrder successor
            root.right = deleteData(root.right, root.data);
        }
 
        return root;
    }
 
    /**
     * Determines the minimum value in the binary search tree.
     * @param root
     * @return String
     */
    public String minValue(Node root) {
        String minV = root.data;
        while (root.left != null)
        {
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }
    
    /**
     * Gets the root of the binary search tree.
     * @return Node
     */
    public Node getRoot() {
    	return this.root;
    }
    
    /**
     * Gets the size of the binary search tree.
     * @return int
     */
    public int getSize() {
    	return this.size;
    }
}
