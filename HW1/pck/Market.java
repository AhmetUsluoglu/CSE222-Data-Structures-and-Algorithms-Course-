package pck;
import java.util.Objects;

/**
 * A market is a building that has a set opening and closing times.
 */
public class Market extends Building implements Cloneable{

    private int open;
    private int close;
    private String owner;

    // This is the default constructor for the market class. It is used to create a new market object.
    public Market(){
        super();
        open = close = 0;
        owner = "None";
    }
    // This is the constructor for the market class. It is used to create a new market object.
    public Market(int newPos, int newLen, int newHeight, int newOpen, int newClose,String newOwner){
        pos = newPos; len = newLen; height = newHeight; open = newOpen; close = newClose; owner = newOwner;

    }

    /**
     * The toString() method is called when an object is converted to a string.  
     * @return The toString method is overridden to return a String representation of the object.
     */
    @Override
    public String toString() {
        return "Market{" +
                " Position = " + pos +
                ", Length = " + len  +
                ", Height = " + height +
                ", Owner = " + owner +
                ", Open time = " + open  +
                ", Close time = " + close +
                '}';
    }

    /**
     * Clone the object and return the clone
     * 
     * @return Nothing.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Market Clone = null;
        try {Clone = (Market) super.clone();}
        catch (CloneNotSupportedException e){System.out.println(e.toString()); return null;}
        return  Clone;
    }

    /**
     * It checks if the object is equal to the object passed in.
     * 
     * @param o The object to compare this Market against.
     * @return Boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return open == market.open && owner.equals(market.owner) && close == market.close && pos == ((Market) o).pos && len == ((Market) o).len && height == ((Market) o).height ;
    }

    /**
     * Returns a hash code value for the object. 
     * 
     * The hash code is based on the value of the fields that make up the object. 
     * 
     * The hash code is guaranteed to be the same for objects that are equal according to the equals
     * method. 
     * 
     * The hash code for an object is computed as:
     * 
     * @return integer.
     */
    @Override
    public int hashCode() {
        return Objects.hash(open, owner, close,pos,len,height);
    }

}