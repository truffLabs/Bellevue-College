/**
 * Satisfies the requirements for Exercise #9, page625
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/11/13
 *         4:19 PM
 */
public class DiscountBill extends GroceryBill{

    //is the shopper eligible for a discount?
    private boolean isPreferredShopper;

    //how many items in the shopping list are discounted?
    private int numDiscountedItems;

    //how much of a total discount (sum of item discounts)?
    private double discountAmount;

    //what is the total price of all items in the list (accounts for discount)?
    private double total;

    //what percentage of the full price of the bill is the discount?
    private double discountPercent;

    /**
     * Constructs DiscountBill object by utilizing superclass constructor, then
     * setting the 'isPreferredShopper' variable to the value of the boolean parameter.
     *
     * @param clerkName name of employee processing transaction for customer
     * @param preferred boolean value that is true if eligible for discount
     */
    public DiscountBill(Employee clerkName, boolean preferred){

        super(clerkName);
        isPreferredShopper = preferred;
    }

    /**
     * Iterates through itemsInGrocerList ArrayList (protected field from superclass)
     * to count the number of items eligible for a discount.
     *
     * @return returns number of discounted items in list
     */
    public int getDiscountCount(){

        for(int i = 0; i < itemsInGroceryList.size(); i++){

            if(itemsInGroceryList.get(i).getDiscount() > 0){

                numDiscountedItems++;
            }
        }

        return numDiscountedItems;
    }

    /**
     * Iterates through itemsInGrocerList ArrayList (protected field from superclass)
     * to sum the total eligible discount for all items in list.
     *
     * @return amount of eligible discount
     */
    public double getDiscountAmount(){

        for(int i = 0; i < itemsInGroceryList.size(); i++){

            if(itemsInGroceryList.get(i).getDiscount() > 0){

                discountAmount = discountAmount + itemsInGroceryList.get(i).getDiscount();
            }
        }

        return this.discountAmount;
    }

    /**
     * If 'isPreferredShopper' is true, subtracts 'discountAmount' from 'super.getTotal' to define
     * 'this.total'. Otherwise, method simply sets 'this.total' equal to 'super.total' if the customer
     * is not eligible for a discount.
     *
     * @return value representing amount of discounted bill
     */
    public double getTotal() {

        if(isPreferredShopper == true){

            this.total = super.getTotal() - this.discountAmount;
            return this.total;
        }
        else{

            this.total = super.getTotal();
            return this.total;
        }
    }

    /**
     * Calculates the percent of the total discount as a percent of what the total would have been otherwise
     *
     * @return percentage discount as double value
     */
    public double getDiscountPercent(){

        discountPercent = (1 - (this.total/super.getTotal())) * 100;

        return discountPercent;
    }
}
