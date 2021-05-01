package com.company;

/**
 * This class shows the normal card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class NormalCard extends Card {
    /**
     * Initialise the fields.
     *
     * @param cardType  The normal card type.
     * @param color     The normal card color.
     * @param cardScore The normal card score.
     */
    public NormalCard(String cardType, String color, int cardScore) {
        super(cardType, color, cardScore);
    }

    /**
     * Execute the operation of normal card.
     * One takes the turn and changes the middle card.
     *
     * @param gamingSystem A game in which this card is used.
     */
    @Override
    public void act(GamingSystem gamingSystem) {
        gamingSystem.setMiddleCard(this);
        gamingSystem.nextTurn();
    }
}
