package br.sp.anhembi.p1.structures.linkedlist;

public interface LinkedListADT<Item> {

    boolean isEmpty();
    int size();
    void show();
    void removeFirst();

    void append(Item item);
    void insertAfter(Item item, Item previous);
    Item delete(Item item);
    Item search(Item item);
    boolean replaceBy(Item target, Item replacement);
}
