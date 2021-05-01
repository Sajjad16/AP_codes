package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class shows the person of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Person extends Player {

    /**
     * Initialise the fields.
     *
     * @param name The name of the person.
     */
    public Person(String name) {
        super(name);

    }

    /**
     * Prints person's hand.
     */
    public void showHand() {
        ArrayList<Card> hand = super.getHand();
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : hand) {
            stringBuilder.append(ConsoleColors.getColor(card.getColor())).append("┍━━━");
        }
        stringBuilder.append("━━┑\n");
        for (Card card : hand) {
            if (card.getCardType().length() == 1)
                stringBuilder.append(ConsoleColors.getColor(card.getColor())).append("│ ").append(card.getCardType()).append(" ");
            else
                stringBuilder.append(ConsoleColors.getColor(card.getColor())).append("│ ").append(card.getCardType());
        }
        stringBuilder.append("  │ \n");
        for (Card card : hand) {
            stringBuilder.append(ConsoleColors.getColor(card.getColor())).append("│   ");
        }
        stringBuilder.append("  │\n");
        for (Card card : hand) {
            stringBuilder.append(ConsoleColors.getColor(card.getColor())).append("│   ");
        }
        stringBuilder.append("  │\n");
        for (Card card : hand) {
            stringBuilder.append(ConsoleColors.getColor(card.getColor())).append("┕━━━");
        }
        stringBuilder.append("━━┙\n");
        for (int i = 0; i < hand.size(); i++) {
            stringBuilder.append(ConsoleColors.getColor("")).append("  ").append(i + 1).append(" ");
        }
        System.out.println(stringBuilder);
    }

    /**
     * Executes the person action.
     *
     * @param middleCard The card he plays according to.
     * @return The card he chooses.
     */
    @Override
    public Card act(Card middleCard) {
        if (super.checkCartToHand(middleCard) != null) {
            showHand();
            System.out.println("Please select a card " + super.getName());
            Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt() - 1;
            while (index < 0 || index >= super.getHand().size()) {
                System.out.println("The number entered is not acceptable,please try again");
                index = scanner.nextInt() - 1;
            }
            Card card = super.getHand().get(index);
            while (card == null || (!card.getColor().equals(middleCard.getColor())) && !card.getCardType().equals(middleCard.getCardType())) {
                System.out.println("You choose the wrong card");
                System.out.println("Please select a card again " + super.getName());
                index = scanner.nextInt() - 1;
                while (index < 0 || index >= super.getHand().size()) {
                    System.out.println("The number entered is not acceptable,please try again");
                    index = scanner.nextInt() - 1;
                }
                card = super.getHand().get(index);
            }
            super.removeCardToHand(card);
            return card;
        } else {
            showHand();
            System.out.println("You can not select a card " + super.getName());
            return null;
        }
    }

    /**
     * This class gives one card from person to another.
     *
     * @param gamingSystem A game that is running.
     */
    @Override
    public void giveAwayCard(GamingSystem gamingSystem) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the player " + this.getName());
        for (int i = 0; i < gamingSystem.getNumberOfPlayers(); i++) {
            Player player = gamingSystem.getPlayer(i);
            if (!player.getName().equals(this.getName())) {
                System.out.println((i + 1) + ")" + player.getName());
            }
        }
        int index = scanner.nextInt() - 1;
        while (index < 0 || index >= gamingSystem.getPlayers().size()) {
            while (gamingSystem.getPlayer(index).getName().equals(this.getName())) {
                System.out.println("The number entered is not acceptable,please try again");
                index = scanner.nextInt() - 1;
            }
        }
        Player player = gamingSystem.getPlayer(index);
        Random random = new Random();
        Card card = gamingSystem.getPlayer(gamingSystem.getTurn()).getHand().get(random.nextInt(gamingSystem.getPlayer(gamingSystem.getTurn()).getHand().size()));
        player.addCardToHand(card);
        this.removeCardToHand(card);
    }

    /**
     * The person determines the color of the next card.
     *
     * @param card         A card that changes color.
     * @param gamingSystem A game that is running.
     */
    public void changeMiddleCardColor(GamingSystem gamingSystem, Card card) {
        gamingSystem.getStorage().addCard(gamingSystem.getMiddleCard());
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Blue\n2.Green\n3.Dark\n4.Red");
        String[] array = {"Blue", "Green", "Dark", "Red"};
        int index = scanner.nextInt() - 1;
        while (index < 0 || index >= 4) {
            System.out.println("The number entered is not acceptable,please try again");
            index = scanner.nextInt() - 1;
        }
        card.setColor((array[index]));
        gamingSystem.setMiddleCard(card);
    }
}
