package edu.bellevuecollege.cs211.dork.items;

import com.sun.tools.corba.se.idl.constExpr.BooleanNot;

public abstract class Item
{
    private String itemName;
    private Boolean isOpenable;
    private Boolean isWeapon;

	public Item(String itemName, Boolean isOpenable, Boolean isWeapon)
    {
        //handle error cases
        if(itemName.equals("") || itemName.equals(null))
        {
            throw new IllegalArgumentException("The item name cannot be empty or null.");
        }

        this.itemName = itemName;
        this.isOpenable = isOpenable;
        this.isWeapon = isWeapon;
    }

    public abstract String pickUp();

    public String toString()
    {

        return "Name: " + getItemName() + "\nisOpenable: " + getIsOpenable() + "\nisWeapon: " + getIsWeapon();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Boolean getIsOpenable() {
        return isOpenable;
    }

    public void setIsOpenable(Boolean openable) {
        isOpenable = openable;
    }

    public Boolean getIsWeapon() {
        return isWeapon;
    }

    public void setIsWeapon(Boolean weapon) {
        isWeapon = weapon;
    }
}
