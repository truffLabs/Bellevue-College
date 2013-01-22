package edu.bellevuecollege.cs211.dork.controller;
import edu.bellevuecollege.cs211.dork.items.*;
import edu.bellevuecollege.cs211.dork.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller 
{
	private static boolean gameOver;

	public static void main(String Args[])
	{
        //Rooms in scenario
        Room topLeft = new Room("patio");
        Room center = new Room("living room");
        Room top = new Room("kitchen");
        Room right = new Room("child bedroom");
        Room bottom = new Room("bathroom");
        Room left = new Room("main bedroom");

        //rooms arrayed in '+' pattern with one additional room in top left corner
        alignRooms(topLeft, null, top, left, null);
        alignRooms(center, top, right, bottom, left);
        alignRooms(top, null, null, center, topLeft);
        alignRooms(right, null, null, null, center);
        alignRooms(bottom, center, null, null, null);
        alignRooms(left, topLeft, center, null, null);

        //Items in scenario
        DirtyDiaper dirtyDiaper1 = new DirtyDiaper("dirty diaper");
        DiaperGeenie diaperGeenie1 = new DiaperGeenie("diaper geenie");
        BabyWipeContainer babyWipeContainer1 = new BabyWipeContainer("baby wipe container");
        SippyCup sippyCup1 = new SippyCup("sippy cup");
        Bat bat1= new Bat("foam bat");
        Bat bat2= new Bat("foam bat");
        SnowGlobe snowGlobe1 = new SnowGlobe("snow globe");
        SamuraiSword samuraiSword = new SamuraiSword("samurai sword");

        //People in scenario
        Person player1 = new Person("player1");
        Zombie evilZombie = new Zombie("zombie");
        Person mom = new Person("mom");
        Person dad = new Person("dad");
        Person motherInLaw = new Person("mother-in-law");
        Child baby = new Child("baby");
        Child kid = new Child("kid");

        //Place things
        //add items for pickup
        center.addItem(bat1);
        top.addItem(sippyCup1);
        right.addItem(babyWipeContainer1);
        right.addItem(dirtyDiaper1);
        bottom.addItem(diaperGeenie1);
        bottom.addItem(samuraiSword);
        left.addItem(snowGlobe1);
        left.addItem(bat2);

        //add items to openable lists in room
        top.addOpenableItem(sippyCup1);
        right.addOpenableItem(babyWipeContainer1);
        right.addOpenableItem(dirtyDiaper1);
        bottom.addOpenableItem(diaperGeenie1);

        //add items to weapon lists in room
        center.addWeaponItem(bat1);
        bottom.addWeaponItem(samuraiSword);
        left.addWeaponItem(snowGlobe1);
        left.addWeaponItem(bat2);

        //add people
        center.addPerson(dad);
        top.addPerson(motherInLaw);
        right.addPerson(baby);
        right.addPerson(kid);
        bottom.addPerson(evilZombie);
        left.addPerson(mom);

        //set starting location
        Room startingRoom = center;

        //running game
        runScenario(startingRoom, player1);

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
        //TODO: figure out why if this is an 'else-if' it always gets called after methods above return...ALWAYS
        else// if(choice == 3);
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
        System.out.println("1. Attack people in " + roomForPath.getName());
        System.out.println("2. Defend against people in " + roomForPath.getName());
        System.out.println("3. Quit");
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

    public static void alignRooms(Room reference, Room toTheNorth, Room toTheEast, Room toTheSouth, Room toTheWest)
    {
        //instantiate reference room
        Room baseRoom = reference;

        //instantiate adjacent rooms
        Room north = toTheNorth;
        Room east = toTheEast;
        Room south = toTheSouth;
        Room west = toTheWest;

        //set relation of rooms to each other
        //order of parameters is N, E, S, W
        baseRoom.setLocation(north, east, south, west);
    }
}

