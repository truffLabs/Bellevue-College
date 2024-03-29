package edu.bellevuecollege.cs211.assignment1.dork.model;
import edu.bellevuecollege.cs211.assignment1.dork.items.Item;
import edu.bellevuecollege.cs211.assignment1.dork.items.Openable;
import edu.bellevuecollege.cs211.assignment1.dork.items.Weapon;

import java.util.ArrayList;

/**
 * Class representing a room in the "dork" game. Instances of this class are constructed with a
 * single String parameter representing a name. Specific methods can then be called to check and/or
 * assign rooms that are, or are not adjacent to the instance. Each instance contains a list of items
 * define as an ArrayList of Item objects.
 */
public class Room
{

    private String name;

    //intended to allow assignment of room objects
    //to a variable representing a cardinal direction
    protected Room north;
    protected Room south;
	protected Room east;
	protected Room west;

    //hold all items in Room in array list
    private ArrayList<Item> itemsInRoom;

    //hold openable items in separate array list
    private ArrayList<Openable> openableItems;

    //hold weapon items in separate array list
    private ArrayList<Weapon> weaponItems;

    //hold People objects in Room using array list
    private ArrayList<Person> peopleInRoom;


    /**
     * Construct room object, set fields to null and initialize ArrayList.
     *
     * @param name String object representing name of room
     */
    public Room(String name){

        //handle error cases
        if(name.equals("") || name.equals(null))
        {
            throw new IllegalArgumentException("The room name cannot be empty or null.");
        }

        this.name = name;

        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;

        this.itemsInRoom = new ArrayList<Item>();
        this.openableItems = new ArrayList<Openable>();
        this.weaponItems = new ArrayList<Weapon>();
        this.peopleInRoom = new ArrayList<Person>();

    }

    /**
     * Define the adjacency of this room to other rooms. Sets instance
     * fields depending on the value of the Direction parameter.
     *
     * @param dir An enum value from Direction
     * @param someRoom a Room object to assign as being adjacent to calling class
     */
    public void setLocation(Direction dir, Room someRoom)
    {

        if(dir == Direction.NORTH)
        {
            this.north = someRoom;
        }
        else if(dir == Direction.SOUTH)
        {
            this.south = someRoom;
        }
        else if(dir == Direction.EAST)
        {
            this.east = someRoom;
        }
        else if(dir == Direction.WEST)
        {
            this.west = someRoom;
        }
    }

    /**
     * Define the adjacency of this room to other rooms. Sets all four instance
     * fields simultaneously based on passed in parameters. Most useful when
     * initially setting adjacency at beginning of game.
     *
     * @param north Room object north of instance
     * @param east Room object east of instance
     * @param south Room object south of instance
     * @param west Room object west of instance
     */
    public void setLocation(Room north, Room east, Room south, Room west)
    {

        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    /**
     * Returns room object adjacent to calling instance.
     *
     * @param dir direction from calling instance
     * @return room object Direction dir from calling instance
     */
    //TODO: redundant to getNorth?
    public Room getAdjacent(Direction dir)
    {

        if(dir == Direction.NORTH)
        {
            return this.north;
        }
        else if(dir == Direction.SOUTH)
        {
            return this.south;
        }
        else if(dir == Direction.EAST)
        {
            return this.east;
        }
        else
        {
            return this.west;
        }
    }

    /**
     * Method returns an ArrayList containing Item objects contained
     * in calling instance.
     *
     * @return ArrayList object containing Item objects
     */
    public ArrayList getItemsInRoom()
    {
        return this.itemsInRoom;
    }

    /**
     * Method returns an ArrayList containing Openable objects contained
     * in calling instance.
     *
     * @return ArrayList object containing Openable objects
     */
    public ArrayList getOpenableInRoom()
    {
        return this.openableItems;
    }

    /**
     * Method returns an ArrayList containing Weapon objects contained
     * in calling instance.
     *
     * @return ArrayList object containing Weapon objects
     */
    public ArrayList getWeaponInRoom()
    {
        return this.weaponItems;
    }

    /**
     * Method returns an ArrayList containing Person objects contained
     * in calling instance.
     *
     * @return ArrayList object containing Person objects
     */
    public ArrayList getPeopleInRoom()
    {
        return this.peopleInRoom;
    }

    /**
     * Add an Item to the ArrayList of Item objects in calling Room instance.
     *
     * @param i represents Item object
     */
    public void addItem(Item i)
    {
        itemsInRoom.add(i);
    }

    /**
     * Add an Item to the ArrayList of Openable objects in calling Room instance.
     *
     * @param o represents Openable object
     */
    public void addOpenableItem(Openable o)
    {
        openableItems.add(o);
    }

    /**
     * Add an Item to the ArrayList of Weapon objects in calling Room instance.
     *
     * @param w represents Weapon object
     */
    public void addWeaponItem(Weapon w)
    {
        weaponItems.add(w);
    }

    /**
     * Add a Person to the ArrayList of Person objects in calling Room instance.
     *
     * @param p represents Person object
     */
    public void addPerson(Person p)
    {
        peopleInRoom.add(p);
    }

    /**
     * Removes an item from the ArrayList of Item objects.
     *
     * @param i represents an Item object
     */
    public void removeItem(Item i)
    {

        itemsInRoom.remove(i);
    }

    /**
     * Removes an openable item from the ArrayList of Openable objects.
     *
     * @param o represents an Openable object
     */
    public void removeOpenableItem(Openable o)
    {

        openableItems.remove(o);
    }

    /**
     * Removes an weapon item from the ArrayList of Weapon objects.
     *
     * @param w represents a Weapon object
     */
    public void removeWeaponItem(Weapon w)
    {

        weaponItems.remove(w);
    }

    /**
     * Removes a person from the ArrayList of Person objects.
     *
     * @param p represents an Item object
     */
    public void removePerson(Person p)
    {

        peopleInRoom.remove(p);
    }

    /**
     * Clear all items from ArrayList of Item objects.
     *
     */
    public void clearItems(ArrayList listOfStuff)
    {

        listOfStuff.clear();
    }

    /**
     * Clear all people from ArrayList of People objects.
     *
     */
    public void clearPeople()
    {

        peopleInRoom.clear();
    }

    /**
     * Determines if another room exists Direction dir from calling Room.
     *
     * @param dir enum value to check adjacency
     * @return boolean value determine if room is Direction dir adjacent to room
     */
	public boolean roomExists(Direction dir)
	{
        if(dir == Direction.NORTH && this.north != null)
        {
            return true;
        }
        else if(dir == Direction.SOUTH && this.south != null)
        {
            return true;
        }
        else if(dir == Direction.EAST && this.east != null)
        {
            return true;
        }
        else if(dir == Direction.WEST && this.west != null)
        {
            return true;
        }

        return false;
	}
	
	public String  enter()
	{
		return "You entered the " + this.name + " room.";
	}
	
	public String exit()
	{
        return "You left the " + this.name + " room.";
	}

    /**
     * Override default toString object to list details about calling Room object.
     *
     * @return String displaying details on Room fields
     */
    @Override
    public String toString()
    {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getNorth()
    {
        return this.north;
    }

    public Room getSouth()
    {
        return this.south;
    }

    public Room getEast()
    {
        return this.east;
    }

    public Room getWest()
    {
        return this.west;
    }

    public Room setNorth(Room someRoom)
    {
        return this.north;
    }

    public Room setSouth(Room someRoom)
    {
        return this.south;
    }

    public Room setEast(Room someRoom)
    {
        return this.east;
    }

    public Room setWest(Room someRoom)
    {
        return this.west;
    }



	
}
