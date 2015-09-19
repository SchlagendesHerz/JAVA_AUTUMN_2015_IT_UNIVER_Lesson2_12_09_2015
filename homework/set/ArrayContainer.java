package Lesson2_12_09_2015.homework.set;

import java.util.Arrays;

public final class ArrayContainer<E> implements Container<E> {

    private E[] storage;

    @SuppressWarnings("unchecked")
    public ArrayContainer(){
        this.storage = (E[])new Object[0];
    }

    @Override
    public int size() {
        return storage.length;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(E element) {
        storage = Arrays.copyOf(storage, storage.length + 1);
        storage[storage.length - 1] = element;
    }

    @Override
    public E get(int index) {
        return storage[index];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index >= storage.length){
            throw new IllegalArgumentException(index + " > " + (storage.length - 1));
        }
        E toReturn = storage[index];
        if(index == 0){
            storage = Arrays.copyOfRange(storage, 1, storage.length);
        } else if (index == storage.length - 1){
            storage = Arrays.copyOf(storage, storage.length - 1);
        } else {
            E[] oldStorage = storage;
            storage = (E[]) new Object[storage.length - 1];
            System.arraycopy(oldStorage, 0, storage, 0, index);
            System.arraycopy(oldStorage, index + 1, storage, index, storage.length - index);
        }

        return toReturn;
    }

    @Override
    public Container<E> clone() {
        ArrayContainer<E> toReturn = new ArrayContainer<>();
        toReturn.storage = this.storage.clone();
        return toReturn;
    }

    @Override
    public String toString(){
        return Arrays.toString(storage);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Container<Integer> ar = new ArrayContainer<>();
        System.out.println(ar.size());
        ar.add(0);
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.add(5);
        Container<Integer> ar2 = ar.clone();
        System.out.println(ar);
        System.out.println(ar2);
        ar.remove(0);
        System.out.println(ar);
        System.out.println(ar2);
    }
}
