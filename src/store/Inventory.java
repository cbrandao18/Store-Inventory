package store;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Inventory class to store products in a store.
 *
 * Created by Christie on 6/12/2017.
 */
public class Inventory {
    /*
     * Private members
     */
    private Map<Product, Integer> items;

    /*
     * Public constructor
     */
    public Inventory(){
        this.items = new HashMap<>();
    }

    /*
     * Methods
     */

    /**
     * Add a new product to inventory map
     *
     * @param prod
     *      the product to add
     * @param amount
     *      the number of products in stock
     */
    public void add(Product prod, int amount){
        if (items.containsKey(prod)){
            System.out.println("Item already in inventory");
        } else {
            items.put(prod, amount);
        }
    }

    /**
     * Remove a product completely from inventory
     * @param prod
     *      the product to remove
     */
    public void remove(Product prod){
        if (items.containsKey(prod)){
            items.remove(prod);
        } else {
            System.out.println("Item not in inventory");
        }
    }

    /**
     * Decrement product amount in stock
     * @param prod
     *      the product to update amount
     * @param amount
     *      the amount to decrement the stock by
     */
    public void decrement(Product prod, int amount){
        if (items.containsKey(prod)){
            int stock = items.get(prod);
            if (amount > stock){
                System.out.println("We don't have that many in stock!");
            } else {
                stock-=amount;
                items.replace(prod, stock);
            }
        }
    }

    /**
     * Re-stock inventory with more amounts of products
     * @param prod
     *      product to re-stock
     * @param amount
     *      the amount added to stock
     */
    public void replenish(Product prod, int amount){
        if (items.containsKey(prod)){
            int stock = items.get(prod);
            stock += amount;
            items.replace(prod, stock);
        }
    }

    /**
     * Prints current inventory
     */
    public void printInventory(){
        DecimalFormat format = new DecimalFormat("0.00");
        for (Product prod : this.items.keySet()){
            System.out.println(prod.getName().toUpperCase() + " @ $" + format.format(prod.getPrice()) + " ---- "+ items.get(prod) + " in stock");
        }
    }

    /**
     * Returns the Product object associates with that name
     * @param name
     * @return product object with that name
     */
    public Product getByName(String name){
        Product productToReturn = new Product("empty", 0, 000);
        for (Product prod : this.items.keySet()){
            if (prod.getName().equals(name)){
                productToReturn = prod;
                break;
            }
        }
        return productToReturn;
    }
}
