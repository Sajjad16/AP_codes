package com.company;

/**
 * This class shows the card of the game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public abstract class Card {
    private String cardType;
    private String color;
    private int cardScore;

    /**
     * Initialise the fields.
     *
     * @param cardType  The card type.
     * @param color     The card color.
     * @param cardScore The card score.
     */
    public Card(String cardType, String color, int cardScore) {
        this.cardType = cardType;
        this.color = color;
        this.cardScore = cardScore;
    }

    /**
     * Returns card score.
     *
     * @return card score.
     */
    public int getScore() {
        return cardScore;
    }

    /**
     * Returns card color.
     *
     * @return card color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns card type.
     *
     * @return card type.
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Set card color.
     *
     * @param color The color to be set.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Execute the operation of card.
     *
     * @param gamingSystem A game in which this card is used.
     */
    public abstract void act(GamingSystem gamingSystem);


    /**
     * Prints a card.
     */
    public void showCard() {
        StringBuilder stringBuilder = new StringBuilder();
        if (cardType.length() == 2) {
            stringBuilder.append(ConsoleColors.getColor(getColor())).append("┍━━━━━━━━━┑\n").append("│ ").append(getCardType())
                    .append("      │\n").append("│\t\t  │\n").append("│\t\t  │\n").append("│  \t   ").append(getCardType())
                    .append(" │\n").append("┕━━━━━━━━━┙").append(ConsoleColors.getColor(""));
        } else {
            stringBuilder.append(ConsoleColors.getColor(getColor())).append("┍━━━━━━━━━┑\n").append("│ ").append(getCardType())
                    .append("\t\t  │\n").append("│\t\t  │\n").append("│\t\t  │\n").append("│   \t").append(getCardType())
                    .append(" │\n").append("┕━━━━━━━━━┙").append(ConsoleColors.getColor(""));
        }
        System.out.println(stringBuilder);
    }


}

