package br.sp.anhembi.p1.entities;

import br.sp.anhembi.p1.structures.linkedlist.LinkedList;

public class Player {

    private final String name;
    private LinkedList<Card> deck;

    public Player(String name, LinkedList<Card> deck) {
        this.name = name;
        this.deck = deck;
    }

    public Player(String name) {
        this.name = name;
        this.deck = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Card> getDeck() {
        return deck;
    }

    public void setDeck(LinkedList<Card> deck) {
        this.deck = deck;
    }

    public boolean hasCard(Card card) {
        return getDeck().search(card) != null;
    }

    public void removeCard(Card card) {
        getDeck().delete(card);
    }

    public void addCard(Card card) {
        getDeck().append(card);
    }
}
