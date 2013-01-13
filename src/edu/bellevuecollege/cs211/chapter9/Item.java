/**
 * Satisfies the requirements for Exercise #X, page XX
 * of "Building Java Programs" second edition.
 *
 * @author Pat Kaehuaea
 *         1/11/13
 *         4:19 PM
 */
public class Item {

    public String name;
    public double price;
    public double discount;

    public Item(String name, double price, double discount){

        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName(){

        return this.name;
    }

    public void setName(String newName){

        this.name = newName;
    }

    public double getPrice(){

        return this.price;
    }

    public void setPrice(double newPrice){

        this.price = newPrice;
    }

    public double getDiscount(){

        return this.discount;
    }

    public void setDiscount(double newDiscount){

        this.discount = newDiscount;
    }



}
