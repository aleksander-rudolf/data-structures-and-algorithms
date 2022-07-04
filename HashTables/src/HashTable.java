/*
 * Information from https://www.cpp.edu/~ftang/courses/CS240/lectures/hashing.htm, W2022-CPSC319-LectureNotes by Leonard Manzara, Xi Wang's Tutorial Session
 * and the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

public class HashTable {

	private double numOfRecords;
	private int capacity;
	private String[] table;
	private double reads;
	private int maxChain;
	private String probingFlag;
	
	/**
	 * Constructor
	 * @param tableSize
	 * @param flag
	 */
	public HashTable(int tableSize, String flag) {
		this.numOfRecords = tableSize;
		this.capacity = nextPrime((int)Math.round(tableSize*1.42));
		this.table = new String[this.capacity];
		this.reads = 0;
		this.maxChain = 0;
		this.probingFlag = flag;
	}
	
	/**
	 * Hashing algorithm using bit-manipulation.
	 * @param key
	 * @return
	 */
	public int hash(String key) {
		int address = 17;
		for(int i = 0; i < key.length(); i++) {
			address = (address << 3) | (address >>> 27);
			address += (int)key.charAt(i);
		}
		return Math.abs((address*31)%this.capacity);
	}
	
	/**
	 * Linear probing collision resolution to find index in the table.
	 * @param key
	 * @return
	 */
	private int findPosLinearProbing(String key) {
		int index = hash(key);
		int chainCount = 0;
		
		for(int i = 0; i < this.table.length; i++) {
			if(this.table[index] == null || this.table[index].equals(key)) {
				this.reads++;
				chainCount++;
				if(chainCount > this.maxChain) {
					this.maxChain = chainCount;
				}
				return index;
			}
			else {
				index = (index + 1)%this.capacity;
				this.reads++;
				chainCount++;
			}
		}
		return index;
	}
	
	/**
	 * Quadratic probing collision resolution to find index in the table.
	 * @param key
	 * @return
	 */
	private int findPosQuadraticProbing(String key) {
		int index = hash(key);
		int chainCount = 0;
		
		for(int i = 1; i < this.table.length; i++) {
			if(this.table[index] == null || this.table[index].equals(key)) {
				this.reads++;
				chainCount++;
				if(chainCount > this.maxChain) {
					this.maxChain = chainCount;
				}
				return index;
			}
			else {
				index = (index + i*i)%this.capacity;
				this.reads++;
				chainCount++;
			}
		}
		return index;
	}
	
	/**
	 * Inserts a hashed key into the table.
	 * @param key
	 */
	public void insert(String key) {
		if(this.probingFlag.equals("-q")) {
			int currDist = findPosQuadraticProbing(key);
			this.table[currDist] = key;
		}
		else {
			int currDist = findPosLinearProbing(key);
			this.table[currDist] = key;
		}
	}
	
	/**
	 * Searches for a hashed key in the table.
	 * @param key
	 */
	public void search(String key) {
		if(this.probingFlag.equals("-q")) {
			findPosQuadraticProbing(key);
		}
		else {
			findPosLinearProbing(key);
		}
	}
	
	/**
	 * Calculates the statistics of the hashing algorithm.
	 * @return
	 */
	public String hashAnalysis() {
		StringBuilder output = new StringBuilder();
		double loadFactor = this.numOfRecords/this.capacity;
		double avgNumOfReads = this.reads/this.numOfRecords;
		double hashEfficiency = loadFactor/avgNumOfReads;
		output.append("Average Number of Reads per Record: " + avgNumOfReads + "\n"
						+ "Load Factor: " + loadFactor + "\n"
						+ "Hashing Efficiency: " + hashEfficiency*100 + "%\n"
						+ "Size of the Longest Chain: " + this.maxChain);
		return output.toString();
	}
	
	/**
	 * Helper method to find the next prime number.
	 * @param num
	 * @return
	 */
	public int nextPrime(int num) {
		while(!isPrime(num)) {
			num++;
		}
		return num;
	}
	
	/**
	 * Finds the next prime number.
	 * @param num
	 * @return
	 */
	public boolean isPrime(int num) {
		if(num <= 1) {
			return false;
		}
		
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Sets the reads and maxChain to the value 0.
	 */
	public void resetReads() {
		this.reads = 0;
		this.maxChain = 0;
	}
}