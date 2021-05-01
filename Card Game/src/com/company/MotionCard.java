package com.company;

/**
 * This class shows the motion card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public abstract class MotionCard extends Card {
    /**
     * Initialise the fields.
     *
     * @param cardType  The motion card type.
     * @param color     The motion card color.
     * @param cardScore The motion card score.
     */
    public MotionCard(String cardType, String color, int cardScore) {
        super(cardType, color, cardScore);
    }

    /**
     * Execute the operation of motion card.
     *
     * @param gamingSystem A game in which this card is used.
     */
    public abstract void act(GamingSystem gamingSystem);
}
