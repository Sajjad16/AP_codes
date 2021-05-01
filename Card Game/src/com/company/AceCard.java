package com.company;

/**
 * This class shows the ace card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class AceCard extends MotionCard {
    /**
     * Initialise the fields.
     *
     * @param cardType  The ace card type.
     * @param color     The ace card color.
     * @param cardScore The ace card score.
     */
    public AceCard(String cardType, String color, int cardScore) {
        super(cardType, color, cardScore);
    }

    /**
     * Execute the operation of ace card card.
     * Misses the turn of the next player
     *
     * @param gamingSystem A game in which this card is used.
     */
    @Override
    public void act(GamingSystem gamingSystem) {
        gamingSystem.nextTurn();
        gamingSystem.nextTurn();
        gamingSystem.setMiddleCard(this);
    }
}
