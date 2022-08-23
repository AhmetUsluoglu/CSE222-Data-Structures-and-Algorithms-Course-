package pck.Buildings;
import java.util.Objects;

/**
 * An office is a building with an owner and a job type
 */
public class Office extends Building implements Cloneable{

    private String owner;
    private String job;

    // This is the default constructor for the Office class. It is used to create an office with
    // default values.
    public Office(){
        super();
        owner = job = "None";
    }

    public Office(int newPos, int newLen, int newHeight,String newOwner, String newJob){
        pos = newPos; len = newLen; height = newHeight; owner = newOwner; job = newJob;
    }

    /**
     * The toString() method is called when an object is converted to a string. 
     * @return The toString method is overridden to return a String representation of the Office
     * object.
     */
    @Override
    public String toString() {
        return "Office{" +
                " Position = " + pos +
                ", Length = " + len  +
                ", Height = " + height +
                ", Owner = " + owner +
                ", Job Type = " + job  +
                '}';
    }

    /**
     * It creates a clone of the object.
     * 
     * @return Copy of the Object.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Office Clone = null;
        try {Clone = (Office) super.clone();}
        catch (CloneNotSupportedException e){System.out.println(e.toString()); return null;}
        return  Clone;
    }

    /**
     * The equals method compares the values of the fields of the object that calls it to the values of
     * the fields of the object passed as a parameter
     * 
     * @param o the object to compare against
     * @return Boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return owner.equals(office.owner) && job.equals(office.job) && pos == ((Office) o).pos && len == ((Office) o).len && height == ((Office) o).height ;
    }

    /**
     * The hashCode method is used to create a hash code for the object
     * 
     * @return The hashCode method is overridden to return the hashCode of the owner, job, position,
     * length, and height fields.
     */
    @Override
    public int hashCode() {
        return Objects.hash(owner, job,pos,len,height);
    }
}