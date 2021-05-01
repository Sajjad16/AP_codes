package com.company;

/**
 * This class shows the seven number card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class SevenEvilCard extends MotionCard {

    /**
     * Initialise the fields.
     *
     * @param cardType  The seven number card type.
     * @param color     The seven number card color.
     * @param cardScore The seven number card score.
     */
    public SevenEvilCard(String cardType, String color, int cardScore) {
        super(cardType, color, cardScore);
    }

    /**
     * Execute the operation of seven number card.
     * She fines the next people with two cards.
     *
     * @param gamingSystem A game in which this card is used.
     */
    @Override
    public void act(GamingSystem gamingSystem) {
        gamingSystem.nextTurn();
        gamingSystem.setMiddleCard(this);
        if (this.getColor().equals("Black")) {
            gamingSystem.setPunishment(gamingSystem.getPunishment() + 4);
        } else {
            gamingSystem.setPunishment(gamingSystem.getPunishment() + 2);
        }
        if (!gamingSystem.getPlayer((gamingSystem.getTurn())).checkCartToHand("7")) {
            if (gamingSystem.getPunishment() != 0) {
                for (int i = 0; i < gamingSystem.getPunishment(); i++) {
                    gamingSystem.getPlayers().get(gamingSystem.getTurn()).addCardToHand(gamingSystem.getStorage().getCard(0));
                }
            }
            gamingSystem.setPunishment(0);
        }

    }
}