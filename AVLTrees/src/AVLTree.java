/*
 * Information from https://www.geeksforgeeks.org/avl-tree-set-1-insertion/, W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

public class AVLTree {
	
    Node root;
    private int size;
    
    /**
     * Right rotate the subtree rooted with y
     * @param y
     * @return Node
     */
    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
 
        //Perform rotation
        x.right = y;
        y.left = T2;
 
        //Update heights
        y.height = getMax(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = getMax(getHeight(x.left), getHeight(x.right)) + 1;
 
        //Return new root
        return x;
    }
 
    /**
     * Left rotate subtree rooted with x.
     * @param x
     * @return Node
     */
    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
 
        //Perform rotation
        y.left = x;
        x.right = T2;
 
        //Update heights
        x.height = getMax(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = getMax(getHeight(y.left), getHeight(y.right)) + 1;
 
        //Return new root
        return y;
    }
 
    /**
     * 
     * @param node
     * @param data
     * @return Node
     */
    public Node insert(Node node, String data) {
 
    	size++;
        //Perform the normal binary search tree insertion
        if (node == null) {
            return (new Node(data));
        }
 
        if (data.substring(7,32).toLowerCase().compareTo(node.data.substring(7,32).toLowerCase()) < 0) {
            node.left = insert(node.left, data);
        }
        else if (data.substring(7,32).toLowerCase().compareTo(node.data.substring(7,32).toLowerCase()) > 0) {
            node.right = insert(node.right, data);
        }
        else { //Duplicate data not allowed
            return node;
        }
 
        //Update height of this ancestor node
        node.height = 1 + getMax(getHeight(node.left), getHeight(node.right));
 
        // Get the balance factor of this ancestor node to check whether this node became unbalanced
        int balance = getBalance(node);
 
        //If this node becomes unbalanced, then there are 4 cases
        if(balance > 1) {
        	//Left left case
            if (data.substring(7,32).toLowerCase().compareTo(node.left.data.substring(7,32).toLowerCase()) < 0) {
                return rightRotate(node);
            }
            //Left right case
            else if(data.substring(7,32).toLowerCase().compareTo(node.left.data.substring(7,32).toLowerCase()) > 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        
        if(balance < -1) {
        	//Right right case
            if (data.substring(7,32).toLowerCase().compareTo(node.right.data.substring(7,32).toLowerCase()) > 0) {
                return leftRotate(node);
            }
            //Right left case
            else if(data.substring(7,32).toLowerCase().compareTo(node.right.data.substring(7,32).toLowerCase()) < 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
 
        //Return the (unchanged) node pointer
        return node;
    }
    
    /**
     * Gets the Balance factor of Node N
     * @param N
     * @return int
     */
    public int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return getHeight(N.left) - getHeight(N.right);
    }
    
    /**
     * Gets the height of Node N
     * @param N
     * @return int
     */
    public int getHeight(Node N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
 
    /**
     * Gets the maximum of two integers.
     * @param a
     * @param b
     * @return int
     */
    public int getMax(int a, int b) {
    	if(a > b) {
    		return a;
    	}
    	else {
    		return b;
    	}
    }
    
    /**
     * Gets the size of the AVL Tree.
     * @return int
     */
    public int getSize() {
    	return this.size;
    }
    
    /**
     * Gets the root of the AVL Tree.
     * @return Node
     */
    public Node getRoot() {
    	return this.root;
    }
}
