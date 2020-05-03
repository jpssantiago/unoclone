package br.sp.anhembi.p1.entities;

import br.sp.anhembi.p1.storage.Storage;
import br.sp.anhembi.p1.structures.queue.Queue;
import br.sp.anhembi.p1.structures.stack.Stack;

import java.util.Random;

public class Game {

    private final Queue<Player> players;
    private final Stack<Card> tableCards;
    private final Stack<Card> droppedCards;

    public Game(int playerAmount) {
        Storage storage = new Storage();

        if (playerAmount < 2) playerAmount = 2;
        if (playerAmount > 10) playerAmount = 10;

        this.players = storage.getPlayers(playerAmount);
        this.tableCards = storage.getAllCards();
        this.droppedCards = new Stack<>();

        shuffleCards(tableCards);
        giveStarterCards();
        //showDecks();
    }

    public void giveStarterCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.addCard(tableCards.pop());
            }
        }
    }

    public void showDecks() {
        for (Player player : players) {
            System.out.println(player.getName() + " deck: ");
            for (Card card : player.getDeck()) {
                System.out.println("\t" + card.getLabel().toLowerCase().replace("_", " ") + " - " + card.getColor());
            }
            System.out.print("\n");
        }
    }

    public void setStarterCard() {
        droppedCards.push(tableCards.pop()); // Virar a última carta do baralho de compras pra ser a carta inicial.
    }

    public void shuffleCards(Stack<Card> cards) {
        int size = cards.size();
        Card[] aux = new Card[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int index;
            do {
                index = random.nextInt(size);
            } while (aux[index] != null);
            aux[index] = cards.pop();
        }

        for (Card card : aux) {
            cards.push(card);
        }
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public Stack<Card> getTableCards() {
        return tableCards;
    }

    public Stack<Card> getDroppedCards() {
        return droppedCards;
    }
}