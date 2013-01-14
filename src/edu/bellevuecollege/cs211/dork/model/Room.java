package edu.bellevuecollege.cs211.dork.model;
import edu.bellevuecollege.cs211.dork.items.Item;

public class Room
{
	
	protected Room east;
	protected Room west;
	protected Room north;
	protected Room south;

    public Room(){

        //every room should
    }

    //wouldn't it be nice if I could randomly assign objects to each of the rooms?
    public void populateRoom(){


    }

    public void addItems(Item i){


    }
	
	public boolean roomExists(Direction dir)
	{
		return false;
	}
	
	public String  enter()
	{
		return null;
	}
	
	public String exit()
	{
		return null;
	}
	
}
