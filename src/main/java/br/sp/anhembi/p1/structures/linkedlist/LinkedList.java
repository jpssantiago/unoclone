package br.sp.anhembi.p1.structures.linkedlist;

import java.util.Iterator;

public class LinkedList<Item> implements LinkedListADT<Item>, Iterable<Item> {

    protected Node<Item> head;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int size = 0;
        Node<Item> current = this.head;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    @Override
    public void show() {
        System.out.print('[');
        Node<Item> current = this.head;
        while (current != null) {
            System.out.print(current.next == null ? current.item : current.item + ", ");
            current = current.next;
        }
        System.out.println(']');
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        this.head = this.head.next;
    }

    @Override
    public void append(Item item) {
        if (isEmpty()) {
            this.head = new Node<>(item);
        } else {
            Node<Item> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(item);
        }
    }

    @Override
    public void insertAfter(Item item, Item previous) {
        Node<Item> current = this.head;
        while (current != null) {
            if (current.item == previous) {
                current.next = new Node<>(item, current.next);
            }
            current = current.next;
        }
    }

    @Override
    public Item delete(Item item) {
        if (this.head.item == item) {
            this.head = this.head.next;
            return item;
        } else {
            Node<Item> current = this.head;
            while (current.next != null) {
                if (current.next.item == item) {
                    current.next = current.next.next;
                    return item;
                }
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public Item search(Item item) {
        Node<Item> current = this.head;
        while (current != null) {
            if (current.item == item) {
                return item;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean replaceBy(Item target, Item replacement) {
        Node<Item> current = this.head;
        while (current != null) {
            if (current.item == target) {
                current.item = replacement;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator<>(this);
    }
}
