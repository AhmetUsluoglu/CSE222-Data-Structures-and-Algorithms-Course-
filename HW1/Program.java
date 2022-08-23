import pck.*;
import java.util.InputMismatchException;
import java.util.Scanner;

// To be able to run the program just writing the make command to terminal is enough. Thanks
/**
 * This class is used to create a street with buildings and playgrounds
 */
public class Program {
    /**
     * This function is the main function of the program. It is responsible for handling the user input
     * and calling the other functions
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Test();
        System.out.println("\n\n\t Street Silhouette Program");
        Street myStreet = new Street();
        Scanner sc = new Scanner(System.in);
        boolean len = false;
        while(len == false)
        {
           System.out.println("\nEnter a Street Length");
           int length = 0;
           try{
               System.out.print("Input : ");
               length = sc.nextInt();
               sc.nextLine();
               len = true;
               myStreet = new Street(length+1);

           }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}
        }


        while(true)
        {
            System.out.println("\nPlease Select a Mode");
            System.out.println("1. Editing Mode");
            System.out.println("2. Viewing Mode");
            System.out.println("3. Quit");

            int mode = 0; boolean next =false;
            try {
                System.out.print("Input : ");
                mode = sc.nextInt();
                sc.nextLine();
                next = true;
            }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}

            if (mode == 3) return;

            while (next)
            {
                if (mode == 1)
                {
                    boolean nextMenu = false;
                    while(nextMenu == false)
                    {
                        System.out.println("\n1. Add a Building");
                        System.out.println("2. Delete a Building");
                        System.out.println("3. Main Menu");
                        System.out.println("4. Quit");
                        int choice = 0;
                        try {
                            System.out.print("Input : ");
                            choice = sc.nextInt();
                            sc.nextLine();
                            nextMenu = true;
                        }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}

                        if(choice == 1){myStreet.addBuilding();}
                        else if(choice == 2){myStreet.removeBuilding();}
                        else if(choice == 3){next = false;}
                        else if(choice == 4){return;}
                        else System.out.println("\nInvalid Input\n");
                    }

                }
                else if(mode == 2)
                {
                    boolean nextMenu = false;
                    while(nextMenu == false)
                    {
                        System.out.println("\n1. Total Free Spaces");
                        System.out.println("2. List of the Buildings");
                        System.out.println("3. Playground/Building Ratio");
                        System.out.println("4. Total Occupied Space");
                        System.out.println("5. Skyline Silhouette");
                        System.out.println("6. Main Menu");
                        System.out.println("7. Quit");

                        int choice = 0;
                        try {
                            System.out.print("Input : ");
                            choice = sc.nextInt();
                            sc.nextLine();
                            nextMenu = true;
                        }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}

                        if(choice == 1){System.out.println("\n\tTotal Length of Free Spaces : " + myStreet.freeSpaces());}
                        else if(choice == 2){myStreet.listOfBuildings(1);}
                        else if(choice == 3){myStreet.PlaygroundRatio();}
                        else if(choice == 4){System.out.println("\n\tTotal Length of Occupied Buildings : " + myStreet.TotalUsedSpace());}
                        else if(choice == 5){myStreet.SkylineSilhouette();}
                        else if(choice == 6){next = false;}
                        else if(choice == 7){return;}
                        else System.out.println("\nInvalid Input\n");
                    }
                }
                else
                {
                    System.out.println("\nInvalid Selection\n");
                    next = false;
                }
            }
        }

    }


    /**
     * This function tests the program
     */
    public static void Test() throws CloneNotSupportedException {
        //Creating a 40 length street
        Street myStreet = new Street(40);
        System.out.println("\nTesting The Program");
        System.out.println("\nThere is nothing in the Street");
        myStreet.SkylineSilhouette();

        //Trying To remove unexisting building.
        System.out.println("\nTrying To remove unexisting building.");
        myStreet.remove(3,true);
        myStreet.SkylineSilhouette();

        // Adding 3 Buildings to the front side
        System.out.println("\nAdding 3 Buildings to the front side");
        myStreet.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet.add(new Office(12,3,4,"John","2"),true);
        myStreet.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet.SkylineSilhouette();

        // Trying to add the 4th house but this occupies the other houses place so it's not added.
        System.out.println("\nTrying to add the 4th house but this occupies the other houses place so it's not added.");
        myStreet.add(new House(3,3,7,0,"none","white"),true);
        myStreet.SkylineSilhouette();

        // Printing all the information about the street.
        System.out.println("\nPrinting all the information about the street.");
        myStreet.listOfBuildings(2);
        System.out.println("\n-- Each Classes' toString function is used when Printing the list of the Buildings. --\n");
        myStreet.TotalUsedSpace();
        myStreet.freeSpaces();
        myStreet.PlaygroundRatio();

        // Adding 3 houses to back side
        System.out.println("\nAdding 3 Buildings to the back side");
        myStreet.add(new House(12,3,4,0,"0","0"),false);
        myStreet.add(new Office(3,3,7,"0","0"),false);
        myStreet.add(new Market(8,3,9,6,17,"0"),false);
        myStreet.SkylineSilhouette();

        // Adding 2 more houses to back side
        System.out.println("\nAdding 2 Buildings to the back side");
        myStreet.add(new House(30,5,7,0,"0","0"),false);
        myStreet.add(new House(17,3,9,0,"0","0"),false);
        myStreet.SkylineSilhouette();


        // Adding Playgrounds to 2 sides
        System.out.println("\nAdding Playgrounds to 2 sides");
        myStreet.add(new Playground(36,4),false);
        myStreet.add(new Playground(22,3),true);
        myStreet.SkylineSilhouette();

        // Printing all the information about the street.
        System.out.println("\nPrinting all the information about the street.");
        myStreet.listOfBuildings(2);
        System.out.println("\n Total Space Used By Buildings : " + myStreet.TotalUsedSpace());
        System.out.println("\n Total Free Spaces in The Street : " + myStreet.freeSpaces());
        myStreet.PlaygroundRatio();

        //Removing 2 random buildings.
        System.out.println("\nRemoving 1 random building from front side.");
        myStreet.remove(2,true);
        myStreet.SkylineSilhouette();
        System.out.println("\nRemoving 1 random building from back side.");
        myStreet.remove(3,false);
        myStreet.SkylineSilhouette();


        // Testing Clone nad Equal functions in the House Class.
        System.out.println("\n\nTesting Clone and Equal functions in the House Class.");
        System.out.print("\nmyStreet.get_building(0,true).EQUALS(((House)myStreet.get_building(0,true)).CLONE()) == ");
        System.out.println(myStreet.get_building(0,true).equals(((House)myStreet.get_building(0,true)).clone()));

        // Testing Clone nad Equal functions in the Office Class.
        System.out.println("\n\nTesting Clone and Equal functions in the Office Class.");
        System.out.print("\nmyStreet.get_building(1,true).EQUALS(((Office)myStreet.get_building(1,true)).CLONE()) == ");
        System.out.println(myStreet.get_building(1,false).equals(((Office)myStreet.get_building(1,false)).clone()));

        // Testing Clone nad Equal functions in the Market Class.
        System.out.println("\n\nTesting Clone nad Equal functions in the Market Class.");
        System.out.print("\nmyStreet.get_building(0,true).EQUALS(((House)myStreet.get_building(0,true)).CLONE()) == ");
        System.out.println(myStreet.get_building(1,true).equals(((Market)myStreet.get_building(1,true)).clone()));

        // Testing Clone nad Equal functions in the Playground Class.
        System.out.println("\n\nTesting Clone and Equal functions in the Playground Class.");
        System.out.print("\nmyStreet.get_building(2,true).EQUALS(((Playground)myStreet.get_building(2,true)).CLONE()) == ");
        System.out.println(myStreet.get_building(2,true).equals(((Playground)myStreet.get_building(2,true)).clone()));


        // Focusing on a building.
        System.out.println("\nListing the Buildings.");
        myStreet.listOfBuildings(2);
        System.out.println("\nFocusing on a building 5 and 7.");
        myStreet.FocusOnBuilding(5);
        myStreet.FocusOnBuilding(7);

        //Last State of the Street
        System.out.println("\nLast State of the Street");
        myStreet.SkylineSilhouette();

        System.out.println("\n\n------ User Controlled Part ------\n\n");
    }
}