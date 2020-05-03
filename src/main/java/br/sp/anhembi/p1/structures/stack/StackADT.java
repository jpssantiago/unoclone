package br.sp.anhembi.p1.structures.stack;

public interface StackADT<Item> {

    int size();
    boolean isEmpty();
    void push(Item item);

    void show();
    boolean clear();

    Item pop();
    Item peek();
}
