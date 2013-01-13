package edu.bellevuecollege.cs211.chapter9.Groceries;
import java.util.ArrayList;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/11/13
 *         4:19 PM
 */
public class GroceryBill {

    private String clerkName;
    protected ArrayList<Item> itemsInGroceryList;

    private double total;

    //Constructs a grocery bill object for the given clerk
    public GroceryBill(Employee clerk) {

        this.clerkName = clerk.getEmployeeName();
        this.itemsInGroceryList = new ArrayList<Item>();
        this.total = 0.0;

    }

    public void add(Item i) {

        //first add the item to the list
        itemsInGroceryList.add(i);

        //then add the cost of the item to the total
        this.total = this.total + i.getPrice();
    }

    public double getTotal() {

        return this.total;
    }

    public void printReceipt() {

        System.out.println("*****RECEIPT*****");

        for(int i = 0; i < itemsInGroceryList.size(); i++){

            System.out.println(itemsInGroceryList.get(i).name + "     " +  itemsInGroceryList.get(i).getPrice());
        }

        System.out.println("------");
        //NOTE: If I change to this.total -> the DiscountBill doesn't calculate correctly
        System.out.println("Total:          " + getTotal());
    }

}
