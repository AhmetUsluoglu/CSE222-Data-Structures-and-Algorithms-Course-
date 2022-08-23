/**
 * An interface for a dynamic graph.*/
public interface DynamicGraph extends Graph{

    /**
     * Create a new vertex with the given label and weight.
     * 
     * @param label The label of the vertex.
     * @param weight The weight of the edge.
     * @return A new vertex with the given label and weight.
     */
    Vertex newVertex (String label, double weight);
    /**
     * It adds a new vertex to the graph.
     * 
     * @param new_vertex The vertex to be added to the graph.
     * @return The vertex that was added.
     */
    Vertex addVertex (Vertex new_vertex);
    /**
     * Adds an edge between two vertices
     * 
     * @param vertexID1 The ID of the first vertex.
     * @param vertexID2 The ID of the vertex that the edge is going to.
     * @param weight The weight of the edge.
     * @return A boolean value.
     */
    boolean addEdge (int vertexID1, int vertexID2, double weight);
    /**
     * Removes the edge between the two vertices with the given IDs
     * 
     * @param vertexID1 The ID of the first vertex.
     * @param vertexID2 The ID of the vertex that you want to remove an edge from.
     */
    void removeEdge (int vertexID1, int vertexID2);
    /**
     * Remove a vertex from the graph.
     * 
     * @param vertexID The ID of the vertex to be removed.
     * @return The vertex that was removed.
     */
    Vertex removeVertex (int vertexID);
    /**
     * Removes a vertex from the graph
     * 
     * @param label The label of the vertex to remove.
     */
    void removeVertex (String label);
    /**
     * "Return a new graph that contains only the vertices that pass the filter."
     * 
     * The filter is a string that contains a JavaScript expression. The expression is evaluated for
     * each vertex in the graph. If the expression evaluates to true, the vertex is included in the new
     * graph. If the expression evaluates to false, the vertex is not included in the new graph
     * 
     * @param key The key to filter on.
     * @param filter The filter to apply to the vertices.
     * @return A new graph with the vertices that match the filter.
     */
    MyGraph filterVertices (String key, String filter);
    /**
     * This function returns a 2D array of doubles that represents the matrix.
     * 
     * @return A 2D array of doubles.
     */
    double[][] exportMatrix();
    /**
     * It prints the graph.
     */
    void printGraph();
}
