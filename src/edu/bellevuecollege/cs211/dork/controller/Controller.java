package edu.bellevuecollege.cs211.dork.controller;
import edu.bellevuecollege.cs211.dork.items.*;
import edu.bellevuecollege.cs211.dork.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller 
{
	private static boolean gameOver;

    //Rooms in scenario ; rooms arrayed in '+' pattern
    //private static Room center;
    //private static Room top;
    //private static Room bottom;
    //private static Room left;
    //private static Room right;

    //used to track current room
    //private static Room currentRoom;

    //Items in scenario
    private static Item dirtyDiaper1;
    private static Item diaperGeenie1;
    private static Item babyWipeContainer1;
    private static Item sippyCup1;
    private static Weapon bat1;
    private static Item bat2;
    private static Item snowGlobe1;

    //People in scenario
    private static Person zombieMom;
    private static Person zombieDad;
    private static Person zombieMotherInLaw;
    private static Person zombieBaby;
    private static Person zombieKid;
    //private static Person player1;
	
	public static void main(String Args[])
	{
        //Rooms in scenario
        Room center = new Room("living room");
        Room top = new Room("kitchen");
        Room right = new Room("child bedroom");
        Room bottom = new Room("bathroom");
        Room left = new Room("adult bedroom");

        //rooms arrayed in '+' pattern
        alignRooms(center, top, right, bottom, left);
        alignRooms(top, null, null, center, null);
        alignRooms(right, null, null, null, center);
        alignRooms(bottom, center, null, null, null);
        alignRooms(left, null, center, null, null);

        //set starting location
        Room startingRoom = center;

        //Items in scenario

        //People in scenario
        Person player1 = new Person("player1");

        //running game
        runScenario(startingRoom, player1);

        /**
        //building map
        buildRooms();
        buildItems();
        buildPeople();

        //populating rooms
        putThingsInRooms();

        //set starting location
        currentRoom = center;

        //running game
        runScenario(currentRoom, player1);
        **/
    }

    public static void runScenario(Room someRoom, Person somePerson)
    {
        Room roomForScenario = someRoom;
        Person personForScenario = somePerson;

        Scanner scan = new Scanner(System.in);
        while(!gameOver)
        {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1. Move");
            System.out.println("2. Show items in " + roomForScenario.getName());
            System.out.println("3. Manipulate items in " + roomForScenario.getName());
            System.out.println("4. Show people in " + roomForScenario.getName());
            System.out.println("5. Interact with people in " + roomForScenario.getName());
            System.out.println("6. Quit");
            System.out.println();
            System.out.print("Choice: ");

            int choice = scan.nextInt();

            //TODO: handle error cases

            if(choice == 1)
            {
                roomForScenario = movePath(roomForScenario);
            }
            else if(choice == 2)
            {
                ArrayList<Item> itemsForMenu = roomForScenario.getItemsInRoom();

                System.out.println();
                System.out.println("Items in " + roomForScenario.getName() + ": " + itemsForMenu);

            }
            else if(choice == 3)
            {
                manipulateItemsPath(roomForScenario, personForScenario);

            }
            else if(choice == 4)
            {
                ArrayList<Item> peopleForMenu = roomForScenario.getPeopleInRoom();

                System.out.println();
                System.out.println("People in " + roomForScenario.getName() + ": " + peopleForMenu);
            }
            else if(choice == 5)
            {
                interactPeoplePath(roomForScenario, personForScenario);
            }
            else if(choice == 6)
            {
                System.out.println();
                System.out.println("May the dork be with you.");
                gameOver = true;
            }
        }
    }

    public static Room movePath(Room someRoom)
    {
        Room roomForPath = someRoom;

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
            if(roomForPath.roomExists(Direction.NORTH))
            {
                roomForPath = roomForPath.getNorth();
            }
            else
            {
                System.out.println();
                System.out.println("****No room exists in the " + Direction.NORTH +  " direction.****");
            }
        }
        if(choice == 2)
        {
            //Check currentRoom.exists(Direction.EAST);
            //if the room exists -> go back to initial menu
            if(roomForPath.roomExists(Direction.EAST))
            {
                roomForPath = roomForPath.getEast();
            }
            else
            {
                System.out.println();
                System.out.println("****No room exists in the " + Direction.EAST +  " direction.****");
            }

        }
        if(choice == 3)
        {
            //Check currentRoom.exists(Direction.SOUTH);
            //if the room exists -> go back to initial menu
            if(roomForPath.roomExists(Direction.SOUTH))
            {
                roomForPath = roomForPath.getSouth();
            }
            else
            {
                System.out.println();
                System.out.println("****No room exists in the " + Direction.SOUTH +  " direction.****");
            }

        }
        if(choice == 4)
        {
            if(roomForPath.roomExists(Direction.WEST))
            {
                roomForPath = roomForPath.getWest();
            }
            else
            {
                System.out.println();
                System.out.println("****No room exists in the " + Direction.WEST +  " direction.****");
            }
        }
        else if(choice == 5)
        {
            System.out.println();
            System.out.println("May the dork be with you.");
            gameOver = true;
        }

        return roomForPath;

    }

    public static void manipulateItemsPath(Room someRoom, Person somePerson)
    {
        //define the Room where items will be manipulated
        Room roomForPath = someRoom;

        //define the Person who will be manipulating items
        Person personForPath = somePerson;

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Pick up item");
        System.out.println("2. Open item");
        System.out.println("3. Quit");
        System.out.println();
        System.out.print("Choice: ");

        int choice = scan.nextInt();

        if(choice == 1)
        {
            pickUpMenu(roomForPath, personForPath);
        }
        else if(choice == 2)
        {
            openableMenu(roomForPath);
        }
        else if(choice == 3);
        {
            System.out.println();
            System.out.println("May the dork be with you.");
            gameOver = true;
        }
    }

    public static void interactPeoplePath(Room someRoom, Person somePerson)
    {
        //Will 'somePerson' be attacking or defending?
        String attackOrDefend;

        //define the Room where the Person will be interacting with People
        Room roomForPath = someRoom;

        //define the Person who will be manipulating items
        Person personForPath = somePerson;

        //What weapons does 'personForPath' have for this path?
        ArrayList<Weapon>  weaponsForPath = personForPath.getWeaponItems();

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Attack people in living room");
        System.out.println("2. Defend against people in living room");
        System.out.println("3. Talk to people in living room");
        System.out.println("4. Quit");
        System.out.println();
        System.out.print("Choice: ");

        int choice = scan.nextInt();

        //TODO: handle error cases

        if(choice == 1)
        {
            attackOrDefend = "attack";
            attackOrDefendMenu(attackOrDefend, roomForPath, personForPath);
        }
        else if(choice == 2)
        {
            attackOrDefend = "defend";
            attackOrDefendMenu(attackOrDefend, roomForPath, personForPath);

        }
        else if(choice == 3)
        {
            //talkMenu(Room someRoom, Person somePerson);

        }
        else if(choice == 4)
        {
            System.out.println();
            System.out.println("May the dork be with you.");
            gameOver = true;
        }
    }

    public static void pickUpMenu(Room someRoom, Person somePerson)
    {
        Room roomForMenu = someRoom;

        if(roomForMenu.getItemsInRoom().isEmpty())
        {
            System.out.println();
            System.out.println("There are no items to pick up in this room.");
        }
        else
        {
            Person personForMenu = somePerson;

            //what items are available in the room?
            ArrayList<Item> itemsForMenu = roomForMenu.getItemsInRoom();

            System.out.println();
            System.out.println("Which item would you like to pick up?");

            //scanner object for block
            Scanner input = new Scanner(System.in);

            //counter for numbers in menu
            int menuCount = 1;

            //hold integer from user input
            int choice;

            for(Item i : itemsForMenu)
            {
                System.out.println(menuCount + ". " + i);
                menuCount++;
            }

            System.out.println(menuCount + ". Quit");
            System.out.println();
            System.out.print("Choice: ");

            choice = input.nextInt();

            //make sure the choice is greater than zero, but within range of array
            if(choice > 0 && choice <= itemsForMenu.size())
            {
                //pickup the item and add it to 'personForPath'
                personForMenu.addItems(itemsForMenu.get(choice-1));

                //TODO: better way to add item to Weapon list on Person?
                if(itemsForMenu.get(choice-1) instanceof Weapon)
                {
                    //also add the item to the Weapon list on 'personForPath'
                    personForMenu.addItems((Weapon)itemsForMenu.get(choice-1));
                }

                //TODO:remove it from the room

                //user feedback
                System.out.println();
                System.out.println("You picked up a " + itemsForMenu.get(choice-1));
            }
            else
            {
                //TODO: should I do something else here?
                System.out.println("Bad selection.");
            }
        }
    }

    public static void openableMenu(Room someRoom)
    {
        Room roomForMenu = someRoom;

        if(roomForMenu.getOpenableInRoom().isEmpty())
        {
            System.out.println();
            System.out.println("There are no openable items in this room.");
        }
        else
        {
            //what openable items are available in the room?
            ArrayList<Openable> openableForMenu = roomForMenu.getOpenableInRoom();

            //scanner object for block
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("Which item would you like to open?");

            //counter for numbers in menu
            int menuCount = 1;

            //hold integer from user input
            int choice;

            for(Openable o : openableForMenu)
            {
                System.out.println(menuCount + ". " + o);
                menuCount++;
            }

            System.out.println(menuCount + ". Quit");
            System.out.println();
            System.out.print("Choice: ");

            choice = input.nextInt();

            //make sure the choice is greater than zero, but within range of array
            if(choice > 0 && choice <= openableForMenu.size())
            {
                //open the item and print return String to screen
                System.out.println();
                System.out.println(openableForMenu.get(choice-1).open());

                //TODO:remove from list of openable items
            }
            else
            {
                //TODO: should I do something else here?
                System.out.println();
                System.out.println("Bad selection.");
            }
        }
    }

    public static void attackOrDefendMenu(String attackOrDefend, Room someRoom, Person somePerson)
    {
        String attackOrDefendForMenu = attackOrDefend;

        Person personForMenu = somePerson;

        if(personForMenu.getWeaponItems().isEmpty())
        {
            System.out.println();
            System.out.println("You haven't picked up anything to " + attackOrDefend + " with.");
        }
        else
        {
            Room roomForMenu = someRoom;

            //what weapons does the person have to use?
            ArrayList<Weapon> weaponsForMenu = personForMenu.getWeaponItems();

            //who can the person use these weapons against?
            ArrayList<Person> peopleForMenu = roomForMenu.getPeopleInRoom();

            //scanner object for block
            Scanner input = new Scanner(System.in);

            //counter for numbers in menu
            int menuCount = 1;

            //hold integer from user input
            int choice;

            //set the weapon that will be used for attack
            Weapon weaponForAttackOrDefend;

            System.out.println();
            System.out.println("Which item would you like to " + attackOrDefend + " with?");

            //TODO: Loop through Weapon objects that 'personForMenu' holds
            for(Weapon w : weaponsForMenu)
            {
                System.out.println(menuCount + ". " + w);
                menuCount++;
            }

            System.out.println(menuCount + ". Quit");
            System.out.println();
            System.out.print("Choice: ");

            choice = input.nextInt();

            //make sure the choice is greater than zero, but within range of array
            if(choice > 0 && choice <= weaponsForMenu.size())
            {
                //set weapon to use
                weaponForAttackOrDefend = weaponsForMenu.get(choice-1);

                //counter for numbers in menu
                menuCount = 1;

                if(attackOrDefend.equals("attack"))
                {
                    System.out.println();
                    System.out.println("Who would you like to " + attackOrDefend + "?");
                }
                else if (attackOrDefend.equals("defend"))
                {
                    System.out.println();
                    System.out.println("Who would you like to " + attackOrDefend + " against?");
                }

                for(Person p : peopleForMenu)
                {
                    System.out.println(menuCount + ". " + p);
                    menuCount++;
                }

                System.out.println(menuCount + ". Quit");
                System.out.println();
                System.out.print("Choice: ");

                choice = input.nextInt();

                if(choice > 0 && choice <= peopleForMenu.size() && attackOrDefend.equals("attack"))
                {
                    //do the attacking
                    System.out.println();
                    System.out.println(weaponForAttackOrDefend.attack(peopleForMenu.get(choice-1)));
                }
                else if(choice > 0 && choice <= peopleForMenu.size() && attackOrDefend.equals("defend"))
                {
                    //do the attacking
                    System.out.println();
                    System.out.println(weaponForAttackOrDefend.defend(weaponForAttackOrDefend));
                }
                else
                {
                    //TODO: should I do something else here?
                    System.out.println();
                    System.out.println("Bad selection.");
                }
            }
            else
            {
                //TODO: should I do something else here?
                System.out.println();
                System.out.println("Bad selection.");
            }
        }
    }

    /**
     * Construct room objects and set the location of those
     * rooms objects in relation to each other.
     */
    /**
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
     **/

    public static void alignRooms(Room reference, Room toTheNorth, Room toTheEast, Room toTheSouth, Room toTheWest)
    {
        //instantiate reference room
        Room center = reference;

        //instantiate adjacent rooms
        Room north = toTheNorth;
        Room east = toTheEast;
        Room south = toTheSouth;
        Room west = toTheWest;

        //set relation of rooms to each other
        //order of parameters is N, E, S, W
        center.setLocation(north, east, south, west);
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

    /**
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
     **/
    /**
    public static void putThingsInRooms()
    {
        //add items for pickup
        center.addItem((Item) bat1);
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
    **/
}

