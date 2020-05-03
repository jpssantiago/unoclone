package br.sp.anhembi.p1.storage;

import br.sp.anhembi.p1.entities.Player;
import br.sp.anhembi.p1.entities.Card;
import br.sp.anhembi.p1.structures.queue.Queue;
import br.sp.anhembi.p1.structures.stack.Stack;

import java.util.Random;

public class Storage {

    private final String[] names = { "João", "Gabriel", "Maria", "Eduardo", "Matheus", "Júlia", "Gustavo", "André", "Ricardo", "Pedro" };
    private final String[] colors = { "red", "blue", "green", "yellow" };
    private final String[] specialCards = { "REVERSE", "JUMP", "PLUS_2" };
    private final String[] wildCards = { "PLUS_4", "CHANGE_COLOR" };

    public Stack<Card> getAllCards() {
        Stack<Card> cards = new Stack<>();

        for (Card numeric : generateNumericCards()) {
            cards.push(numeric);
        }

        for (Card special : generateSpecialCards()) {
            cards.push(special);
        }

        for (Card wild : generateWildCards()) {
            cards.push(wild);
        }

        return cards;
    }

    public Queue<Player> getPlayers(int amount) {
        Queue<Player> queue = new Queue<>();
        for (int i = 0; i < amount; i++) {
            queue.enqueue(generateRandomPlayer());
        }
        return queue;
    }

    private Stack<Card> generateNumericCards() {
        Stack<Card> stack = new Stack<>();
        for (String color : colors) {
            for (int i = 0; i < 10; i++) {
                Card card = new Card(String.valueOf(i), Card.Type.NUMERIC, color);
                stack.push(card);
                if (i != 0) {
                    stack.push(card); // Todas as cartas numéricas (com exceção do 0) possuem 2 unidades para cada cor.
                }
            }
        }
        return stack;
    }

    private Stack<Card> generateSpecialCards() {
        Stack<Card> stack = new Stack<>();
        for (String color : colors) {
            for (String type : specialCards) {
                for (int i = 0; i < 2; i++) {
                    stack.push(new Card(type, Card.Type.valueOf(type), color));
                }
            }
        }
        return stack;
    }

    private Stack<Card> generateWildCards() {
        Stack<Card> stack = new Stack<>();
        for (String type : wildCards) {
            for (int i = 0; i < 4; i++) {
                stack.push(new Card(type, Card.Type.valueOf(type)));
            }
        }
        return stack;
    }

    private Player generateRandomPlayer() {
        int index;
        Random random = new Random();

        do {
            index = random.nextInt(names.length);
        } while (names[index] == null);

        String name = names[index];
        names[index] = null;
        return new Player(name);
    }
}