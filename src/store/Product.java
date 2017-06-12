package store;

/**
 * Product class that holds a product's name, retail price, and it's id.
 *
 * Created by Christie on 6/12/2017.
 */
public class Product {
    /*
     * Private members
     */
    private String name;
    private double price;
    private int id;

    /*
     * Public constructor
     */
    public Product(String name, double price, int id){
        this.name = name;
        this.price = price;
        this.id = id;
    }
    /*
     * Get and set methods
     */
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }


}
