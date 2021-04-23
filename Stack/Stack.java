package com.company;

/**
 * This class represents the stack.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Stack {
    private int[] stackArray;
    private int top;
    private final int maxSize;

    /**
     * Initialise the fields of the item.
     *
     * @param maxSize The Size of stack.
     */
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
        top = -1;
    }

    /**
     * Adds a data to the top of the stack
     *
     * @param data The data to be added.
     */
    public void push(int data) {
        if (!isFull()) {
            top = top + 1;
            stackArray[top] = data;
        } else {
            System.out.println("Could not insert data, Stack is full.");
        }
    }

    /**
     * Removes a data from the top of the stack
     */
    public void pop() {
        if (!isEmpty()) {
            top = top - 1;
        } else {
            System.out.println("Could not retrieve data, Stack is empty.");
        }
    }

    /**
     * Returns the highest member value.
     *
     * @return The highest member value.
     */
    public int peek() {
        return stackArray[top];
    }

    /**
     * Specifies whether the stack is empty or not.
     *
     * @return The stack is empty correctly.
     */
    public boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }

    /**
     * Specifies whether the stack is full or not.
     *
     * @return The stack is full correctly.
     */
    public boolean isFull() {
        if (top == maxSize)
            return true;
        else
            return false;
    }
}
