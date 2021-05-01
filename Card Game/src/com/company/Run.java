package com.company;

/**
 * This class runs a code.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Run {

    /**
     * main method.
     *
     * @param args Input string.
     */
    public static void main(String[] args) {
        GamingSystem gamingSystem = new GamingSystem();
        gamingSystem.runGame();
        gamingSystem.showResult();
    }

}
