package com.company;

/**
 * This class shows the jack card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class JackCard extends MotionCard {

    /**
     * Initialise the fields.
     *
     * @param cardType  The jack card type.
     * @param color     The jack card color.
     * @param cardScore The jack card score.
     */
    public JackCard(String cardType, String color, int cardScore) {
        super(cardType, color, cardScore);
    }

    /**
     * Execute the operation of eight number card.
     * The player can specify the color of the next card.
     *
     * @param gamingSystem A game in which this card is used.
     */
    @Override
    public void act(GamingSystem gamingSystem) {
        gamingSystem.getPlayer(gamingSystem.getTurn()).changeMiddleCardColor(gamingSystem, this);
        gamingSystem.nextTurn();
    }
}
