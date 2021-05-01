package com.company;

import java.util.ArrayList;

/**
 * This class shows the game storage, which contains a list of cards.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class Storage {
    private ArrayList<Card> cards;

    /**
     * Create storage.
     *
     * @param cards List of cards that should be in the storage.
     */
    public Storage(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Pulls a card out of the storage.
     *
     * @param index The index of the card Which comes out of the storage.
     * @return A card that comes out of the storage.
     */
    public Card getCard(int index) {
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    /**
     * Adds a card to the storage.
     *
     * @param card The card to be added.
     */
    public void addCard(Card card) {
        cards.add(card);
    }
}
