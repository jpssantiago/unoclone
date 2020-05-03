package br.sp.anhembi.p1.structures.queue;

import java.util.Iterator;

public class Queue<Item> implements QueueADT<Item>, Iterable<Item> {

    protected Node<Item> first;

    public Queue() {
        first = null;
    }

    @Override
    public int size() {
        Node<Item> last = first;
        int size = 0;
        while (last != null) {
            last = last.next;
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Item item) {
        Node<Item> last = first;
        while (last.next != null) {
            if (last.item == item) {
                return true;
            }
            last = last.next;
        }
        return false;
    }

    @Override
    public void show() {
        System.out.print("[");
        Node<Item> last = first;
        while (last != null) {
            System.out.print(last.next == null ? last.item : last.item + ", ");
            last = last.next;
        }
        System.out.println("]");
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public void enqueue(Item item) {
        if (isEmpty()) {
            first = new Node<>(item);
            return;
        }

        Node<Item> last = first;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new Node<>(item);
    }

    @Override
    public Item remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("The queue is empty.");
        }

        Item firstItem = first.item;
        first = first.next;
        return firstItem;
    }

    @Override
    public Item poll() {
        if (isEmpty()) {
            return null;
        }

        Item firstItem = first.item;
        first = first.next;
        return firstItem;
    }

    @Override
    public Item peek() {
        return first.item;
    }

    @Override
    public Item[] toArray() {
        int size = size();
        Item[] array = (Item[])new Object[size];
        Node<Item> last = first;
        for (int i = 0; i < size; i++) {
            array[i] = last.item;
            last = last.next;
        }
        return array;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator<>(this);
    }
}
