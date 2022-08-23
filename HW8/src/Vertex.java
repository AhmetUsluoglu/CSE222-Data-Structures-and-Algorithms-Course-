import java.util.HashMap;
import java.util.LinkedList;

public class Vertex {

    int ID = -1;
    String label = "none";
    double weight = 1.0;
    LinkedList<Edge> edges;
    HashMap<String,String> property;

    // A constructor.
    /**
     * Constructor takes label weight and id.
     * @param label
     * @param weight
     * @param id
     */
    Vertex(String label, double weight, int id)
    {
        this.label = label;
        this.weight = weight;
        this.ID = id;
        edges = new LinkedList<>();
        property = new HashMap<>();
    }


    // A constructor.
    /**
     * Constructor takes only id.
     * @param id
     */
    Vertex(int id)
    {
        this.ID = id;
        edges = new LinkedList<>();
        property = new HashMap<>();

    }
    
    // A constructor.
    /**
     * Constructor that takes label key value and id.
     * @param label
     * @param key
     * @param value
     * @param id
     */
    Vertex(String label, String key, String value, int id)
    {
        this.label = label;
        this.weight = weight;
        this.ID = id;
        edges = new LinkedList<>();
        property = new HashMap<>();
        property.put(key,value);
    }
    public String toString()
    {
        return label+ "  " + weight+ "  " + ID+ "  " + edges+ "  " + property.values()+ "  "; 
    }
}
