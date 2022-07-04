/*
 * Information from https://www.programiz.com/dsa/graph-bfs, https://www.programiz.com/dsa/graph-dfs,
 * W2022-CPSC319-LectureNotes by Leonard Manzara and 
 * the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

import java.io.*;
import java.util.*;

public class Utility {

	private String inputFile = new String();
	private String queryFile = new String();
	private String outputFile1 = new String();
	private String outputFile2 = new String();
	private Graph graph = null;
	private int[] query;
	
	/**
	 * Constructor
	 * @param inputFile
	 * @param queryFile
	 * @param outputFile1
	 * @param outputFile2
	 */
	public Utility(String inputFile, String queryFile, String outputFile1, String outputFile2) {
		this.inputFile = inputFile;
		this.queryFile = queryFile;
		this.outputFile1 = outputFile1;
		this.outputFile2 = outputFile2;
		
		try {
			BufferedReader intputRowReader = new BufferedReader(new FileReader(this.inputFile + ".txt"));
			int lines = 0;
			while(intputRowReader.readLine() != null) {
				lines++;
			}
			this.graph = new Graph(lines);
			intputRowReader.close();
			
			BufferedReader queryRowReader = new BufferedReader(new FileReader(this.queryFile + ".txt"));
			lines = 0;
			while(queryRowReader.readLine() != null) {
				lines++;
			}
			this.query = new int[lines*2];
			queryRowReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Read data from the input file and populate the adjacency matrix of the graph object.
	 */
	public void readData() {
		try {
			int rows = this.graph.getVertices().length;
			int cols = this.graph.getVertices().length;
			Scanner inputScanner = new Scanner(new File(this.inputFile + ".txt"));
			int nextInt = 0;
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					if(inputScanner.hasNextInt()) {
						nextInt = inputScanner.nextInt();
						if(nextInt != 0) {
							this.graph.addEdge(i, j, nextInt);
						}
					}
				}
			}
			inputScanner.close();
			
			Scanner queryScanner = new Scanner(new File(this.queryFile + ".txt"));
			
			for(int i = 0; i < this.query.length; i++) {
				if(queryScanner.hasNextInt()) {
					this.query[i] = queryScanner.nextInt();
				}
			}
			queryScanner.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Write the final binary search tree into an output file.
	 * @param data
	 * @param outputFile
	 */
	public void writeToFile(String data, String outputFile) {
		
		try {
			FileWriter writer = new FileWriter(outputFile + ".txt", true);
			writer.write(data + "\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Helper  method for the Depth-First Traversal that determines the path between two nodes.
	 */
	public void depthFirstPath() {
		
		int i = 0;
		while(i < this.query.length) {
			Stack path = new Stack();
			StringBuilder output = new StringBuilder();
			boolean[] visited = new boolean[this.graph.getVertices().length];
			int start = this.query[i++];
			int end = this.query[i++];
			DFP(start, end, this.graph.getVertices(), visited, path);
			if(!visited[end]) {
				writeToFile((start + ", -1, " + end), this.outputFile1);
			}
			else {
				output.insert(0, path.pop());
				while(!path.isEmpty()) {
					output.insert(0, path.pop() + ", ");
				}
				writeToFile(output.toString(), this.outputFile1);
			}
		}
	}
	
	/**
	 * Uses the Depth-First Traversal to determine the direct path between two vertices.
	 * @param start
	 * @param end
	 * @param vertices
	 * @param visited
	 * @param path
	 * @return boolean
	 */
	public boolean DFP(int start, int end, int[] vertices, boolean[] visited, Stack path) {
		
		if(start == end) {
			path.push(vertices[end]);
			visited[end] = true;
			return true;
		}

		path.push(vertices[start]);
		visited[start] = true;
		
		for(int i = 0; i < vertices.length; i++) {
			if(this.graph.getAdjMatrix()[start][i] == 1) {
				if(!visited[i]) {
					if(DFP(i, end, vertices, visited, path)) {
						return true;
					}
				}
			} 
		}
		path.pop();
		return false;
	}
	
	/*
	 * Helper  method for the Breadth-First Traversal that determines the path between two nodes.
	 */
	public void breadthFirstPath() {

		int i = 0;
		while(i < this.query.length) {
			StringBuilder output = new StringBuilder();
			int[] pred = new int[this.graph.getVertices().length];
			Arrays.fill(pred, -1);
			boolean[] visited = new boolean[this.graph.getVertices().length];
			int start = this.query[i++];
			int end = this.query[i++];
			BFP(start, end, this.graph.getVertices(), visited, pred);
			if(!visited[end]) {
				output.append(start + ", -1, " + end);
			}
			else {
				int j = end;
				while(j != start) {
					if(pred[j] != -1) {
						if(j == end) {
							output.insert(0, j);
						}
						else {
							output.insert(0, j + ", ");
						}
						j = pred[j];
						if(j == start) {
							output.insert(0, j + ", ");
						}
					}
				}
			}
			writeToFile(output.toString(), this.outputFile2);
		}
	}
	
	/**
	 * Uses the Breadth-First Traversal to determine the direct path between two vertices.
	 * @param start
	 * @param end
	 * @param vertices
	 * @param visited
	 * @param pred
	 */
	public void BFP(int start, int end, int[] vertices, boolean[] visited, int[] pred) {
		
	    // Create a queue for BFS
	    Queue queue = new Queue(vertices.length);
	 
	    // Mark the current node as visited and enqueue it
	    visited[start]=true;
	    queue.enqueue(vertices[start]);
	    int p = 0;
	    while (!queue.isEmpty()) {
	    	
	    	// Dequeue a vertex from queue and print it
	    	p = queue.dequeue();

	        for(int i = 0; i < vertices.length; i++) {
	        	if(this.graph.getAdjMatrix()[p][i] == 1 && !visited[i]) {
	        		queue.enqueue(i);
	        		visited[i] = true;
	        		if(pred[i] == -1) {
	        			pred[i] = p;
	        		}
	        	}
	        }
	    }
	}
	
	/**
	 * Gets the Graph.
	 * @return Graph
	 */
	public Graph getGraph() {
		return this.graph;
	}
}
