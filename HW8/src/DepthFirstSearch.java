import java.util.*;
import java.io.*;

/**
 * Class to implement the depth-first search algorithm
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class DepthFirstSearch {
	//Data Fields
	/**
	 * A reference to the graph being searched
	 */
	private Graph graph;
	/**
	 * Array of parents in the depth-first search tree
	 */
	private int[] parent;
	/**
	 * Flag to indicate whether this vertex has been visited
	 */
	private boolean[] visited;
	/**
	 * The array that contains each vertex in discovery order
	 */
	private int[] discoveryOrder;
	/**
	 * The array that contains each vertex in finish order
	 */
	private int[] finishOrder;
	/**
	 * The index that indicates the discovery order
	 */
	private int discoverIndex = 0;
	/**
	 * The index that indicates the finish order
	 */
	private int finishIndex = 0;
	
	//Constructors
	/**
	 * Construct the depth-first search of a Graph
	 * starting at vertex 0 and visiting the start vertices in ascending order
	 * @param graph The graph
	 */
	public DepthFirstSearch(Graph graph){
		this.graph = graph;
		int n = graph.getNumV();
		parent = new int[n];
		visited = new boolean[n];
		discoveryOrder = new int[n];
		finishOrder = new int[n];
		for(int i = 0; i < n; i++){
			parent[i] = -1; //Declare array parent and initialize its elements to -1
		}
		
		for(int i = 0; i < n; i++){
			if(!visited[i])
				depthFirstSearch(i);
		}
	}
	
	/**
	 * Constructs the depth-first search of the specified graph,
	 * selecting the start vertices in the specified order.
	 * The first vertex visited is order[0]
	 * @param graph The graph
	 * @param order The array giving the order in which the start vertices should be selected
	 */
	public DepthFirstSearch(Graph graph, int[] order){
		this.graph = graph;
		int n = graph.getNumV();
		parent = new int[n];
		visited = new boolean[n];
		discoveryOrder = new int[n];
		finishOrder = new int[n];
		for(int i = 0; i < n; i++){
			parent[i] = -1; //Declare array parent and initialize its elements to -1
		}	
		for(int i = 0; i < n; i++){
			if(!visited[order[i]])
				depthFirstSearch(order[i]);
		}
	}

	/**
	 * Recursively depth-first search the graph starting at vertex current
	 * @param current The start vertex
	 */
	public void depthFirstSearch(int current) {
		/* Mark the current vertex visited */
		visited[current] = true;
		discoveryOrder[discoverIndex++] = current;
		/* Examine each vertex adjacent to the current vertex */
		Iterator<Edge> itr = graph.edgeIterator(current);
		ArrayList<Edge> al = new ArrayList<>();
		
		while(itr.hasNext())
		{
			al.add(itr.next());
		}

		al.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				
				return o1.getWeight() > o2.getWeight() ? 1 : -1;
			}	
		});

		Iterator<Edge> itrInt = al.iterator();

		while(itrInt.hasNext()){
			int neighbor = itrInt.next().getDest();
			/* Process a neighbor that has not been visited */
			if(!visited[neighbor]){
				/* Insert (current, neighbor) into the depth-first search tree */
				parent[neighbor] = current;
				/* Recursively apply the algorithm starting at neighbor */
				depthFirstSearch(neighbor);
			}
		}
		/* Mark current index finished */
		finishOrder[finishIndex++] = current;
	}
	
	public int[] getDiscoveryOrder() {
		return discoveryOrder;
	}

	public int[] getFinishOrder() {
		return finishOrder;
	}

	public Graph getGraph() {
		return graph;
	}

	public int[] getParent() {
		return parent;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public int getDiscoverIndex() {
		return discoverIndex;
	}

	public int getFinishIndex() {
		return finishIndex;
	}

	
	
}
