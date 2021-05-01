package com.company;

/**
 * This class adjusts the console colors
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class ConsoleColors {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    /**
     * Returns a color.
     *
     * @param color The color to be returned.
     * @return a color.
     */
    public static String getColor(String color) {
        if (color.equals("Blue")) {
            return ANSI_BLUE;
        } else if (color.equals("Black")) {
            return ANSI_BLACK;
        } else if (color.equals("Red")) {
            return ANSI_RED;
        } else if (color.equals("Green")) {
            return ANSI_GREEN;
        } else return ANSI_RESET;
    }
}
