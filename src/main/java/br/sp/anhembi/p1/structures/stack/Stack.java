package br.sp.anhembi.p1.structures.stack;

import java.util.Iterator;

public class Stack<Item> implements StackADT<Item>, Iterable<Item> {

    protected Node<Item> top;

    @Override
    public int size() {
        int size = 0;
        Node<Item> current = this.top;
        while (current != null) {
            current = current.below;
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    @Override
    public void push(Item item) {
        if (isEmpty()) {
            this.top = new Node<>(item);
        } else {
            Node<Item> current = this.top;
            while (current.below != null) {
                current = current.below;
            }
            current.below = new Node<>(item);
        }
    }

    @Override
    public void show() {
        System.out.print('[');
        Node<Item> current = this.top;
        while (current != null) {
            System.out.print(current.below == null ? current.item : current.item + ", ");
            current = current.below;
        }
        System.out.println(']');
    }

    @Override
    public boolean clear() {
        Node<Item> current = this.top;
        while (current != null) {
            pop();
        }
        return isEmpty();
    }

    @Override
    public Item pop() {
        if (isEmpty()) {
            return null;
        }

        Item item = this.top.item;
        this.top = this.top.below;
        return item;
    }

    @Override
    public Item peek() {
        return this.top.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator<>(this);
    }
}