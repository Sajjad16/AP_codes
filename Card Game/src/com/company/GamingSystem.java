package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class creates and runs a game.
 *
 * @author Mohammad Rahmanian.
 * @version 1.0
 */
public class GamingSystem {
    private int turn;
    private String gameDirection;
    private Storage storage;
    private ArrayList<Player> players;
    private int numberOfPlayers;
    private Card middleCard;
    private int punishment;

    /**
     * Creates a game
     */
    public GamingSystem() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Card> cards = new ArrayList<>();
        String[] colorArray = {"Blue", "Black", "Red", "Green"};
        for (String color : colorArray) {
            cards.add(new TwoNumberCard("2", color, 2));
            cards.add(new NormalCard("3", color, 3));
            cards.add(new NormalCard("4", color, 4));
            cards.add(new NormalCard("5", color, 5));
            cards.add(new NormalCard("6", color, 6));
            cards.add(new EightNumberCard("8", color, 8));
            cards.add(new NormalCard("9", color, 9));
            cards.add(new TenNumberCard("10", color, 10));
            cards.add(new AceCard("A", color, 11));
            cards.add(new JackCard("B", color, 12));
            cards.add(new NormalCard("C", color, 12));
            cards.add(new NormalCard("D", color, 13));
            cards.add(new SevenEvilCard("7", color, 10));
        }
        players = new ArrayList<>();
        System.out.println("Enter the number of players between three and five");
        System.out.println("Persons:");
        int numberOfPesons = scanner.nextInt();
        while (numberOfPesons > 5 || numberOfPesons < 0) {
            System.out.println("The number entered is not acceptable");
            System.out.println("Please try again");
            System.out.println("Persons:");
            numberOfPesons = scanner.nextInt();
        }
        int numberOfRobots = 0;
        if (numberOfPesons < 5) {
            System.out.println("Robots:");
            numberOfRobots = scanner.nextInt();
            while (numberOfRobots > 5 || numberOfRobots < 0) {
                System.out.println("The number entered is not acceptable");
                System.out.println("Please try again");
                System.out.println("Robots:");
                numberOfRobots = scanner.nextInt();
            }
        }
        numberOfPlayers = numberOfPesons + numberOfRobots;
        while (numberOfPlayers < 3 || numberOfPlayers > 5) {
            System.out.println("Enter the number of players between three and five");
            System.out.println("Persons:");
            numberOfPesons = scanner.nextInt();
            while (numberOfPesons > 5 || numberOfPesons < 0) {
                System.out.println("The number entered is not acceptable");
                System.out.println("Please try again");
                System.out.println("Persons");
                numberOfPesons = scanner.nextInt();
            }
            numberOfRobots = 0;
            if (numberOfPesons < 5) {
                System.out.println("Robots:");
                numberOfRobots = scanner.nextInt();
                while (numberOfRobots > 5 || numberOfRobots < 0) {
                    System.out.println("The number entered is not acceptable");
                    System.out.println("Please try again");
                    System.out.println("Robots");
                    numberOfRobots = scanner.nextInt();
                }
            }
            numberOfPlayers = numberOfPesons + numberOfRobots;
        }
        for (int i = 0; i < numberOfPesons; i++) {
            System.out.println("Enter the person's name:");
            players.add(new Person(scanner.next()));
        }
        for (int i = 0; i < numberOfRobots; i++) {
            players.add(new Robot("Robot" + (i + 1)));
        }
        for (int i = 52; i > 52 - (players.size() * 7); i--) {
            Random random = new Random();
            int index = i % players.size();
            int randomValue = random.nextInt(i);
            getPlayer(index).addCardToHand(cards.get(randomValue));
            cards.remove(randomValue);
        }
        storage = new Storage(randomArrangementOfCards(cards));
        changeGameDirection();
        turn = 0;
        punishment = 0;
    }

    /**
     * Returns player.
     *
     * @param index Index of player.
     * @return player.
     */
    public Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     * Returns middle card.
     *
     * @return Middle card.
     */
    public Card getMiddleCard() {
        return middleCard;
    }

    /**
     * Returns storage.
     *
     * @return Storage.
     */
    public Storage getStorage() {
        return storage;
    }

    /**
     * Returns players.
     *
     * @return Players.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Returns turn.
     *
     * @return turn.
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Returns punishment.
     *
     * @return Punishment.
     */
    public int getPunishment() {
        return punishment;
    }

    /**
     * Set the punishment.
     *
     * @param punishment Punishment to be set.
     */
    public void setPunishment(int punishment) {
        this.punishment = punishment;
    }

    /**
     * Returns number of players in game.
     *
     * @return Number of players in game.
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * Set the middle card.
     *
     * @param middleCard The card to be set.
     */
    public void setMiddleCard(Card middleCard) {
        storage.addCard(this.middleCard);
        this.middleCard = middleCard;
    }

    /**
     * Run the game.
     */
    public void runGame() {
        randomArrangementOfPlayers();
        middleCard = storage.getCard(0);
        while (middleCard instanceof MotionCard) {
            storage.addCard(middleCard);
            middleCard = storage.getCard(0);
        }

        while (true) {
            for (Player player : players) {
                if (player.getHand().size() == 0) {
                    System.out.println("Winner:" + player.getName());
                    return;
                }
            }
            System.out.println(gameDirection);
            System.out.println("Middle card:");
            middleCard.showCard();
            Card card = players.get(turn).act(middleCard);
            if (card == null) {
                players.get(turn).addCardToHand(storage.getCard(0));
                card = players.get(turn).act(middleCard);
                if (card == null) {
                    nextTurn();
                } else {
                    card.act(this);
                    storage.addCard(card);
                }
            } else {
                for (Player player : players) {
                    if (player.getHand().size() == 0) {
                        System.out.println("Winner:" + player.getName());
                        return;
                    }

                }
                checkPunishment();
                card.act(this);
                storage.addCard(card);

            }

        }

    }

    /**
     * Imposes a penalty on someone who has a seven card but has not played.
     */
    public void checkPunishment() {
        if (punishment != 0) {
            for (int i = 0; i < getPunishment(); i++) {
                getPlayers().get(getTurn()).addCardToHand(getStorage().getCard(0));
            }
        }
        punishment = 0;
    }

    /**
     * Prints game results and player names.
     */
    public void showResult() {
        int[] scoresArray = new int[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            scoresArray[i] = getPlayer(i).getPlayerScore();
        }
        Player[] playersArray = new Player[players.size()];
        playersArray = players.toArray(playersArray);
        sort(scoresArray, playersArray);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(playersArray[i].getName() + " " + scoresArray[i]);
        }
    }

    /**
     * Sorts players based on their points.
     *
     * @param scoresArray  Scores of the players.
     * @param playersArray Players to be sort.
     */
    private void sort(int[] scoresArray, Player[] playersArray) {
        for (int i = 0; i < numberOfPlayers - 1; i++)
            for (int j = 0; j < numberOfPlayers - i - 1; j++)
                if (scoresArray[j] > scoresArray[j + 1]) {
                    int tempScore = scoresArray[j];
                    Player tempPlayer = playersArray[j];
                    scoresArray[j] = scoresArray[j + 1];
                    playersArray[j] = playersArray[j + 1];
                    scoresArray[j + 1] = tempScore;
                    playersArray[j + 1] = tempPlayer;

                }
    }

    /**
     * Arranges players randomly.
     */
    private void randomArrangementOfPlayers() {
        ArrayList<Player> randomArrangement = new ArrayList<>();
        Random random = new Random();
        while (randomArrangement.size() < numberOfPlayers) {
            Player player = getPlayer(random.nextInt(numberOfPlayers));
            if (!randomArrangement.contains(player))
                randomArrangement.add(player);
        }
        players = randomArrangement;
    }

    /**
     * Arranges cards randomly.
     *
     * @param cards Cards to be arranged.
     * @return Arranged cards.
     */
    private ArrayList<Card> randomArrangementOfCards(ArrayList<Card> cards) {
        ArrayList<Card> randomArrangement = new ArrayList<>();
        Random random = new Random();
        while (randomArrangement.size() < cards.size()) {
            Card card = cards.get(random.nextInt(cards.size()));
            if (!randomArrangement.contains(card))
                randomArrangement.add(card);
        }
        return randomArrangement;
    }

    /**
     * Changes the direction of rotation of the game.
     */
    public void changeGameDirection() {
        if (gameDirection == null)
            gameDirection = "clockwise";
        else if (gameDirection.equals("clockwise"))
            gameDirection = "anticlockwise";
        else if (gameDirection.equals("anticlockwise"))
            gameDirection = "clockwise";
    }

    /**
     * Moves the game forward.
     */
    public void nextTurn() {
        if (gameDirection.equals("clockwise"))
            turn = ++turn % numberOfPlayers;
        else if (gameDirection.equals("anticlockwise")) {
            turn--;
            if (turn < 0) {
                turn = (turn + numberOfPlayers) % numberOfPlayers;
            } else
                turn = turn % numberOfPlayers;
        }
    }

}

