package Lesson2_12_09_2015.homework.set;

import java.util.ArrayList;

public final class ArrayListContainer<E> implements Container<E> {

    private ArrayList<E> storage;

    public ArrayListContainer (){
        this.storage = new ArrayList<>();
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
        ArrayListContainer<E> toReturn = new ArrayListContainer<>();
        toReturn.storage = (ArrayList<E>)this.storage.clone();
        return toReturn;
    }

    @Override
    public String toString(){
        return storage.toString();
    }

    public static void main(String[] args) {
        Container<Integer> c1 = new ArrayListContainer<>();
        c1.add(0);
        c1.add(1);
        c1.add(2);
        c1.add(3);
        Container<Integer> c2 = c1.clone();
        c1.remove(0);
        c1.remove(0);
        System.out.println(c1);
        System.out.println(c2);
    }
}
