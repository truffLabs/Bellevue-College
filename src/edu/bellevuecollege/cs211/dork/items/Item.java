package edu.bellevuecollege.cs211.dork.items;

/**
 * Defines abstract class representing Items present in each of the rooms of the game.
 * Items are constructed with a String itemName parameter.
 */
public abstract class Item
{
    private String itemName;

    /**
     * Construct Item object with String itemName
     *
     * @param itemName String object representing name of item
     */
	public Item(String itemName)
    {
        //handle error cases
        if(itemName.equals("") || itemName.equals(null))
        {
            throw new IllegalArgumentException("The item name cannot be empty or null.");
        }

        this.itemName = itemName;
    }

    //abstract
    public abstract String pickUp();

    public String toString()
    {
        return this.itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
