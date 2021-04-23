package com.company;

/**
 * This class represents a node
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Node {
    public int info;
    public Node next;

    /**
     * Initialise the fields of the item.
     *
     * @param info The amount that each node holds.
     */
    public Node(int info) {
        this.info = info;
        next = null;
    }
}

