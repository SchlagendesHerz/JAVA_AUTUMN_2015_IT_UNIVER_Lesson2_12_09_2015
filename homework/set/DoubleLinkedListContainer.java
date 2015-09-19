package Lesson2_12_09_2015.homework.set;

import Lesson2_12_09_2015.homework.linkedLists.DoubleLinkedList;

public class DoubleLinkedListContainer<E> implements Container<E> {

    private DoubleLinkedList<E> storage;

    public DoubleLinkedListContainer() {
        this.storage = new DoubleLinkedList<>();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean contains(E element) {
        return storage.contains(element);
    }

    @Override
    public void add(E element) {
        storage.add(element);
    }

    @Override
    public E get(int index) {
        return storage.get(index);
    }

    @Override
    public E remove(int index) {
        return storage.remove(index);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Container<E> clone() {
        DoubleLinkedListContainer<E> clone;
        try{
            clone = (DoubleLinkedListContainer<E>)super.clone();
        }catch (CloneNotSupportedException ex){
            throw new InternalError(ex);
        }
        clone.storage = this.storage.clone();
        return clone;
    }

    @Override
    public String toString(){
        return storage.toString();
    }
}
