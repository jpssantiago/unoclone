package br.sp.anhembi.p1.structures.stack;

public class Node<Item> {

    protected Item item;
    protected Node<Item> below;

    public Node(Item item, Node<Item> below) {
        this.item = item;
        this.below = below;
    }

    public Node(Item item) {
        this.item = item;
    }
}
