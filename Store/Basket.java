package com.company;

import java.util.ArrayList;

/**
 * This class shows all the products in our shopping cart.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Basket {
    private ArrayList<Product> cart;

    /**
     * Construct an empty Basket.
     */
    public Basket() {
        cart = new ArrayList<>();
    }

    /**
     * Adds new product to the cart.
     *
     * @param product The product to be added.
     */
    public void addToCart(Product product) {
        cart.add(product);
    }

    /**
     * Removes product to the cart.
     *
     * @param product The product to be removed.
     */
    public void removeToCart(Product product) {
        cart.remove(product);
    }

    /**
     * Calculates the total price of products in the cart.
     */
    public double getPriceOfProducts() {
        double price = 0;
        for (Product product : cart) {
            price += product.getPrice();
        }
        return price;
    }

    /**
     * Return the product.
     *
     * @param index The index of product in basket.
     * @return The product.
     */
    public Product findProduct(int index) {
        if (index > 0 && index <= cart.size())
            return cart.get(index - 1);
        else
            return null;
    }

    /**
     * Return the string of basket.
     *
     * @return The string of basket.
     * @Override
     */
    public String toString() {
        StringBuilder productString = new StringBuilder("Itemsincart:\n");
        for (int i = 0; i < cart.size(); i++) {
            productString.append(i + 1).append("){\n").append(cart.get(i)).append("\n}\n");
        }
        return productString.toString();
    }

    /**
     * Print the basket.
     */
    public void print() {
        if (cart.isEmpty()) {
            System.out.println("List is empty.");
        } else
            System.out.print(this);
    }
}
