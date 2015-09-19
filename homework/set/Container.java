package Lesson2_12_09_2015.homework.set;

public interface Container<E> extends Cloneable {
    int size();
    boolean contains(E element);
    void add(E element);
    E get(int index);
    E remove(int index);
    Container<E> clone();
}
