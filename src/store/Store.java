package store;

import java.util.Scanner;

/**
 * Store program displaying how inventory is updated when a purchase is made.
 *
 * Created by Christie on 6/12/2017.
 */
public class Store {

    private static void create(Inventory inventory){
        Product apple = new Product("apple", 0.75, 111);
        Product orange = new Product("orange", 0.70, 112);
        Product juice = new Product("juice", 2.50, 221);
        Product cookies = new Product("cookies", 3.00, 321);
        inventory.add(apple, 10);
        inventory.add(orange, 5);
        inventory.add(juice, 3);
        inventory.add(cookies, 7);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Christie's store!");
        System.out.println("-----------------------------------------------------");
        System.out.println("Here is the current inventory:");

        /*
         * Creating initial inventory and print it
         */
        Inventory inventory = new Inventory();
        create(inventory);
        inventory.printInventory();
        System.out.println("-----------------------------------------------------");

        /*
         * Make a purchase
         */
        System.out.print("Enter in an item name you would like to buy: ");
        Scanner in = new Scanner(System.in);
        String item = in.nextLine();
        item.toLowerCase();
        System.out.print("How many? ");
        int amount = in.nextInt();
        Product prod = inventory.getByName(item);
        inventory.decrement(prod, amount);
        System.out.println("-----------------------------------------------------");
        System.out.println("Here is our updated inventory: ");
        inventory.printInventory();


    }
}
