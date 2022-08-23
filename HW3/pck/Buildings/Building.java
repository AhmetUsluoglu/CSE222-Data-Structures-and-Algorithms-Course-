package pck.Buildings;
import java.util.Objects;

/**
 * A building is a rectangle with a position, length, and height
 */
public class Building implements Cloneable{

    protected int pos;
    protected int len;
    protected int height;

    /**
     * A getter method that returns the value of the variable position.
     * @return position
     */
    public int get_pos() {return pos;};
    /**
     * A getter method that returns the value of the variable length.
     * @return length
     */
    public int get_len() {return len;};
    /**
     * A getter method that returns the value of the variable height.
     * @return height
     */
    public int get_height() {return height;};


    /**
     * This is the default constructor. It is used to create a new object of type Building.
     */

    public Building(){
        pos = len = height = 0;
    }

    /**
     * It prints out the building's position, length, and height.
     * 
     * @return The toString method is overridden to return a string representation of the Building
     * object.
     */
    @Override
    public String toString() {
        return "Building{" +
                " Position = " + pos +
                ", Length = " + len  +
                ", Height = " + height  +
                '}';
    }

    /**
     * It creates a clone of the object.
     * 
     * @return clone of the object.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Building Clone = null;
        try {Clone = (Building) super.clone();}
        catch (CloneNotSupportedException e){System.out.println(e.toString()); return null;}
        return  Clone;
    }

    /**
     * It checks if the object is equal to this object.
     * 
     * @param o the object to compare against
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return pos == ((Building) o).pos && len == ((Building) o).len && height == ((Building) o).height ;
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