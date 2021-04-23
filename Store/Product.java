package com.company;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

/**
 * This class represents product information.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Product {
    private String name;
    private String category;
    private double weight;
    private double price;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;

    /**
     * Initialise the fields of the item.
     *
     * @param name            The name of product.
     * @param category        The category of product.
     * @param weight          The weight of product.
     * @param price           The price of product.
     * @param manufactureDate The manufacture date of product.
     * @param expirationDate  The expiration date of product.
     */
    public Product(String name, String category, double weight, double price, String manufactureDate, String expirationDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.manufactureDate = LocalDate.parse(manufactureDate, formatter);
        this.expirationDate = LocalDate.parse(expirationDate, formatter);
        if (!checkDate()) {
            System.out.println("The manufacture date of the product is after the expiration date of the product");
        } else {
            this.name = name;
            this.category = category;
            this.weight = weight;
            this.price = price;
        }
    }

    /**
     * Return the price of product.
     *
     * @return The price of product.
     */
    public double getPrice() {
        return price;
    }

    private boolean checkDate() {
        if (expirationDate.isBefore(manufactureDate)) {
            return false;
        }
        return true;
    }

    /**
     * Return the string of product.
     *
     * @return The string of product.
     * @Override
     */
    public String toString() {
        return "  \"Product\": {\n\t\"NAME\": \"" + name + "\",\n    \"CATEGORY\": \"" + category
                + "\",\n\t\"WEIGHT\": \"" + weight + "\",\n\t\"PRICE\": \"" + price +
                "\",\n\t\"MANUFACTURE_DATE\": " + manufactureDate
                + ",\n\t\"EXPIRATION_DATE\": " + expirationDate + "\n  }";
    }
}


