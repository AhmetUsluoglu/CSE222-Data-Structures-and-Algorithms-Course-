import java.util.*;


/**
 * MyGraph class. A graph is a set of vertices
 * and a set of edges. Vertices are represented by integers from 0 to n - 1.
 * Edges are ordered pairs of vertices.
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class MyGraph implements DynamicGraph {
	
	//Data Fields
	
	/**
	 * Number of vertices
	 */
	private int numV;
	/**
	 * Flag to indicate whether this is a directed graph
	 */
	private boolean directed;

	private HashMap<Integer, Vertex> vertices;

	private int vertexCount = 0;

	
	//Constructor
	
	/**
	 * Construct a graph with the specified number of vertices. 
	 * The boolean directed indicates whether or not this is a directed graph
	 * @param numV The number of vertices
	 * @param directed The directed flag
	 */
	protected MyGraph(int numV, boolean directed){
		this.numV = numV;
		this.directed = directed;
		vertices = new HashMap<>(numV);

		for(int i = 0; i < numV; ++i)
			addVertex(new Vertex(vertexCount++));
	}	

	/**
	 * This is a constructor for the MyGraph class. It is used to create a new instance of the MyGraph
	// class. */ 
	protected MyGraph(boolean directed){
		this.numV = 0;
		this.directed = directed;
		vertices = new HashMap<>();
	}
	
	
	//Methods

	/**
	 * Given an id, return the vertex with that id.
	 * 
	 * @param id The id of the vertex to get.
	 * @return A vertex object
	 */
	public Vertex getVertex(int id)
	{
		return vertices.get(id);
	}

	/**
	 * > Returns the number of vertices in the graph
	 * 
	 * @return The number of vertices in the graph.
	 */
	public int getNumV() {
		return vertices.size();
	}

	/**
	 * > Returns true if the graph is directed, false otherwise
	 * 
	 * @return The boolean value of the directed variable.
	 */
	public boolean isDirected() {
		return directed;
	}

	/**
	 * It adds an edge to the graph.
	 * 
	 * @param newEdge The edge to be inserted into the graph.
	 */
	public void insert(Edge newEdge) {
		addEdge(newEdge.getSource(), newEdge.getDest(),newEdge.getWeight());
		// vertices.get(e.getSource()).edges.add(e);
	}

	/**
	 * If the source vertex has an edge to the destination vertex, return true.
	 * 
	 * @param source The source vertex.
	 * @param dest The destination vertex.
	 * @return A boolean value.
	 */
	public boolean isEdge(int source, int dest) {
		return vertices.get(source).edges.contains(getEdge(source, dest));
	}

	/**
	 * If there is an edge from source to dest, return it; otherwise, return a new edge with weight
	 * infinity.
	 * 
	 * @param source The source vertex of the edge.
	 * @param dest The destination vertex of the edge.
	 * @return The desired edge, or a dummy edge with a weight of infinity.
	 */
	public Edge getEdge(int source, int dest) {
		Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
		for(Edge edge : vertices.get(source).edges){
			if(edge.equals(target))
				return edge; //Desired edge found; return it
		}
		//Assert: All edges for source checked.
		return target; //Desired edge not found.
	}

	/**
	 * Return an iterator over the edges of the given source vertex.
	 * 
	 * @param source The source vertex.
	 * @return An iterator of the edges of the vertex at the given index.
	 */
	public Iterator<Edge> edgeIterator(int source) {
		return vertices.get(source).edges.iterator();
	}

	/**
	 * For each vertex in the graph, print out the vertex's edges
	 * 
	 * @return A string representation of the graph.
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		int end = vertices.size();
		for(int i=0; i < end; i++){
			sb.append("Node " + i + "-->\n");
			for(Edge e : vertices.get(i).edges){
				sb.append("\tnode: " + e.getDest() + ", weight: " + e.getWeight() + "\n");
			}
		}
		return sb.toString();
	}

	/**
	 * > The function `newVertex` creates a new vertex with the given label and weight, and returns it
	 * 
	 * @param label The label of the vertex.
	 * @param weight The weight of the vertex.
	 * @return A new Vertex object with the label, weight, and vertexCount.
	 */
	@Override
	public Vertex newVertex (String label, double weight)
	{
		return new Vertex(label, weight, ++vertexCount);
	}
    
	/**
	 * * The function takes in a vertex and adds it to the graph
	 * 
	 * @param new_vertex The vertex to be added to the graph.
	 * @return The new vertex that was added to the graph.
	 */
	@Override
	public Vertex addVertex (Vertex new_vertex)
	{	
		numV++;
		vertices.put(new_vertex.ID, new_vertex);
		return new_vertex;
	}
    
	/**
	 * This function adds an edge between two vertices
	 * 
	 * @param vertexID1 The ID of the first vertex.
	 * @param vertexID2 The ID of the vertex that the edge is going to.
	 * @param weight The weight of the edge.
	 * @return A boolean value.
	 */
	@Override
	public boolean addEdge (int vertexID1, int vertexID2, double weight)
	{
		vertices.get(vertexID1).edges.add(new Edge(vertexID1, vertexID2, weight));
		
		if(!directed) 
				vertices.get(vertexID2).edges.add(new Edge(vertexID2, vertexID1, weight));
		return true;
	}
    
	/**
	 * > Removes the edge between the two vertices with the given IDs
	 * 
	 * @param vertexID1 The ID of the first vertex.
	 * @param vertexID2 The ID of the second vertex.
	 */
	@Override
	public void removeEdge (int vertexID1, int vertexID2)
	{
		vertices.get(vertexID1).edges.remove(getEdge(vertexID1, vertexID2));
		if(!directed) vertices.get(vertexID2).edges.remove(getEdge(vertexID2, vertexID1));
	}
    
	/**
	 * > Remove the vertex with the given ID from the graph, and remove all edges that connect to it
	 * 
	 * @param vertexID The ID of the vertex to be removed.
	 * @return The vertex that was removed.
	 */
	@Override
	public Vertex removeVertex (int vertexID)
	{
		Iterator<Map.Entry<Integer,Vertex>> hmIterator = vertices.entrySet().iterator();
		while(hmIterator.hasNext())
		{
			Vertex curVertex = hmIterator.next().getValue();
			curVertex.edges.remove(getEdge(curVertex.ID, vertexID));
		}
		return vertices.remove(vertexID);
	}
    /**
	 * Iterate through the vertices, and if the label matches, remove the vertex.
	 * 
	 * @param label The label of the vertex to be removed.
	 */
	
	@Override
	public void removeVertex (String label)
	{
		Iterator<Map.Entry<Integer,Vertex>> hmIterator = vertices.entrySet().iterator();
		while(hmIterator.hasNext())
		{
			Vertex curVertex = hmIterator.next().getValue();
			if(curVertex.label.equals(label)) removeVertex(curVertex.ID);
		}
	}
    
	/**
	 * *This function returns a subgraph of the current graph, where the subgraph contains only the
	 * vertices that have a property with the given key and value.*
	 * 
	 * The function takes in two parameters:
	 * 
	 * * `key`: the key of the property that we want to filter on
	 * * `filter`: the value of the property that we want to filter on
	 * 
	 * The function returns a subgraph of the current graph, where the subgraph contains only the vertices
	 * that have a property with the given key and value
	 * 
	 * @param key the key of the property
	 * @param filter the value of the property that you want to filter by
	 * @return A subgraph of the original graph, containing only the vertices that match the filter.
	 */
	@Override
	public MyGraph filterVertices (String key, String filter)
	{
		MyGraph subGraph = new MyGraph(false);
		Iterator<Map.Entry<Integer,Vertex>> hmIterator = vertices.entrySet().iterator();
		while(hmIterator.hasNext())
		{
			Vertex curVertex = hmIterator.next().getValue();
			if(curVertex.property.get(key) != null && curVertex.property.get(key).equals(filter))
				subGraph.addVertex(curVertex); 
		}
		return subGraph;
	}
    
	/**
	 * We iterate through the vertices, and for each vertex, we iterate through its edges, and for each
	 * edge, we set the corresponding element in the matrix to the weight of the edge
	 * 
	 * @return A 2D array of doubles.
	 */
	@Override
	public double[][] exportMatrix()
	{
		double[][] matrix = new double[numV][numV];
		Iterator<Map.Entry<Integer,Vertex>> hmIterator = vertices.entrySet().iterator();
		while(hmIterator.hasNext())
		{
			Vertex curVertex = hmIterator.next().getValue();
			for (var element : curVertex.edges) {
				matrix[element.getSource()][element.getDest()] = element.getWeight(); 
			}
		}
		return matrix;
	}

	/**
	 * It iterates through the vertices HashMap, and for each vertex, it iterates through its edges and
	 * prints them
	 */
	@Override
	public void printGraph()
	{
		System.out.print("Graph:\n");
		Iterator<Map.Entry<Integer,Vertex>> hmIterator = vertices.entrySet().iterator();
		while(hmIterator.hasNext())
		{
			Vertex curVertex = hmIterator.next().getValue();
			System.out.print(curVertex.ID + "=> ");
			for (var element : curVertex.edges) 
			{
				System.out.print("[ ("+ element.getSource()+" - "+element.getDest()+")  W: " + element.getWeight() +" ]  ");
			}
			System.out.println();
		}
	}

	/**
	 * It prints the matrix in a nice format
	 * 
	 * @param matrix The matrix to print
	 */
	public void printMatrix(double[][] matrix)
	{
		Iterator<Map.Entry<Integer,Vertex>> hmIterator = vertices.entrySet().iterator();
		Vertex curVertex = hmIterator.next().getValue();

		System.out.print("\n\n     ");
        for(int i = 0; i < getNumV(); i++)
        {
            System.out.print(curVertex.ID + "    ");
			if(hmIterator.hasNext()) curVertex = hmIterator.next().getValue();
        }
            
        System.out.print("\n\n");
		hmIterator = vertices.entrySet().iterator();
		curVertex = hmIterator.next().getValue();

		Vertex iV = null;
		Vertex jV = null;
		for(var i = vertices.entrySet().iterator(); i.hasNext(); )
        {
			iV = i.next().getValue();
            System.out.print(curVertex.ID + "   ");
			if(hmIterator.hasNext()) {curVertex = hmIterator.next().getValue();}

            for(var j = vertices.entrySet().iterator(); j.hasNext(); )
            {
				jV = j.next().getValue();
               if(matrix[iV.ID][jV.ID] == 0.0)
                    System.out.print(" -   ");
               else
                    System.out.print(matrix[iV.ID][jV.ID] + "  ");
            }
            System.out.print("\n\n");

        }
	}

	/**
	 * // Java
	 * public void addProperity(int id, String key, String value)
	 * 	{
	 * 		vertices.get(id).property.put(key, value);
	 * 	}
	 * 
	 * @param id the id of the vertex
	 * @param key the key of the property
	 * @param value the value of the property
	 */
	public void addProperity(int id, String key, String value)
	{
		vertices.get(id).property.put(key, value);
	}

	/** Dijkstra's Shortest-Path algorithm.
      @param graph The weighted graph to be searched
      @param start The start vertex
      @param pred Output array to contain the predecessors
                  in the shortest path
      @param dist Output array to contain the distance
                  in the shortest path
   */
   public static void dijkstrasAlgorithm(MyGraph graph, int start, int[] pred, double[] dist)
	{
		int numV = graph.getNumV();
		HashSet <Integer> vMinusS = new HashSet <Integer> (numV);
		
		// Initialize V S.
		for (int i = 0; i < numV; i++) 
		{
			if (i != start) 
			{
				vMinusS.add(i);
		  	}
		}
		
		// Initialize pred and dist.
		for (int v : vMinusS) 
		{
			pred[v] = start;
		  	dist[v] = graph.getEdge(start, v).getWeight();
		}
		
		// Main loop
		while (vMinusS.size() != 0) 
		{
			// Find the value u in V S with the smallest dist[u].
			double minDist = Double.POSITIVE_INFINITY;
			int u = -1;
			for (int v : vMinusS) 
			{
				if (dist[v] < minDist) 
				{
					minDist = dist[v];
					u = v;
				}
			}
			
			// Remove u from vMinusS.
			vMinusS.remove(u);
			
			// Update the distances.
			for (int v : vMinusS) 
			{
				if (graph.isEdge(u, v)) 
				{
					double weight = graph.getEdge(u, v).getWeight();
					String temp = graph.vertices.get(u).property.get("boosting");
					if (dist[u] + weight - Double.parseDouble(temp == null ? "0" : temp) < dist[v])
					{
						dist[v] = dist[u] + weight - Double.parseDouble(graph.vertices.get(u).property.get("boosting"));
						pred[v] = u;
					}
				}
			}
		}
	}

	/**
	 * The difference between the sum of the weights of the edges in the BFS tree and the sum of the
	 * weights of the edges in the DFS tree is the answer
	 * 
	 * @param graph The graph to be searched.
	 * @return The difference between the sum of the weights of the edges in the BFS tree and the sum of
	 * the weights of the edges in the DFS tree.
	 */
	public int findDifference(MyGraph graph)
	{
		int sum = 0;
        //Perform a depth-first search
		int[] parents = BreadthFirstSearch.breadthFirstSearch(graph, 0);
		System.out.println("Node and Parent in tree:");
		for(int i = 0; i < parents.length; i++){
			System.out.println(i + " " + parents[i]);
            if(i > 0) sum += graph.getEdge(parents[i], i).getWeight();
		}

		System.out.println("BFS Distance:" + sum);


		int n = graph.getNumV();
        //Perform a depth-first search
		//int[] testOrder = {1,1,1,1,1,1,1};
		DepthFirstSearch dfs = new DepthFirstSearch(graph);
		int[] dOrder = dfs.getDiscoveryOrder();
		int[] fOrder = dfs.getFinishOrder();
		
        System.out.println("Discovery and finish order:");
		for(int i = 0; i < n; i++)
        {
			System.out.println(dOrder[i] + " " + fOrder[i]);
		}
        int dis = 0;
        for(int i = n-1; i-1 >= 0; i--)
        {
            dis += graph.getEdge(fOrder[i], fOrder[i-1]).getWeight();
		}

			System.out.println("DFS Distance:" + dis);

		return dis > sum ? dis - sum : sum - dis;
	}
}
