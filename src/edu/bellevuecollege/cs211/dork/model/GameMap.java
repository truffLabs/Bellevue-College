package edu.bellevuecollege.cs211.dork.model;
import edu.bellevuecollege.cs211.dork.items.Item;
import java.util.ArrayList;

/**
 * High level game object that holds rooms, items, and people in the game.
 * Intended to track state of "things" spatially on map. Should help if
 * dynamic provision of scenario is desired in future.
 *
 */
public class GameMap {

    //GameMap has a name
    private String mapName;
    
    //GameMap has rooms
    private ArrayList<Room> roomsOnMap;

    //GameMap has items
    private ArrayList<Item> itemsOnMap;

    //GameMap has people
    private ArrayList<Person> peopleOnMap;

    //GameMap has a number of these things
    private int numRooms, numItems, numPeople;

    //construct GameMap with rooms, items, and people
    private GameMap(String mapName, ArrayList someRooms, ArrayList someItems, ArrayList somePeople)
    {
        //construct things
        this.mapName = mapName;
        this.roomsOnMap = someRooms;
        this.itemsOnMap = someItems;
        this.peopleOnMap = somePeople;

        //construct state data
        this.numRooms = getNumRooms();
        this.numItems = getNumItems();
        this.numPeople = getNumPeople();
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public ArrayList<Room> getRoomsOnMap() {
        return roomsOnMap;
    }

    public void setRoomsOnMap(ArrayList<Room> roomsOnMap) {
        this.roomsOnMap = roomsOnMap;
    }

    public ArrayList<Item> getItemsOnMap() {
        return itemsOnMap;
    }

    public void setItemsOnMap(ArrayList<Item> itemsOnMap) {
        this.itemsOnMap = itemsOnMap;
    }

    public ArrayList<Person> getPeopleOnMap() {
        return peopleOnMap;
    }

    public void setPeopleOnMap(ArrayList<Person> peopleOnMap) {
        this.peopleOnMap = peopleOnMap;
    }

    public void clearRoomsOnMap()
    {
        roomsOnMap.clear();
    }
    public void clearItemsOnMap()
    {
        itemsOnMap.clear();
    }
    public void clearPeopleOnMap()
    {
        peopleOnMap.clear();
    }

    public int getNumRooms() {

        int countRooms = 0;

        for(Room r : roomsOnMap)
        {
            countRooms++;
        }

        return  numRooms = countRooms;
    }

    public int getNumItems() {

        int countItems = 0;

        for(Item i : itemsOnMap)
        {
            countItems++;
        }

        return  numItems = countItems;
    }

    public int getNumPeople() {
        return numPeople;
    }
}
