package edu.bellevuecollege.cs211.dork.items;

/**
 *
 */
public abstract class Item
{
    private String itemName;

	public Item(String itemName)
    {
        //handle error cases
        if(itemName.equals("") || itemName.equals(null))
        {
            throw new IllegalArgumentException("The item name cannot be empty or null.");
        }

        this.itemName = itemName;
    }

    public abstract String pickUp();

    public String toString()
    {
        return "Item name is: " + getItemName();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
