package edu.bellevuecollege.cs211.dork.model;
import edu.bellevuecollege.cs211.dork.items.Item;
import edu.bellevuecollege.cs211.dork.items.Openable;
import edu.bellevuecollege.cs211.dork.items.Weapon;

import java.util.ArrayList;

public class Person
{
    //a person has a name
    private String personName;

    //a person is in a room
    private Room currentRoom;

    //a person has items they hold
    private ArrayList<Item> itemsOnPerson;

    //hold openable items in separate array list
    private ArrayList<Openable> openableItems;

    //hold weapon items in separate array list
    private ArrayList<Weapon> weaponItems;

    //construct Person object with name
    public Person(String someName)
    {
        //handle error cases
        if(someName.equals("") || someName.equals(null))
        {
            throw new IllegalArgumentException("The person's name cannot be empty or null.");
        }

        this.personName = someName;
        this.currentRoom = null;
        this.itemsOnPerson = new ArrayList<Item>();
        this.openableItems = new ArrayList<Openable>();
        this.weaponItems = new ArrayList<Weapon>();
    }

    //TODO: try adding implementation for adding any object to list
    /**
     * Add an item to the ArrayList of item objects in calling Room instance.
     *
     * @param i represents Person object
     */
    public void addItems(Item i)
    {
        itemsOnPerson.add(i);
    }

    public void addItems(Openable o)
    {
        openableItems.add(o);
    }

    public void addItems(Weapon w)
    {
        weaponItems.add(w);
    }


    /**
     * Removes an item from the ArrayList of Item objects.
     *
     * @param i represents an Item object
     */
    public void removeItems(Item i)
    {

        itemsOnPerson.remove(i);
    }

    public void removeItems(Openable o)
    {
        openableItems.remove(o);
    }

    public void removeItems(Weapon w)
    {
        weaponItems.remove(w);
    }

    /**
     * Clear all items from ArrayList of Item objects.
     *
     */
    //TODO: do this to the other clearItems methods in room
    public void clearItems(ArrayList listOfStuff)
    {
        listOfStuff.clear();
    }

    @Override
    public String toString()
    {
        return this.personName;
    }

    public String getPersonsName() {
        return personName;
    }

    public void setPersonsName(String personsName) {
        this.personName = personsName;
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }

    public ArrayList<Item> getitemsOnPerson()
    {
        return itemsOnPerson;
    }

    public void setItemsOnPerson(ArrayList<Item> listOfItems)
    {
        this.itemsOnPerson = listOfItems;
    }


    public ArrayList<Openable> getOpenableItems()
    {
        return openableItems;
    }

    public void setOpenableItems(ArrayList<Openable> openableItems)
    {
        this.openableItems = openableItems;
    }

    public ArrayList<Weapon> getWeaponItems()
    {
        return weaponItems;
    }

    public void setWeaponItems(ArrayList<Weapon> weaponItems)
    {
        this.weaponItems = weaponItems;
    }
}
