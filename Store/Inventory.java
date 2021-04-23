package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class has all the products available in the store with its stock.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Inventory {
    private HashMap<Product, Integer> products;

    /**
     * Construct an empty Inventory.
     */
    public Inventory() {
        products = new HashMap<>();
    }

    /**
     * Adds new product to the warehouse.
     *
     * @param product The product to be added.
     * @param stock   Ths stock of the product to be added.
     */
    public void addProduct(Product product, int stock) {
        products.put(product, stock);
    }

    /**
     * Removes a product from the warehouse.
     *
     * @param product The product to be removed.
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * Changes the stock of a product that has already been added to the store
     *
     * @param product A product whose stock changes.
     * @param stock   The new stock of product.
     */
    public void setStockOfProduct(Product product, int stock) {
        products.put(product, stock);
    }

    /**
     * Return the stock of product.
     *
     * @param product Products whose stock is returned.
     * @return The stock of product.
     */

    public int getStockOfProduct(Product product) {
        return products.get(product);
    }

    /**
     * Check the availability of the product in the store.
     *
     * @param product Products to be checked.
     * @return Make sure the product is in the store.
     */
    public boolean checkProductContains(Product product) {
        return products.containsKey(product);
    }

    /**
     * Return the product.
     *
     * @param index The index of product in inventory.
     * @return The product.
     */

    public Product findProduct(int index) {
        ArrayList<Product> products = new ArrayList<>(this.products.keySet());
        if (index > 0 && index <= products.size())
            return products.get(index - 1);
        else
            return null;
    }

    /**
     * Return the string of inventory.
     *
     * @return The string of inventory.
     */
    @Override
    public String toString() {
        ArrayList<Product> products = new ArrayList<>(this.products.keySet());
        StringBuilder productString = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            productString.append(i + 1).append("){\n").append(products.get(i))
                    .append("\n}instock:").append(this.products.get(products.get(i))).append('\n');
        }
        return productString.toString();
    }

    /**
     * Print the inventory.
     */
    public void print() {
        if (products.isEmpty()) {
            System.out.println("We are out of stock.");
        } else
            System.out.print(this);
    }
}

