package com.company;

import java.util.Scanner;

/**
 * This class executes the code.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Main {
    /**
     * This is main method.
     *
     * @param args A string passed to a main.
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct(new Product("Carrot", "Vegetables", 5, 20, "15-03-2020", "15-03-2021"), 10);
        inventory.addProduct(new Product("Apple", "Fruits", 10, 50, "01-04-2020", "01-08-2020"), 50);
        inventory.addProduct(new Product("12xEggs", "Egg", 100, 40, "01-01-2020", "01-06-2020"), 20);
        inventory.addProduct(new Product("Oats", "Grains", 70, 100, "01-06-2020", "01-01-2021"), 45);
        inventory.addProduct(new Product("Salmon", "Seafood", 150, 250, "01-01-2020", "01-02-2020"), 5);
        inventory.addProduct(new Product("Stake", "Meat", 800, 1000, "01-03-2020", "01-09-2020"), 5);
        inventory.addProduct(new Product("Milk", "Dairy", 100, 20, "10-01-2020", "25-01-2020"), 20);
        inventory.addProduct(new Product("Cheese", "Dairy", 150, 10, "01-02-2020", "15-03-2020"), 50);
        inventory.print();
        Basket basket = new Basket();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int index;
            String inputString = scanner.next();
            if (inputString.equals("add")) {
                index = scanner.nextInt();
                Product product = inventory.findProduct(index);
                if (product != null) {
                    basket.addToCart(product);
                    inventory.setStockOfProduct(product, inventory.getStockOfProduct(product) - 1);
                    if (inventory.getStockOfProduct(product) == 0)
                        inventory.removeProduct(product);
                }
            } else if (inputString.equals("remove")) {
                index = scanner.nextInt();
                Product product = basket.findProduct(index);
                if (product != null) {
                    basket.removeToCart(product);
                    if (inventory.checkProductContains(product))
                        inventory.setStockOfProduct(product, inventory.getStockOfProduct(product) + 1);
                    else
                        inventory.addProduct(product, 1);
                }

            } else if (inputString.equals("cart")) {
                basket.print();

            } else if (inputString.equals("products")) {
                inventory.print();

            } else if (inputString.equals("checkout")) {
                System.out.println("Total purchase price:" + basket.getPriceOfProducts() + "$");
                System.out.println("It was a pleasure doing business with you.");
                return;
            }
        }
    }


}

