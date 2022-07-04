/*
 * Information from https://www.programiz.com/dsa/graph-adjacency-matrix, W2022-CPSC319-LectureNotes by Leonard Manzara, Xi Wang's Tutorial Session
 * and the Mark Allen Weiss - Data Structures and Algorithm Analysis in Java - 3rd Edition (2012) textbook
 * was used for assistance in the implementation of this class. 
 */

import java.util.Arrays;

public class Graph{


	private int[][] adjacenyMatrix;
	private int[] vertices;
	
	/*
	 * Constructor
	 */
	public Graph(int v) {

		this.vertices = new int[v];
		for(int i = 0; i < v; i++) {
			vertices[i] = i;
		}
		this.adjacenyMatrix = new int[v][v];
		for(int[] row : this.adjacenyMatrix) {
			Arrays.fill(row, 0);
		}
	}
	
	/**
	 * Adds an edge in the graph from the source vertex to destination vertex
	 * @param source
	 * @param destination
	 */
	public void addEdge(int source, int destination, int value) {
		
		this.adjacenyMatrix[source][destination] = value;
	}
	
	/**
	 * Gets the vertices array.
	 * @return int[]
	 */
	public int[] getVertices() {
		return this.vertices;
	}
	
	/**
	 * Gets the directed graph adjacency matrix.
	 * @return int[][]
	 */
	public int[][] getAdjMatrix(){
		return this.adjacenyMatrix;
	}
}

