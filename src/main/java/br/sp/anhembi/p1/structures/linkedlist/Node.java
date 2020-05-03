package br.sp.anhembi.p1.structures.linkedlist;

public class Node<Item> {

    protected Item item;
    protected Node<Item> next;

    public Node(Item item, Node<Item> next) {
        this.item = item;
    }

    public Node(Item item) {
        this.item = item;
    }
}
