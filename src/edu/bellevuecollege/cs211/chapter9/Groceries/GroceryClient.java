package edu.bellevuecollege.cs211.chapter9.Groceries;

/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/11/13
 *         4:48 PM
 */
public class GroceryClient {

    public static void main(String[] Args) {

        //construct Employee object
        Employee e1 = new Employee("poopHead");

        //construct GroceryBill
        GroceryBill g1 = new GroceryBill(e1);

        //construct miscellaneous item objects
        Item i1 = new Item("carrots", 1.27, 0.0);
        Item i2 = new Item("broccoli", 1.75, 0.0);
        Item i3 = new Item("pears", 2.50, 0.75);

        //add item objects to GroceryBill
        g1.add(i1);
        g1.add(i2);
        g1.add(i3);

        //get total cost of items -> print receipt of GroceryBill
        g1.getTotal();
        g1.printReceipt();

        //*****//
        System.out.println();

        //construct DiscountBill object
        DiscountBill d1 = new DiscountBill(e1, true);

        //construct miscellaneous item objects
        Item i4 = new Item("milk", 3.00, 0.0);
        Item i5 = new Item("eggs", 3.00, 0.0);
        Item i6 = new Item("butter", 4.00, 1.00);

        //add item objects to GroceryBill
        d1.add(i4);
        d1.add(i5);
        d1.add(i6);

        //get the number of discounted items in list
        d1.getDiscountCount();

        //get the amount of the discount from the bill
        d1.getDiscountAmount();

        //find the total amount of the discounted bill
        d1.getTotal();

        //print the receipt
        d1.printReceipt();

        System.out.println("Discount percent: " + d1.getDiscountPercent());



    }

}
