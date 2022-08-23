import java.util.HashMap;

/**
 * It creates a graph, adds vertices and edges, and then prints the graph
 */
public class App {
    /**
     * It creates a graph with 5 vertices and no edges. Then it adds two vertices and an edge between
     * them. Then it creates a new graph with 5 vertices and no edges. Then it adds three edges to the
     * graph. Then it adds a vertex to the graph. Then it adds an edge to the graph. Then it removes
     * the edge from the graph. Then it removes the vertex from the graph. Then it removes another
     * vertex from the graph. Then it adds a vertex to the graph. Then it adds an edge to the graph.
     * Then it adds another edge to the graph. Then it adds a property to two vertices. Then it creates
     * a new graph with only the vertices that have the property. Then it creates a new graph with
     * three vertices and three edges. Then it runs Dijkstra's algorithm on the graph. Then it runs the
     * test3 function. Then it runs the test2 function. Then it runs the test22 function.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        MyGraph graph1 = new MyGraph(5, false);
        graph1.printGraph();
        Vertex v1 = new Vertex("label", 2.0, 5);
        Vertex v2 = new Vertex("label", 3.0, 6);
        graph1.addVertex(v1);
        graph1.addVertex(v2);
        graph1.addEdge(v1.ID, v2.ID, 4.0);

        graph1.printGraph();


        System.out.print("\n\n\n");

        MyGraph g = new MyGraph(5, false);
        g.printGraph();
        g.insert(new Edge(0, 1, 1));
        g.insert(new Edge(0, 2, 2));
        g.insert(new Edge(1, 2, 3));
        g.insert(new Edge(1, 3, 4));
        g.printGraph();
        g.addVertex(new Vertex(5));
        g.printGraph();
        g.addEdge(5, 4, 5);
        g.printGraph();
        g.removeEdge(5, 4);
        g.printGraph();
        g.removeVertex(5);
        g.printGraph();
        
        g.printMatrix(g.exportMatrix());


        g.removeVertex(3);
        g.printGraph();
        g.printMatrix(g.exportMatrix());


        g.addVertex(new Vertex(5));
        g.addEdge(5, 1, 2);

		System.out.println("Is there a edge between 5 to 2?\ng.isEdge(5, 2) = "+g.isEdge(5, 2));

        g.addEdge(5, 4, 5);
        g.printGraph();
        g.printMatrix(g.exportMatrix());


		System.out.println("Adding Key and Value properities to Vertexes 0 and 4\n");
        
        System.out.println(g.getVertex(0));
        g.addProperity(0, "key", "value");
        System.out.println(g.getVertex(0));

        System.out.println(g.getVertex(4));
        g.addProperity(4, "key", "value");
        System.out.println(g.getVertex(4));
        

		System.out.println("Printing The Subgraph with Key and Value properities.\n");

        MyGraph newG = g.filterVertices("key", "value");
        newG.printGraph();

        System.out.println("\n---------\n");


        MyGraph graph = new MyGraph(0, false);
        
        //arrays for predecessors and distances
        int[] pred = new int[3];
        double[] dist = new double[3];

        graph.addVertex(new Vertex( "A", "boosting", "2.0", 0));
        graph.addVertex(new Vertex( "B", "boosting", "3.0", 1));
        graph.addVertex(new Vertex( "C", "boosting", "0.0", 2));

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(1, 2, 6);

        
		//Execute Dijkstra's algorithm on the graph
        MyGraph.dijkstrasAlgorithm(graph, 0, pred, dist);

		System.out.println("Node, Predecessor, and Distance:");
		for(int i = 0; i < pred.length; i++){
			System.out.println(i + ":\t  " + pred[i] + "\t\t" + dist[i]);
		}
		System.out.print("\n");


        test3();

        System.out.print("\n\n\n\n");

        test2();
        System.out.print("\n\n\n\n");

        test22();


    }

    /**
     * This function creates a graph with 5 vertices and 7 edges, then runs Dijkstra's algorithm on the
     * graph, printing the results
     */
    public static void test3()
    {
        MyGraph graph = new MyGraph(0, false);
        
        //arrays for predecessors and distances
        int[] pred = new int[5];
        double[] dist = new double[5];

        graph.addVertex(new Vertex( "A", "boosting", "0.0", 0));
        graph.addVertex(new Vertex( "B", "boosting", "2.0", 1));
        graph.addVertex(new Vertex( "C", "boosting", "0.0", 2));
        graph.addVertex(new Vertex( "D", "boosting", "0.0", 3));
        graph.addVertex(new Vertex( "E", "boosting", "0.0", 4));

        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 3, 1);
        
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);

        graph.addEdge(2, 4, 5);

        graph.addEdge(3, 4, 1);

        graph.printGraph();
        graph.printMatrix(graph.exportMatrix());
        
		//Execute Dijkstra's algorithm on the graph
        MyGraph.dijkstrasAlgorithm(graph, 0, pred, dist);

		System.out.println("Node, Predecessor, and Distance:");
		for(int i = 0; i < pred.length; i++){
			System.out.println(graph.getVertex(i).label + ":\t  " + graph.getVertex(pred[i]).label + "\t\t" + dist[i]);
		}
		System.out.print("\n");
    }

    /**
     * It creates a graph and performs a breadth-first search on it.
     */
    public static void test2()
    {
        MyGraph graph = new MyGraph(0, false);

        graph.addVertex(new Vertex( "A", "boosting", "0.0", 0));
        graph.addVertex(new Vertex( "B", "boosting", "2.0", 1));
        graph.addVertex(new Vertex( "C", "boosting", "0.0", 2));
        graph.addVertex(new Vertex( "D", "boosting", "0.0", 3));
        graph.addVertex(new Vertex( "E", "boosting", "0.0", 4));

        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 3, 1);
        
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);

        graph.addEdge(2, 4, 5);

        graph.addEdge(3, 4, 1);

        graph.printGraph();
        graph.printMatrix(graph.exportMatrix());

        int sum = 0;
        //Perform a depth-first search
		int[] parents = BreadthFirstSearch.breadthFirstSearch(graph, 0);
		System.out.println("Node and Parent in tree:");
		for(int i = 0; i < parents.length; i++){
			System.out.println(i + " " + parents[i]);
            if(i > 0) sum += graph.getEdge(parents[i], i).getWeight();
		}

		System.out.println("BFS Distance:" + sum);

    }

    /**
	 * Main method to test depth-first method 
	 * pre: args[0] is the name of the input file
	 * @param args The command line arguments
	 */
    public static void test22()
    {
        MyGraph graph = new MyGraph(0, false);

        graph.addVertex(new Vertex( "A", "boosting", "0.0", 0));
        graph.addVertex(new Vertex( "B", "boosting", "2.0", 1));
        graph.addVertex(new Vertex( "C", "boosting", "0.0", 2));
        graph.addVertex(new Vertex( "D", "boosting", "0.0", 3));
        graph.addVertex(new Vertex( "E", "boosting", "0.0", 4));

        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 3, 1);
        
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);

        graph.addEdge(2, 4, 5);

        graph.addEdge(3, 4, 1);

        graph.printGraph();
        graph.printMatrix(graph.exportMatrix());
        
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

		System.out.println("Distance Difference:" + graph.findDifference(graph));

    }

}
