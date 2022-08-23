import pck.Buildings.*;
import pck.array.*;
import pck.arraylist.*;
import pck.linkedlist.*;
import pck.LDlinkedlist.*;
import java.util.InputMismatchException;
import java.util.Scanner;

// To be able to run the program just writing the make command to terminal is enough. Thanks.

/**
 * This class is used to create a street with buildings and playgrounds
 */
public class Program {
    
    /**
     * It runs the test and the run function.
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        
        // Creating a list of random numbers and then sorting them using different methods.
        long startTime, endTime, runTime;
        float r1,r2,r3,r4;

        System.out.println("Iteration \n");
        startTime = System.nanoTime();
        Test3();
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Test 3 With LDLinkedList :" + runTime/100000f + "ms");
        r1 = runTime/100000f;
        
        System.out.println("Iteration \n");
        startTime = System.nanoTime();
        Test2();
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Test 2 With Linked List :" + runTime/100000f + "ms");
        r2 = runTime/100000f;

        System.out.println("Iteration \n");
        startTime = System.nanoTime();
        Test1();
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Test 1 With Array List :" + runTime/100000f + "ms");
        r3 = runTime/100000f;

        System.out.println("Iteration \n");
        startTime = System.nanoTime();
        Test();
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        System.out.println("Test  With Array :" + runTime/100000f + "ms");
        r4 = runTime/100000f;


        
        System.out.println("\n\n\t\t Tested All Functions of the Program");
        System.out.println("\n\n\t\tTest 3 With LDLinkedList :" + r1 + "ms");
        System.out.println("\t\tTest 2 With Linked List  :" + r2 + "ms");
        System.out.println("\t\tTest 1 With Array List   :" + r3 + "ms");
        System.out.println("\t\tTest   With Array        :" + r4 + "ms\n\n");

        TestAll();
        TestAll1();
        TestAll2();

        TestLDLinkedList();

        int ch = 0;
        System.out.println("Choose A Data Type\n 1 - Array \n 2 - Array List\n 3 - Linked List \n 4- LDLinked List");
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Input : ");
            ch = sc.nextInt();

            if (ch == 1) Run();
            else if (ch == 2) Run2();
            else if (ch == 3) Run3();
            else if (ch == 4) Run4();
            else return;

        }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}
    }

    /**
     * This function is the main function of the program. It allows the user to select a mode and then
     * perform the desired action
     */
    public static void Run()
    {
        System.out.println("\n\n------ User Controlled Part ------\n\n");

        System.out.println("\n\n\t Street Silhouette Program");
        Street myStreet = new Street();
        Scanner sc = new Scanner(System.in);
        
        boolean len = false;
        while(len == false){
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

        while(true){
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

            if (mode == 3) {sc.close(); return;}

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
                        else if(choice == 4){sc.close(); return;}
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
                        else if(choice == 7){sc.close(); return;}
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

    public static void Run2()
    {
        System.out.println("\n\n------ User Controlled Part ------\n\n");

        System.out.println("\n\n\t Street Silhouette Program");
        StreetArrList myStreet = new StreetArrList();
        Scanner sc = new Scanner(System.in);
        
        boolean len = false;
        while(len == false){
           System.out.println("\nEnter a Street Length");
           int length = 0;
           try{
               System.out.print("Input : ");
               length = sc.nextInt();
               sc.nextLine();
               len = true;
               myStreet = new StreetArrList(length+1);

           }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}
        }

        while(true){
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

            if (mode == 3) {sc.close(); return;}

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
                        else if(choice == 4){sc.close(); return;}
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
                        else if(choice == 7){sc.close(); return;}
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

    public static void Run3()
    {
        System.out.println("\n\n------ User Controlled Part ------\n\n");

        System.out.println("\n\n\t Street Silhouette Program");
        StreetLinkedList myStreet = new StreetLinkedList();
        Scanner sc = new Scanner(System.in);
        
        boolean len = false;
        while(len == false){
           System.out.println("\nEnter a Street Length");
           int length = 0;
           try{
               System.out.print("Input : ");
               length = sc.nextInt();
               sc.nextLine();
               len = true;
               myStreet = new StreetLinkedList(length+1);

           }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}
        }

        while(true){
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

            if (mode == 3) {sc.close(); return;}

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
                        else if(choice == 4){sc.close(); return;}
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
                        else if(choice == 7){sc.close(); return;}
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

    public static void Run4()
    {
        System.out.println("\n\n------ User Controlled Part ------\n\n");

        System.out.println("\n\n\t Street Silhouette Program");
        StreetLDLinkedList myStreet = new StreetLDLinkedList();
        Scanner sc = new Scanner(System.in);
        
        boolean len = false;
        while(len == false){
           System.out.println("\nEnter a Street Length");
           int length = 0;
           try{
               System.out.print("Input : ");
               length = sc.nextInt();
               sc.nextLine();
               len = true;
               myStreet = new StreetLDLinkedList(length+1);

           }catch (InputMismatchException e){sc.nextLine();System.out.println(e);}
        }

        while(true){
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

            if (mode == 3) {sc.close(); return;}

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
                        else if(choice == 4){sc.close(); return;}
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
                        else if(choice == 7){sc.close(); return;}
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
     * This function tests the program with array structure
     */
    public static void Test() throws CloneNotSupportedException {

        System.out.println("\t\tTesting With Arrays");
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

        
    }

    /**
     * This function tests the program with array list structure
     */
    public static void Test1() throws CloneNotSupportedException {
        System.out.println("\t\tTesting With ArrayList");

        //Creating a 40 length street
        StreetArrList myStreet = new StreetArrList(40);
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
    
        
    }

    /**
     * This function tests the program with Linked List structure
     */
    public static void Test2() throws CloneNotSupportedException {
        System.out.println("\t\tTesting With Linked List");

        //Creating a 40 length street
        StreetLinkedList myStreet = new StreetLinkedList(40);
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
    
        
    }

    /**
     * This function tests the program with LDLinkedList structure
     */
    public static void Test3() throws CloneNotSupportedException {
        System.out.println("\t\tTesting With LDLinked List");

        //Creating a 40 length street
        StreetLDLinkedList myStreet = new StreetLDLinkedList(40);
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
    
        
    }
    
    /**
     * It tests the performance of the four different types of data structures using 1 element.
     */
    public static void TestAll()
    {
        long startTime, endTime, runTime;
        float r1,r2,r3,r4;

        startTime = System.nanoTime();
        Street myStreet1 = new Street(40);
        myStreet1.add(new House(0,4,3,1,"Harry","Blue"),true);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r1 = runTime/100000f;


        startTime = System.nanoTime();
        StreetArrList myStreet2 = new StreetArrList(40);
        myStreet2.add(new House(0,4,3,1,"Harry","Blue"),true);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r2 = runTime/100000f;


        startTime = System.nanoTime();
        StreetLinkedList myStreet3 = new StreetLinkedList(40);
        myStreet3.add(new House(0,4,3,1,"Harry","Blue"),true);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r3 = runTime/100000f;


        startTime = System.nanoTime();
        StreetLDLinkedList myStreet4 = new StreetLDLinkedList(40);
        myStreet4.add(new House(0,4,3,1,"Harry","Blue"),true);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r4 = runTime/100000f;

        

        System.out.println("\n\n\t\t Added 1 Buildings For Each Test");
        System.out.println("\n\n\t\tTest 3 With LDLinkedList :" + r1 + "ms");
        System.out.println("\t\tTest 2 With Linked List  :" + r2 + "ms");
        System.out.println("\t\tTest 1 With Array List   :" + r3 + "ms");
        System.out.println("\t\tTest   With Array        :" + r4 + "ms\n\n");

    }

    /**
     * It tests the performance of the four different types of data structures using 5 elements.
     */
    public static void TestAll1()
    {
        long startTime, endTime, runTime;
        float r1,r2,r3,r4;

        startTime = System.nanoTime();
        Street myStreet1 = new Street(40);
        myStreet1.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet1.add(new Office(12,3,4,"John","2"),true);
        myStreet1.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet1.add(new House(12,3,4,0,"0","0"),false);
        myStreet1.add(new Office(3,3,7,"0","0"),false);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r1 = runTime/100000f;


        startTime = System.nanoTime();
        StreetArrList myStreet2 = new StreetArrList(40);
        myStreet2.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet2.add(new Office(12,3,4,"John","2"),true);
        myStreet2.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet2.add(new House(12,3,4,0,"0","0"),false);
        myStreet2.add(new Office(3,3,7,"0","0"),false);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r2 = runTime/100000f;


        startTime = System.nanoTime();
        StreetLinkedList myStreet3 = new StreetLinkedList(40);
        myStreet3.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet3.add(new Office(12,3,4,"John","2"),true);
        myStreet3.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet3.add(new House(12,3,4,0,"0","0"),false);
        myStreet3.add(new Office(3,3,7,"0","0"),false);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r3 = runTime/100000f;


        startTime = System.nanoTime();
        StreetLDLinkedList myStreet4 = new StreetLDLinkedList(40);
        myStreet4.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet4.add(new Office(12,3,4,"John","2"),true);
        myStreet4.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet4.add(new House(12,3,4,0,"0","0"),false);
        myStreet4.add(new Office(3,3,7,"0","0"),false);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r4 = runTime/100000f;

        

        System.out.println("\n\n\t\t Added 5 Buildings For Each Test");
        System.out.println("\n\n\t\tTest 3 With LDLinkedList :" + r1 + "ms");
        System.out.println("\t\tTest 2 With Linked List  :" + r2 + "ms");
        System.out.println("\t\tTest 1 With Array List   :" + r3 + "ms");
        System.out.println("\t\tTest   With Array        :" + r4 + "ms\n\n");

    }

    /**
     * It tests the performance of the four different types of data structures using 10 elements.
     */
    public static void TestAll2()
    {
        long startTime, endTime, runTime;
        float r1,r2,r3,r4;

        startTime = System.nanoTime();
        Street myStreet1 = new Street(40);
        myStreet1.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet1.add(new Office(12,3,4,"John","2"),true);
        myStreet1.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet1.add(new House(12,3,4,0,"0","0"),false);
        myStreet1.add(new Office(3,3,7,"0","0"),false);
        myStreet1.add(new Market(8,3,9,6,17,"0"),false);
        myStreet1.add(new House(30,5,7,0,"0","0"),false);
        myStreet1.add(new House(17,3,9,0,"0","0"),false);
        myStreet1.add(new Playground(36,4),false);
        myStreet1.add(new Playground(22,3),true);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r1 = runTime/100000f;


        startTime = System.nanoTime();
        StreetArrList myStreet2 = new StreetArrList(40);
        myStreet2.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet2.add(new Office(12,3,4,"John","2"),true);
        myStreet2.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet2.add(new House(12,3,4,0,"0","0"),false);
        myStreet2.add(new Office(3,3,7,"0","0"),false);
        myStreet2.add(new Market(8,3,9,6,17,"0"),false);
        myStreet2.add(new House(30,5,7,0,"0","0"),false);
        myStreet2.add(new House(17,3,9,0,"0","0"),false);
        myStreet2.add(new Playground(36,4),false);
        myStreet2.add(new Playground(22,3),true);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r2 = runTime/100000f;


        startTime = System.nanoTime();
        StreetLinkedList myStreet3 = new StreetLinkedList(40);
        myStreet3.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet3.add(new Office(12,3,4,"John","2"),true);
        myStreet3.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet3.add(new House(12,3,4,0,"0","0"),false);
        myStreet3.add(new Office(3,3,7,"0","0"),false);
        myStreet3.add(new Market(8,3,9,6,17,"0"),false);
        myStreet3.add(new House(30,5,7,0,"0","0"),false);
        myStreet3.add(new House(17,3,9,0,"0","0"),false);
        myStreet3.add(new Playground(36,4),false);
        myStreet3.add(new Playground(22,3),true);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r3 = runTime/100000f;


        startTime = System.nanoTime();
        StreetLDLinkedList myStreet4 = new StreetLDLinkedList(40);
        myStreet4.add(new House(0,4,3,1,"Harry","Blue"),true);
        myStreet4.add(new Office(12,3,4,"John","2"),true);
        myStreet4.add(new Market(5,3,5,9,21,"Mack"),true);
        myStreet4.add(new House(12,3,4,0,"0","0"),false);
        myStreet4.add(new Office(3,3,7,"0","0"),false);
        myStreet4.add(new Market(8,3,9,6,17,"0"),false);
        myStreet4.add(new House(30,5,7,0,"0","0"),false);
        myStreet4.add(new House(17,3,9,0,"0","0"),false);
        myStreet4.add(new Playground(36,4),false);
        myStreet4.add(new Playground(22,3),true);
        endTime = System.nanoTime();
        runTime = endTime - startTime;
        r4 = runTime/100000f;

        
        System.out.println("\n\n\t\t Added 10 Buildings For Each Test");
        System.out.println("\n\n\t\tTest 3 With LDLinkedList :" + r1 + "ms");
        System.out.println("\t\tTest 2 With Linked List  :" + r2 + "ms");
        System.out.println("\t\tTest 1 With Array List   :" + r3 + "ms");
        System.out.println("\t\tTest   With Array        :" + r4 + "ms\n\n");


        startTime = System.nanoTime();
        endTime = System.nanoTime();
        myStreet1.SkylineSilhouette();
        runTime = endTime - startTime;
        r1 = runTime/100000f;

        startTime = System.nanoTime();
        endTime = System.nanoTime();
        myStreet2.SkylineSilhouette();
        runTime = endTime - startTime;
        r2 = runTime/100000f;

        startTime = System.nanoTime();
        endTime = System.nanoTime();
        myStreet3.SkylineSilhouette();
        runTime = endTime - startTime;
        r3 = runTime/100000f;

        startTime = System.nanoTime();
        endTime = System.nanoTime();
        myStreet4.SkylineSilhouette();
        runTime = endTime - startTime;
        r4 = runTime/100000f;

        System.out.println("\n\n\t\t Printing 10 Buildings For Each Test");
        System.out.println("\n\n\t\tTest 3 With LDLinkedList :" + r1 + "ms");
        System.out.println("\t\tTest 2 With Linked List  :" + r2 + "ms");
        System.out.println("\t\tTest 1 With Array List   :" + r3 + "ms");
        System.out.println("\t\tTest   With Array        :" + r4 + "ms\n\n");

    }

    /**
     * This function tests the LDLinkedList structure itself
     */
    public static void TestLDLinkedList()
    {
        System.out.println("\t\tTesting the LdLinkedList Class Separetly");

        System.out.println("Creating a list1 object");

        LDLinkedList<String> list1 = new LDLinkedList<>();
        String five = "5";
        String three = "3";
        list1.addFirst("18");

        System.out.println("Adding some elements to list1 ");

        list1.add("1");
        list1.add("1");
        list1.add("1");
        list1.add("1");
        list1.add("1");
        list1.add(3, "2");
        list1.add(0, "3");

        System.out.println(list1);
        
        list1.add("6");
        System.out.println(list1);
        
        list1.add(7, five);
        System.out.println(list1);

        list1.add(8, "9");
        System.out.println(list1);


        System.out.println("Removing some elements from list1 ");

        System.out.println(list1.remove(7));
        System.out.println(list1);
       
        System.out.println( list1.remove("2"));
        System.out.println(list1);

        System.out.println(list1.indexOf(three));

        System.out.println(list1.removeFirst());
        System.out.println(list1);

        System.out.println("Adding new elements to list1 ");

        list1.addFirst("8");
        System.out.println(list1);

        list1.add(7,"8");
        System.out.println(list1);

        list1.addLast("4");
        System.out.println(list1);
       

        System.out.println("Removing some elements from list1 ");

        System.out.println(list1.remove(0));

        System.out.println(list1);

        

        System.out.println("Creating a list2 object");

        LDLinkedList<String> list2 = new LDLinkedList<>();

        System.out.println("\n          Adding Elements\n");

        list2.addFirst("1");
        System.out.println(list2);

        list2.addLast("2");
        System.out.println(list2);

        list2.add("3");
        System.out.println(list2);

        list2.add(3,"4");
        System.out.println(list2);

        list2.addFirst("0");
        System.out.println(list2);

        list2.add(2,"-1");
        System.out.println(list2);

        list2.print();

        System.out.println("\nPrinting elements in the list using Enhanced Loop via Iterator");
        for(var element : list2)
        {
            System.out.print(element + " ");
        }

        /////////////
        System.out.println("\n\n          Removing elements again          \n");
        System.out.println(list2);


        list2.remove(0);
        System.out.println(list2);
        
        list2.remove(3);
        System.out.println(list2);

        list2.remove(2);
        System.out.println(list2);

        list2.remove(2);
        
        System.out.println(list2);
        list2.print();
        list2.printLazy();


        /////////////
        System.out.println("\n          Adding Elemetns Again\n");


        list2.addFirst("1");
        list2.addFirst("1");
        System.out.println(list2);

        list2.addLast("2");
        System.out.println(list2);

        list2.add(3,"4");
        System.out.println(list2);

        list2.printLazy();


        /////////////
        System.out.println("\n          Checking Boolean Functions\n");


        System.out.println(list2.contains("4"));
        System.out.println(list2.contains("-2"));

        /////////////
        System.out.println("\n          Removing elements again          \n");
        System.out.println(list2);


        list2.remove("-1");
        System.out.println(list2);

        list2.remove("4");
        System.out.println(list2);

        list2.remove("1");
        System.out.println(list2);

        list2.remove("2");
        System.out.println(list2);

        list2.remove("1");

        System.out.println(list2);
        list2.print();
        list2.printLazy();

    }
}