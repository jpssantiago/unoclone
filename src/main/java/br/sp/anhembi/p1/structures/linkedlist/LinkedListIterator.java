package br.sp.anhembi.p1.structures.linkedlist;

import java.util.Iterator;

public class LinkedListIterator<Item> implements Iterator<Item> {

    private Node<Item> current;

    public LinkedListIterator(LinkedList<Item> list) {
        this.current = list.head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Item next() {
        Item item = current.item;
        current = current.next;
        return item;
    }
}
