import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Class to implement a breadth-first search algorithm
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class BreadthFirstSearch {
	/**
	 * Perform a breadth-first search of a graph
	 * post: The array parent will contain the predecessor of each vertex in the breadth first search tree
	 * @param graph The graph to be searched
	 * @param start The start vertex
	 * @return The array of parents
	 */
	public static int[] breadthFirstSearch(Graph graph, int start)
    {
		Queue<Integer> theQueue = new LinkedList<Integer>();
		
        //Declare array parent and initialize its elements to -1
		int[] parent = new int[graph.getNumV()];
		for(int i = 0; i < graph.getNumV(); i++){
			parent[i] = -1;
		}
		//Declare array identified and initialize its elements to false
		boolean[] identified = new boolean[graph.getNumV()];
		
        /* Mark the start vertex as identified and insert it into the queue */
		identified[start] = true;
		theQueue.offer(start);
		
		/* Perform breadth-first search until done */
		while(!theQueue.isEmpty())
		{
			/* Take a vertex, current, out of the queue. Begin visiting current */
			int current = theQueue.remove();
			/* Examine each vertex, neighbor, adjacent to current. */
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
				Edge edge = itrInt.next();
				int neighbor = edge.getDest();
				//If neighbor has not been identified
				if(!identified[neighbor]){
					//Mark it identified
					identified[neighbor] = true;
					//Place it into the queue
					theQueue.offer(neighbor);
					/* Insert the edge (current, neighbor) into the tree */
					parent[neighbor] = current;
				}
			}
			//Finished visiting current
		}
		return parent;
	}
}
