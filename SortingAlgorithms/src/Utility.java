import java.util.*;
import java.io.*;

public class Utility {

	private String order = new String();
	private int size = 0;
	private String algorithm = new String();
	private static String outputFile = new String();
	
	private Random random = new Random();
	private int[] array;

	/**
	 * Overload constructor w/ 4 arguments that instantiates Utility object 
	 * and sets instance variables based on the command line arguments provided.
	 * @param order
	 * @param size
	 * @param algorithm
	 * @param outputFile
	 */
	public Utility(String order, int size, String algorithm, String outputFile) {
		
		this.order = order;
		this.size = size;
		this.algorithm = algorithm;
		this.outputFile = outputFile;
	}
	
	/**
	 * Overload constructor w/ 2 arguments that instantiates Utility object and sets
	 * order and size instance variables.
	 * @param order
	 * @param size
	 */
	public Utility(String order, int size) {
		
		this.order = order;
		this.size = size;
	}
	
	/*
	 * Fill the instance array based on the instances order and size.
	 */
	public void fillArray() {

		if(this.order.compareTo("ascending") == 0) {
			
			this.array = random.ints().distinct().limit(this.size).sorted().toArray();
		}
		
		else if(this.order.compareTo("descending") == 0) {
			
			this.array = random.ints().distinct().limit(this.size).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
		}
		
		else {
			
			this.array = random.ints().distinct().limit(this.size).toArray();
		}
	}
	
	public void setOrder(String order) {
		
		this.order = order;
	}
	
	public void setSize(int size) {
		
		this.size = size;
	}
	
	public int[] getArray() {
		
		return this.array;
	}
	
	public int[] getTmpArray() {
		
		int[] tmpArray = new int[this.size];
		
		return tmpArray;
	}
	
	public String getOrder() {
		
		return this.order;
	}
	
	public String getAlgorithm() {
		
		return this.algorithm;
	}
	
	//Write the instance array to an output file.
	public void writeToFile() {
		
		try {
			FileWriter writer = new FileWriter(outputFile + ".txt");
			for(int i: this.array) {
				writer.write(Integer.toString(i)+ "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}