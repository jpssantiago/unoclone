package br.sp.anhembi.p1.structures.queue;

public interface QueueADT<Item> {

    int size();
    boolean isEmpty();
    boolean contains(Item item);

    void show();
    boolean clear();

    void enqueue(Item item);

    Item remove() throws Exception;
    Item poll();
    Item peek();

    Item[] toArray();
}
