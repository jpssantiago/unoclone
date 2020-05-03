package br.sp.anhembi.p1.structures.queue;

import java.util.Iterator;

public class QueueIterator<Item> implements Iterator<Item> {

    private Node<Item> current;

    public QueueIterator(Queue<Item> queue) {
        this.current = queue.first;
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
