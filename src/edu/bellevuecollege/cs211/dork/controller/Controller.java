package edu.bellevuecollege.cs211.dork.controller;
import edu.bellevuecollege.cs211.dork.items.*;
import edu.bellevuecollege.cs211.dork.model.*;
import sun.tools.tree.NewArrayExpression;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller 
{
	private static boolean gameOver;

    //Rooms in scenario ; rooms arrayed in '+' pattern
    private static Room center;
    private static Room top;
    private static Room bottom;
    private static Room left;
    private static Room right;

    //used to track current room
    private static Room currentRoom;

    //Items in scenario
    private static Item dirtyDiaper1;
    private static Item diaperGeenie1;
    private static Item babyWipeContainer1;
    private static Item sippyCup1;
    private static Item bat1;
    private static Item bat2;
    private static Item snowGlobe1;

    //People in scenario
    private static Person zombieMom;
    private static Person zombieDad;
    private static Person zombieMotherInLaw;
    private static Person zombieBaby;
    private static Person zombieKid;
    private static Person player1;
	
	public static void main(String Args[])
	{
        //building map
        buildRooms();
        buildItems();
        buildPeople();

        //populating rooms
        putThingsInRooms();

        //set starting location
        currentRoom = center;

        //running game
        runScenario();
    }

    /**
    public static GameMap initializeGame()
    {
        //GameMap bunchOfThingsOnMap = new GameMap();

        //GameMap has Room(s) -> build rooms
        ArrayList<Room> roomsForMap = buildRooms();

        //Room(s) have Item(s) -> build items
        ArrayList<Item> itemsForMap = buildItems();

        //put items in rooms
        //populateRoomWithItems(ArrayList bunchOfRooms, ArrayList bunchOfItems);

        //Room(s) have Person(s) -> build people
        ArrayList<Person> peopleForMap = buildPeople();

        //put people in rooms
        //populateRoomWithPeople(ArrayList bunchOfRooms, ArrayList bunchOfPeople);

        //Load all things into GameMap
        GameMap mapForDork = new GameMap("mapForDork", roomsForMap, itemsForMap, peopleForMap);

        return mapForDork;
    }
     **/

    public static void runScenario()
    {
        Scanner scan = new Scanner(System.in);
        while(!gameOver)
        {

            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Move");
            System.out.println("2. Show items in " + currentRoom.getName());
            System.out.println("3. Manipulate items in " + currentRoom.getName());  //sub menu is openable, pickupable, etc
            System.out.println("4. Quit");
            System.out.println();
            System.out.print("Choice: ");

            int choice = scan.nextInt();

            //TODO: handle error cases

            if(choice == 1)
            {
                moveMenu();
            }
            else if(choice == 2)
            {
                ArrayList<Item> itemsForMenu = currentRoom.getItemsInRoom();

                System.out.println();
                System.out.println("Items in " + currentRoom.getName() + ": " + itemsForMenu);

            }
            else if(choice == 3)
            {
                manipulateItemsPath();

            }
            else if(choice == 4)
            {
                System.out.println();
                System.out.println("May the dork be with you.");
                gameOver = true;
            }

        }
    }

    public static void moveMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Move North");
        System.out.println("2. Move East");
        System.out.println("3. Move South");
        System.out.println("4. Move West");
        System.out.println("5. Quit");
        System.out.println();
        System.out.print("Choice: ");

        int choice = scan.nextInt();

        if(choice == 1)
        {
            //Check currentRoom.exists(Direction.NORTH);
            //if the room exists -> go back to initial menu
            if(currentRoom.roomExists(Direction.NORTH))
            {
                currentRoom = currentRoom.getNorth();
            }
            else
            {
                System.out.println("****No room exists in the " + Direction.NORTH +  " direction.****");
            }
        }
        if(choice == 2)
        {
            //Check currentRoom.exists(Direction.EAST);
            //if the room exists -> go back to initial menu
            if(currentRoom.roomExists(Direction.EAST))
            {
                currentRoom = currentRoom.getEast();
            }
            else
            {
                System.out.println("****No room exists in the " + Direction.EAST +  " direction.****");
            }

        }
        if(choice == 3)
        {
            //Check currentRoom.exists(Direction.SOUTH);
            //if the room exists -> go back to initial menu
            if(currentRoom.roomExists(Direction.SOUTH))
            {
                currentRoom = currentRoom.getSouth();
            }
            else
            {
                System.out.println("****No room exists in the " + Direction.SOUTH +  " direction.****");
            }

        }
        if(choice == 4)
        {
            //Check currentRoom.exists(Direction.WEST);
            //if the room exists -> go back to initial menu
            if(currentRoom.roomExists(Direction.WEST))
            {
                currentRoom = currentRoom.getWest();
            }
            else
            {
                System.out.println("****No room exists in the " + Direction.WEST +  " direction.****");
            }
        }
        else if(choice == 5)
        {
            System.out.println();
            System.out.println("May the dork be with you.");
            gameOver = true;
        }

    }

    public static void manipulateItemsPath()
    {

        //create menu

        ArrayList<Item>  itemsForPickup = currentRoom.getItemsInRoom();
        ArrayList<Openable>  openableItems = currentRoom.getOpenableInRoom();
        ArrayList<Weapon>  weaponItems = currentRoom.getWeaponInRoom();

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Pick up item");
        System.out.println("2. Open item");
        System.out.println("3. Attack with item");
        System.out.println("4. Quit");
        System.out.println();
        System.out.print("Choice: ");

        int choice = scan.nextInt();

        if(choice == 1)
        {
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("Which item would you like to pick up?");

            //counter for numbers in menu
            int menuCount = 1;
            //counter for elements in index
            int arrayIndex = 0;

            for(Item i : itemsForPickup)
            {
                System.out.println(menuCount + ". " + i);
                menuCount++;
                arrayIndex++;
            }

            System.out.println(menuCount + ". Quit");
            System.out.println();
            System.out.print("Choice: ");

            choice = scan.nextInt();

            //make sure the choice is greater than zero, but within range of array
            if(choice > 0 && choice <= itemsForPickup.size())
            {
                //pickup the item
                player1.addItems(itemsForPickup.get(choice-1));

                //TODO:remove it from the room

                //user feedback
                System.out.println("You picked up a " + itemsForPickup.get(choice-1));
            }
            else
            {
                System.out.println("Bad selection.");
            }

        }
        if(choice == 2)
        {


        }
        if(choice == 3)
        {


        }
        if(choice == 4)
        {

        }
        else if(choice == 5)
        {

        }
    }

    /**
     * Construct room objects and set the location of those
     * rooms objects in relation to each other.
     */
    public static void buildRooms()
    {
        //set rooms on map
        //create room in shape of '+' with five total
        //rooms ; one in center and one at each extremity

        center = new Room("living room");
        top = new Room("kitchen");
        right = new Room("child bedroom");
        bottom = new Room("bathroom");
        left = new Room("adult bedroom");


        //set relation of rooms to each other
        //order of parameters is N, E, S, W
        center.setLocation(top, right, bottom, left);
        top.setLocation(null, null, center, null);
        right.setLocation(null, null, null, center);
        bottom.setLocation(center, null, null, null);
        left.setLocation(null, center, null, null);
    }

    public static void buildItems()
    {
        //construct Item objects
        dirtyDiaper1 = new DirtyDiaper("dirty diaper");
        diaperGeenie1 = new DiaperGeenie("diaper geenie");
        babyWipeContainer1 = new BabyWipeContainer("baby wipe container");
        sippyCup1 = new SippyCup("sippy cup");
        bat1= new Bat("foam bat");
        bat2= new Bat("foam bat");
        snowGlobe1 = new SnowGlobe("snow globe");
    }

    public static void buildPeople()
    {
        //construct Person objects
        zombieMom = new Person("zombie mom");
        zombieDad = new Person("zombie dad");
        zombieMotherInLaw = new Person("zombie mother-in-law");
        zombieBaby = new Child("zombie infant");
        zombieKid = new Child("zombie toddler");
        player1 = new Person("player1");
    }

    public static void putThingsInRooms()
    {
        //add items for pickup
        center.addItem(bat1);
        top.addItem(sippyCup1);
        right.addItem(babyWipeContainer1);
        right.addItem(dirtyDiaper1);
        bottom.addItem(diaperGeenie1);
        left.addItem(snowGlobe1);
        left.addItem(bat2);

        //add items to openable lists in room
        top.addOpenableItem((Openable) sippyCup1);
        right.addOpenableItem((Openable) babyWipeContainer1);
        right.addOpenableItem((Openable) dirtyDiaper1);
        bottom.addOpenableItem((Openable) diaperGeenie1);

        //add items to weapon lists in room
        center.addWeaponItem((Weapon) bat1);
        left.addWeaponItem((Weapon) snowGlobe1);
        left.addWeaponItem((Weapon) bat2);

        //add people
        center.addPerson(zombieDad);
        top.addPerson(zombieMotherInLaw);
        right.addPerson(zombieBaby);
        right.addPerson(zombieKid);
        left.addPerson(zombieMom);
    }

}

