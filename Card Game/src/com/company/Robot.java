package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class shows the robot of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Robot extends Player {

    /**
     * Initialise the fields.
     *
     * @param name The name of the person.
     */
    public Robot(String name) {
        super(name);
    }

    /**
     * Executes the robot action.
     * The robot always prioritizes the card that has more points than other cards.
     *
     * @param middleCard The card he plays according to.
     * @return The card he chooses.
     */
    @Override
    public Card act(Card middleCard) {
        Card card = super.checkCartToHand(middleCard);
        if (card != null) {
            ArrayList<Card> cards = super.getHand();
            for (Card c : cards) {
                if (card.getScore() < c.getScore() && (c.getColor().equals(card.getColor()) || c.getCardType().equals(card.getCardType())))
                    card = c;
            }
            super.removeCardToHand(card);
        }
        return card;
    }

    /**
     * This class gives one card from robot to another.
     *
     * @param gamingSystem A game that is running.
     */
    @Override
    public void giveAwayCard(GamingSystem gamingSystem) {
        Random random = new Random();
        int index = random.nextInt(gamingSystem.getNumberOfPlayers());
        Player player = gamingSystem.getPlayer(index);
        Card card = gamingSystem.getPlayer(gamingSystem.getTurn()).getHand().get(random.nextInt(gamingSystem.getPlayer(gamingSystem.getTurn()).getHand().size()));
        player.addCardToHand(card);
        this.removeCardToHand(card);
    }

    /**
     * The robot determines the color of the next card.
     * The robot prioritizes color selection based on the number of different colors in her hand.
     *
     * @param card         A card that changes color.
     * @param gamingSystem A game that is running.
     */
    @Override
    public void changeMiddleCardColor(GamingSystem gamingSystem, Card card) {
        gamingSystem.getStorage().addCard(gamingSystem.getMiddleCard());
        String[] array = {"Blue", "Green", "Dark", "Red"};
        int[] arrNumber = new int[4];
        for (String color : array) {
            if (color.equals("Blue")) {
                arrNumber[0]++;
            } else if (color.equals("Green")) {
                arrNumber[1]++;
            } else if (color.equals("Dark")) {
                arrNumber[2]++;
            } else if (color.equals("Red")) {
                arrNumber[3]++;
            }
        }
        int counter = 0;
        for (int number : arrNumber) {
            if (number > counter) {
                counter = number;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (arrNumber[i] == counter) {
                card.setColor((array[i]));
            }
        }
        gamingSystem.setMiddleCard(card);
    }
}
