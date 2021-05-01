package com.company;

import java.util.ArrayList;

/**
 * This class shows the player of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public abstract class Player {
    private ArrayList<Card> hand;
    private int playerScore;
    private String name;

    /**
     * Initialise the fields.
     *
     * @param name The name of player.
     */
    public Player(String name) {
        hand = new ArrayList<>();
        this.name = name;
        playerScore = 0;
    }

    /**
     * Returns the player's card hand.
     *
     * @return the player's card hand.
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Returns the name of player.
     *
     * @return The name of player.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns player score.
     *
     * @return player score.
     */
    public int getPlayerScore() {
        calculateScore();
        return playerScore;
    }


    /**
     * Adds a card to the player hand.
     *
     * @param card Card to be added.
     */
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    /**
     * Removes a card to the player hand.
     *
     * @param card Card to be removed.
     */
    public void removeCardToHand(Card card) {
        hand.remove(card);
    }

    /**
     * Executes the player action.
     *
     * @param middleCard The card he plays according to.
     * @return The card he chooses.
     */
    public abstract Card act(Card middleCard);

    /**
     * This class gives one card from player to another.
     *
     * @param gamingSystem A game that is running.
     */
    public abstract void giveAwayCard(GamingSystem gamingSystem);

    /**
     * The player determines the color of the next card,
     *
     * @param card         A card that changes color.
     * @param gamingSystem A game that is running.
     */
    public abstract void changeMiddleCardColor(GamingSystem gamingSystem, Card card);


    /**
     * Checks whether a card of this type is in the player's hand or not.
     *
     * @param cartType Type the card to be checked.
     * @return True if the card is in the player's hand.
     */
    public boolean checkCartToHand(String cartType) {
        for (Card card : hand) {
            if (card.getCardType().equals(cartType))
                return true;
        }
        return false;
    }

    /**
     * Returns a card that is the same color or type as the card.
     *
     * @param card The card to be checked.
     * @return The card that is the same color or type as the card.
     */
    public Card checkCartToHand(Card card) {
        for (Card c : hand) {
            if (card.getCardType().equals(c.getCardType()) || card.getColor().equals(c.getColor()))
                return c;
        }
        return null;
    }

    /**
     * Calculates the player score
     */
    private void calculateScore() {
        int score = 0;
        if (!(getHand().size() == 0)) {
            for (Card card : hand) {
                score += card.getScore();
            }
        }
        this.playerScore = score;
    }
}
