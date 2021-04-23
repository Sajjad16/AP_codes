package com.company;

/**
 * This class implements the linkedlist structure.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class LinkedList {
    private Node head;
    private int size;

    /**
     * Initialise the fields of the item.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds a value to the linkedlist.
     *
     * @param value Value to be added.
     */
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null)
            head = newNode;

        else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Print the linkedlist members.
     */
    public void print() {
        if (size != 0) {
            for (Node node = head; node != null; node = node.next)
                System.out.print(node.info + " ");
        }
        System.out.println();
    }

    /**
     * Return First member of linkedlist.
     *
     * @return First member of linkedlist.
     */
    public Node getFirst() {
        return head;
    }
}