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
        Stack stack = new Stack(50);
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String[] arrayString = inputString.split(" ");
        for (String str : arrayString) {
            linkedList.add(Integer.parseInt(str));
        }
        Node node = linkedList.getFirst();
        while (node != null) {
            stack.push(node.info);
            node = node.next;
        }
        LinkedList linkedList2 = new LinkedList();
        while (!stack.isEmpty()) {
            linkedList2.add(stack.peek());
            stack.pop();
        }
        linkedList2.print();
    }
}
