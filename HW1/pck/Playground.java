package pck;
import java.util.Objects;

/**
 * A playground is a building that has a position and length
 */
public class Playground extends Building implements Cloneable{

    // A constructor. It is a constructor that calls the constructor of the superclass.
    public Playground(){
        super();
    }
    
    public Playground(int newPos, int newLen){
        pos = newPos; len = newLen;
    }

    /**
     * The toString() method is called when an object is converted to a string. 
     * @return The toString method is overridden to return a String representation of the object.
     */
    @Override
    public String toString() {
        return "Playground{" +
                " Position = " + pos +
                ", Length = " + len  +
                '}';
    }

    /**
     * > Returns a copy of the object
     * 
     * @return Returns a copy of the object.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Playground playground = null;
        try {playground = (Playground) super.clone();}
        catch (CloneNotSupportedException e){System.out.println(e.toString()); return null;}
        return  playground;
    }

    /**
     * `equals` is a method that compares the object it's called on to the object passed in as an
     * argument
     * 
     * @param o the object to compare against
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return pos == ((Playground) o).pos && len == ((Playground) o).len && height == ((Playground) o).height ;
    }

    /**
     * Returns a hash code value for the object. 
     * @return The hashCode method is overridden to return the hashCode of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(pos,len,height);
    }
}