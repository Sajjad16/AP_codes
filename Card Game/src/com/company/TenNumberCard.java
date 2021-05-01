package com.company;

/**
 * This class shows the ten number card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class TenNumberCard extends MotionCard {

    /**
     * Initialise the fields.
     *
     * @param cardType  The ten number card type.
     * @param color     The ten number card color.
     * @param cardScore The ten number card score.
     */
    public TenNumberCard(String cardType, String color, int cardScore) {
        super(cardType, color, cardScore);
    }

    /**
     * Execute the operation of ten number card.
     * Changes the direction of rotation of the game.
     *
     * @param gamingSystem A game in which this card is used.
     */
    @Override
    public void act(GamingSystem gamingSystem) {
        gamingSystem.setMiddleCard(this);
        gamingSystem.changeGameDirection();
        gamingSystem.nextTurn();
    }
}
