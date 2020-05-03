package br.sp.anhembi.p1.structures.stack;

import java.util.Iterator;

public class StackIterator<Item> implements Iterator<Item> {

    private Node<Item> current;

    public StackIterator(Stack<Item> stack) {
        this.current = stack.top;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Item next() {
        Item item = current.item;
        current = current.below;
        return item;
    }
}
