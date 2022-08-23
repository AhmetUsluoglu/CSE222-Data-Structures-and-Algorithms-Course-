package pck;
import java.util.Objects;

/**
 * A house is a building with a number of rooms, an owner, and a color
 */
public class House extends Building implements Cloneable{

    private final int rooms;
    private final String owner;
    private final String color;

    // This is the default constructor for the House class. It is used to create a House object with
    // default values.
    public House(){
        super();
        rooms = 0;
        owner = color = "None";
    }
    // This is the constructor for the House class. It is used to create a House object with default
    // values.
    public House(int newPos, int newLen, int newHeight, int newRooms,String newOwner, String newColor)
    {pos = newPos; len = newLen; height = newHeight; rooms = newRooms; owner = newOwner; color = newColor;}

    /**
     * The toString method is a method that returns a string representation of the object
     * 
     * @return The toString method is overridden and returns a string representation of the House
     * object.
     */
    @Override
    public String toString() {
        return "House{" +
                " Position = " + pos +
                ", Length = " + len  +
                ", Height = " + height +
                ", Number of Rooms = " + rooms +
                ", Owner = " + owner +
                ", Color = " + color  +
                '}';
    }

    /**
     * Clone the object and return the clone
     * 
     * @return Copy of the Object.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        House Clone = null;
        try {Clone = (House) super.clone();}
        catch (CloneNotSupportedException e){System.out.println(e.toString()); return null;}
        return  Clone;
    }

    /**
     * It checks if two objects are equal.
     * 
     * @param o the object to compare against
     * @return Boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return rooms == house.rooms && owner.equals(house.owner) && color.equals(house.color) && pos == ((House) o).pos && len == ((House) o).len && height == ((House) o).height ;
    }

    /**
     * The hashCode method is used to generate a hash code for the object
     * 
     * @return The hashcode of the object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(rooms, owner, color,pos,len,height);
    }
}