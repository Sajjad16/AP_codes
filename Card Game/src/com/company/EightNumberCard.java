package com.company;

/**
 * This class shows the eight number card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class EightNumberCard extends MotionCard {

    /**
     * Initialise the fields.
     *
     * @param cardType  The eight number card type.
     * @param color     The eight number card color.
     * @param cardScore The eight number card score.
     */
    public EightNumberCard(String cardType, String color, int cardScore) {
        super(cardType, color, cardScore);
    }

    /**
     * Execute the operation of eight number card.
     * The player can get another card Play as a prize.
     *
     * @param gamingSystem A game in which this card is used.
     */
    @Override
    public void act(GamingSystem gamingSystem) {
        gamingSystem.setMiddleCard(this);
    }
}
