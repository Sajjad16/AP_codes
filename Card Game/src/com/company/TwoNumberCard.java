package com.company;

/**
 * This class shows the two number card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class TwoNumberCard extends MotionCard {

    /**
     * Initialise the fields.
     *
     * @param cardType  The two number card type.
     * @param color     The two number card color.
     * @param cardScore The two number card score.
     */
    public TwoNumberCard(String cardType, String color, int cardScore) {
        super(cardType, color, cardScore);
    }

    /**
     * Execute the operation of two number card.
     * Compliments a card to a player of her choice.
     *
     * @param gamingSystem A game in which this card is used.
     */
    @Override
    public void act(GamingSystem gamingSystem) {
        gamingSystem.getPlayer(gamingSystem.getTurn()).giveAwayCard(gamingSystem);
        gamingSystem.nextTurn();
        gamingSystem.setMiddleCard(this);
    }
}
