package pck.array;
import java.util.InputMismatchException;
import java.util.Scanner;
import pck.Buildings.*;

/**
 * This class is used to represent a street
 * A street is a collection of buildings
 */
public class Street {
    private int length = 0;
    private int height = 0;

    private int side1Length = 0;
    private int side2Length = 0;

    private Building[] side1;
    private Building[] side2;

    private char[][] side1Siluet;
    private char[][] side2Siluet;
    private char[][] preSiluet;
    private char[][] Siluet;

    public Street(){}

    public Street(int streetLength){length = streetLength +1;}

    
    /**
     * Returns the building at the given index on the given side of the street
     * 
     * @param index The index of the building you want to get.
     * @param side true if the building is on the left side, false if it is on the right side.
     * @return The building at the given index.
     */
    public Building get_building(int index, boolean side) {
        if (side)
        {if(index < side1Length && index >= 0) return side1[index];}
        else
        { if(index < side2Length && index >= 0) return side2[index];}
        return null;
    }

    /**
     * Add a building to the side of the road that it belongs to
     * 
     * @param newBuilding The building to be added to the side.
     * @param flag true if the building is on the left side, false if it is on the right side.
     */
    public void add(Building newBuilding, boolean flag) {

        Building[] temp;
        if(flag)
        {
            if (side1Length > 0 && !checkSlot(newBuilding,true)) return;
            temp = new Building[side1Length + 1];
            for (int i = 0; i < side1Length; i++) temp[i] = side1[i];
            temp[side1Length] = newBuilding;
            side1Length++;

            side1 = new Building[side1Length];
            for (int i = 0; i < side1Length; i++)   side1[i] = temp[i];
        }
        else
        {
            if (side2Length > 0 && !checkSlot(newBuilding,false)) return;
            temp = new Building[side2Length + 1];
            for (int i = 0; i < side2Length; i++) temp[i] = side2[i];
            temp[side2Length] = newBuilding;
            side2Length++;

            side2 = new Building[side2Length];
            for (int i = 0; i < side2Length; i++)   side2[i] = temp[i];
        }
    }

    /**
     * Remove the building at the given index from the side of the Street that the index is on
     * 
     * @param index The index of the building to be removed.
     * @param flag true if you want to remove from side1, false if you want to remove from side2
     */
    public void remove(int index, boolean flag){
        if(index == 0) return;
        Building[] temp; index--;
        if(flag)
        {
            if(index >= side1Length || index < 0 || side1Length == 0) return;
            temp = new Building[side1Length - 1];
            int i, j ;
            System.out.println(side1Length);
            for (i = 0, j = 0; i < side1Length; i++, j++)
            {
                if(index == i)
                {
                    i++;
                }
                if(i != side1Length) temp[j] = side1[i];
            }
            side1Length--;
            side1 = new Building[side1Length];
            for (i = 0; i < side1Length; i++)
            {
                side1[i] = temp[i];
            }
        }
        else{
            if(index >= side2Length || index < 0 || side2Length == 0) return;
            temp = new Building[side2Length - 1];
            int i , j ;
            for (i = 0, j = 0; i < side2Length; i++, j++)
            {
                if(i == index)
                {
                    i++;
                }
                temp[j] = side2[i];
            }
            side2Length--;
            side2 = new Building[side2Length];
            for (i = 0; i < side2Length; i++)
            {
                side2[i] = temp[i];
            }
        }
    }

    /**
     * Check if the new building can be placed in the slot
     * 
     * @param newBuilding the building that you want to add to the city
     * @param flag true if the building is being added to side1, false if it's being added to side2
     * @return The method returns a boolean value. If the method returns true, then the building can be
     * placed. If the method returns false, then the building cannot be placed.
     */
    public boolean checkSlot(Building newBuilding, boolean flag) {
        if (flag)
        {
            for (int i = 0; i < side1Length; i++)
            {
                if (side1[i].get_pos() + side1[i].get_len() >= newBuilding.get_pos() && side1[i].get_pos() + side1[i].get_len() <= newBuilding.get_pos() + newBuilding.get_len()) return false;
                if (newBuilding.get_pos() + newBuilding.get_len() >= side1[i].get_pos() && newBuilding.get_pos() + newBuilding.get_len() <= side1[i].get_pos()+ side1[i].get_len()) return false;
                if (newBuilding.get_pos() + newBuilding.get_len() > length) return false;
                if (newBuilding.get_pos() < 0 || newBuilding.get_len() < 0) return false;
            }
        }
        else
        {
            for (int i = 0; i < side2Length; i++)
            {
                if (side2[i].get_pos() + side2[i].get_len() >= newBuilding.get_pos() && side2[i].get_pos() + side2[i].get_len() <= newBuilding.get_pos() + newBuilding.get_len()) return false;
                if (newBuilding.get_pos() + newBuilding.get_len() >= side2[i].get_pos() && newBuilding.get_pos() + newBuilding.get_len() <= side2[i].get_pos()+ side2[i].get_len()) return false;
                if (newBuilding.get_pos() + newBuilding.get_len() > length) return false;
                if (newBuilding.get_pos() < 0 || newBuilding.get_len() < 0) return false;
            }
        }
        return true;
    }

    /**
     * Find the maximum height of all the buildings in the array
     */
    public void MaxHeight() {
        for (int i = 0; i < side1Length; i++)
        {
           if( side1[i].get_height() >= height) height =  side1[i].get_height();
        }
        for (int i = 0; i < side2Length; i++)
        {
            if( side2[i].get_height() >= height) height =  side2[i].get_height();
        }
        height += 2;
    }

    /**
     * This function fills the siluet array with the siluet of the two sides
     */
    public void FillSiluet() {
        MaxHeight();
        int start,end,currHeight;

        side1Siluet = new char[height][length];
        side2Siluet = new char[height][length];
        preSiluet = new char[height][length];
        Siluet = new char[height][length];

        for (int i = 0; i < height ;i++)
        {
            for (int j = 0; j < length ;j++)
            {
                side1Siluet[i][j] = '.';
                side2Siluet[i][j] = '.';
                preSiluet[i][j] = '@';
                Siluet[i][j] = '@';
            }
        }

        for(int i = 0; i < side1Length; i++)
        {
            start =  side1[i].get_pos();
            end = side1[i].get_pos() + side1[i].get_len();
            currHeight = side1[i].get_height();
            for(int x = start; x <= end; x++)
            {
                for(int y = 0; y <= currHeight;y++) side1Siluet[y][x] ='@';
            }
        }

        for(int i = 0; i < side2Length; i++)
        {
            start =  side2[i].get_pos();
            end = side2[i].get_pos() + side2[i].get_len();
            currHeight = side2[i].get_height();
            for(int x = start; x <= end; x++)
            {
                for(int y = 0; y <= currHeight;y++) side2Siluet[y][x] = '@';
            }
        }

        for (int i = 0; i < height; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if((side1Siluet[i][j] == side2Siluet[i][j]) &&  side1Siluet[i][j] == '.') preSiluet[i][j] = side1Siluet[i][j];
            }
        }
    }

    /**
     * Prints the silhouette of the Street
     */
    public void PrintSiluet() {

        for (int i = 0 ; i < height; i++)
        {
            for (int j = 0; j < length; j++)
            {
                Siluet[i][length - 1 - j] = preSiluet[i][j];
            }
        }

        for (int i = height-1 ; i >= 0; i--)
        {
            for (int j = length-1; j >= 0; j--)
            {
                if(Siluet[i][j] != '@') System.out.print(' ');
                else
                {
                    if (j == 0 || j == length-1)
                    {
                        if(Siluet[i+1][j] =='.')System.out.print('_');
                        else System.out.print('|');
                    }
                    else if (i == height-1) System.out.print('_');
                    else if(Siluet[i+1][j] == '.') System.out.print('_');
                    else if(Siluet[i][j-1] == '.' || Siluet[i][j + 1] == '.' ) System.out.print('|');
                    else if(Siluet[i + 1][j + 1] == '.') System.out.print('|');
                    else if(Siluet[i + 1][j - 1] == '.') System.out.print('|');
                    else System.out.print(' ');
                }
            }
            System.out.print('\n');
        }

        for (int i = 0; i < length; i++) System.out.print('#');

        System.out.print('\n');
        for (int i = 0; i < length; i++) if(i%5 == 0) {
            System.out.print(i);
            if (i < 10) System.out.print("    ");
            else System.out.print("   ");
        }
    }

    /**
     * This function adds a building to the Street
     */
    public void addBuilding(){
        int newPos, newLen, newHeight,newRooms, newOpen, newClose;
        String newColor, newOwner,newJob;
        Scanner sc = new Scanner(System.in);
        boolean next = false;
        while(next == false)
        {
            System.out.println("\nChose a side");
            System.out.println("1. Front Side");
            System.out.println("2. Back Side");
            System.out.println("3. Main Menu");
            int choice = 0;
            try {
                System.out.print("Input : ");
                choice = sc.nextInt();
                sc.nextLine();
                next = true;
            }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}

            if(choice == 1){
                System.out.println("\nChose a Building Type");
                System.out.println("1. House");
                System.out.println("2. Office");
                System.out.println("3. Market");
                System.out.println("4. Playground");
                System.out.println("5. Main Menu");

                int choiceBuilding = 0;
                try {
                    System.out.print("Input : ");
                    choiceBuilding = sc.nextInt();
                    sc.nextLine();
                    next = true;
                }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}

                if (choiceBuilding == 1) {
                    System.out.println("\nEnter Position");
                    System.out.print("Input : ");
                    newPos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Length");
                    System.out.print("Input : ");
                    newLen = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Height");
                    System.out.print("Input : ");
                    newHeight = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Number of Rooms");
                    System.out.print("Input : ");
                    newRooms = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Owner");
                    System.out.print("Input : ");
                    newOwner = sc.nextLine();

                    System.out.println("\nEnter Color");
                    System.out.print("Input : ");
                    newColor = sc.nextLine();

                    add(new House(newPos,newLen, newHeight, newRooms, newOwner, newColor),true);
                }
                else if (choiceBuilding == 2){
                    System.out.println("\nEnter Position");
                    System.out.print("Input : ");
                    newPos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Length");
                    System.out.print("Input : ");
                    newLen = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Height");
                    System.out.print("Input : ");
                    newHeight = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Owner");
                    System.out.print("Input : ");
                    newOwner = sc.nextLine();

                    System.out.println("\nEnter Job");
                    System.out.print("Input : ");
                    newJob = sc.nextLine();

                    add(new Office(newPos,newLen, newHeight,  newOwner, newJob),true);
                }
                else if (choiceBuilding == 3){

                    System.out.println("\nEnter Position");
                    System.out.print("Input : ");
                    newPos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Length");
                    System.out.print("Input : ");
                    newLen = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Height");
                    System.out.print("Input : ");
                    newHeight = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Owner");
                    System.out.print("Input : ");
                    newOwner = sc.nextLine();

                    System.out.println("\nEnter Open Time");
                    System.out.print("Input : ");
                    newOpen = sc.nextInt();

                    System.out.println("\nEnter Close Time");
                    System.out.print("Input : ");
                    newClose = sc.nextInt();

                    add(new Market(newPos,newLen, newHeight,  newOpen,  newClose, newOwner),true);
                }
                else if (choiceBuilding == 4){
                    System.out.println("\nEnter Position");
                    System.out.print("Input : ");
                    newPos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Length");
                    System.out.print("Input : ");
                    newLen = sc.nextInt();
                    sc.nextLine();
                    add(new Playground(newPos,newLen),true);
                }
                else if(choice == 5){ return;}
                else System.out.println("\nInvalid Input\n");
            }
            else if (choice == 2)
            {
                System.out.println("\nChose a Building Type");
                System.out.println("1. House");
                System.out.println("2. Office");
                System.out.println("3. Market");
                System.out.println("4. Playground");
                System.out.println("5. Main Menu");

                int choiceBuilding = 0;
                try {
                    System.out.print("Input : ");
                    choiceBuilding = sc.nextInt();
                    sc.nextLine();
                    next = true;
                }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}

                if (choiceBuilding == 1) {
                    System.out.println("\nEnter Position");
                    System.out.print("Input : ");
                    newPos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Length");
                    System.out.print("Input : ");
                    newLen = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Height");
                    System.out.print("Input : ");
                    newHeight = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Number of Rooms");
                    System.out.print("Input : ");
                    newRooms = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Owner");
                    System.out.print("Input : ");
                    newOwner = sc.nextLine();

                    System.out.println("\nEnter Color");
                    System.out.print("Input : ");
                    newColor = sc.nextLine();

                    add(new House(newPos,newLen, newHeight, newRooms, newOwner, newColor),false);
                }
                else if (choiceBuilding == 2){
                    System.out.println("\nEnter Position");
                    System.out.print("Input : ");
                    newPos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Length");
                    System.out.print("Input : ");
                    newLen = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Height");
                    System.out.print("Input : ");
                    newHeight = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Owner");
                    System.out.print("Input : ");
                    newOwner = sc.nextLine();

                    System.out.println("\nEnter Job");
                    System.out.print("Input : ");
                    newJob = sc.nextLine();

                    add(new Office(newPos,newLen, newHeight,  newOwner, newJob),false);
                }
                else if (choiceBuilding == 3){

                    System.out.println("\nEnter Position");
                    System.out.print("Input : ");
                    newPos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Length");
                    System.out.print("Input : ");
                    newLen = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Height");
                    System.out.print("Input : ");
                    newHeight = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Owner");
                    System.out.print("Input : ");
                    newOwner = sc.nextLine();

                    System.out.println("\nEnter Open Time");
                    System.out.print("Input : ");
                    newOpen = sc.nextInt();

                    System.out.println("\nEnter Close Time");
                    System.out.print("Input : ");
                    newClose = sc.nextInt();

                    add(new Market(newPos,newLen, newHeight,  newOpen,  newClose, newOwner),false);
                }
                else if (choiceBuilding == 4){
                    System.out.println("\nEnter Position");
                    System.out.print("Input : ");
                    newPos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\nEnter Length");
                    System.out.print("Input : ");
                    newLen = sc.nextInt();
                    sc.nextLine();
                    add(new Playground(newPos,newLen),false);
                }
                else if(choice == 5){return;}
                else System.out.println("\nInvalid Input\n");

            }
            else if(choice == 3){ return;}
            else System.out.println("\nInvalid Input\n");
        }
        
    }

    /**
     * Remove a building from the Street
     */
    public void removeBuilding(){
        Scanner sc = new Scanner(System.in);
        boolean next = false;
        while(next == false) {
            System.out.println("\nChose a side");
            System.out.println("1. Front Side");
            System.out.println("2. Back Side");
            System.out.println("3. Main Menu");
            int choice = 0;
            try {
                System.out.print("Input : ");
                choice = sc.nextInt();
                sc.nextLine();
                next = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(e);
            }

            if (choice == 1){
                int newPos;
                System.out.println("\nEnter Position");
                System.out.print("Input : ");
                newPos = sc.nextInt();
                sc.nextLine();

                remove(newPos,true);
            }
            else if (choice == 2){
                int newPos;
                System.out.println("\nEnter Position");
                System.out.print("Input : ");
                newPos = sc.nextInt();
                sc.nextLine();

                remove(newPos,false);
            }
            else if(choice == 3){ return;}
            else System.out.println("\nInvalid Input\n");
        }
        
    }

    /**
     * Returns the number of free spaces in the array
     * 
     * @return The number of free spaces in the array.
     */
    public int freeSpaces(){
        return ((2*length) -TotalUsedSpace() -4);
    }

    /**
     * This function prints out the list of buildings on both sides of the road
     * 
     * @param call 
     */
    public void listOfBuildings(int call){
        int count = 1;
        System.out.println("\n\n");
        for (int i = 0; i < side1Length; i++,count++)
            System.out.println(count +". Building (Side 1) =  "+side1[i]);
        for (int i = 0; i < side2Length; i++,count++)
            System.out.println(count +". Building (Side 2)=  "+side2[i]);

        System.out.println("\n\n");
        if (call == 2) return;

        Scanner sc = new Scanner(System.in);
        boolean next = false;
        while(next == false) {
            System.out.println("\n1. Focus on a Building");
            System.out.println("2. Main Menu");
            int choice = 0;
            try {
                System.out.print("Input : ");
                choice = sc.nextInt();
                sc.nextLine();
                next = true;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println(e);
            }

            if (choice == 1){
                int chosen;
                System.out.println("\nEnter Building Number");
                System.out.print("Input : ");
                chosen = sc.nextInt();
                sc.nextLine();

                int num = 1;
                for (int i = 0; i < side1Length; i++,num++)
                    if(num == chosen) System.out.println(num +". Building =  "+side1[i]);
                for (int i = 0; i < side2Length; i++,num++)
                    if(num == chosen) System.out.println(num +". Building =  "+side2[i]);

            }
            else if(choice == 3){return;}
            else System.out.println("\nInvalid Input\n");
        }
        
    }

    /**
     * Prints out the buildings in the order they were added to the array
     * 
     * @param index The index of the building you want to focus on.
     */
    public void FocusOnBuilding(int index)
    {
        int chosen = index;

        int num = 1;
        for (int i = 0; i < side1Length; i++,num++)
            if(num == chosen) System.out.println(num +". Building =  "+side1[i]);
        for (int i = 0; i < side2Length; i++,num++)
            if(num == chosen) System.out.println(num +". Building =  "+side2[i]);
    }

    /**
     * * Counts the number of playgrounds in the street and the total length of playgrounds in the
     * street.
     * * Prints the number of playgrounds and the total length of playgrounds.
     * * Prints the ratio of playgrounds to total building space
     */
    public void PlaygroundRatio(){
        int count = 0; int totalLen = 0;
        for (int i = 0; i < side1Length; i++)
        {
            if (side1[i] instanceof Playground)
            {
                count++;
                totalLen += side1[i].get_len();
            }
        }
        for (int i = 0; i < side2Length; i++)
        {
            if (side2[i] instanceof Playground)
            {
                count++;
                totalLen += side2[i].get_len();
            }
        }

        System.out.println("\nNumber of Playgrounds : " + count);
        System.out.println("Total length of Playgrounds : " + totalLen);
        System.out.println("Playground / Building Ratio : " + (float)((float)totalLen/(float)TotalUsedSpace()));
    }

    /**
     * Returns the total number of spaces used by all the blocks in the two sides of the array
     * 
     * @return The total used space in the array.
     */
    public int TotalUsedSpace(){
        int total = 0;
        for (int i = 0; i < side1Length; i++) total += side1[i].get_len();
        for (int i = 0; i < side2Length; i++) total += side2[i].get_len();
        return total;
    }

    /**
     * Fill the silhouette with the silhouette of the skyline
     * Calls necessary functions to print skyline slihouette
     */
    public void SkylineSilhouette(){
        FillSiluet(); PrintSiluet();
    }

}