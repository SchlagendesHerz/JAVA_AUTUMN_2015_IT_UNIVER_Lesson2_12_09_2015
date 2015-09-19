package Lesson2_12_09_2015.homework.linkedLists;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements Cloneable {

    private Node<E> header;
    private int size;

    private static class Node<E> {
        Node<E> next;
        Node<E> prev;
        E val;
    }

    public DoubleLinkedList() {
        header = new Node<>();
        header.prev = header;
        header.next = header;
        size = 0;
    }

    public void add(E val) {
        Node<E> toAdd = new Node<>();
        toAdd.val = val;
        header.prev.next = toAdd;
        toAdd.prev = header.prev;
        toAdd.next = header;
        header.prev = toAdd;
        size++;
    }

    public boolean contains(E elem) {
        return find(elem) != null;
    }

    @SuppressWarnings("unchecked")
    public DoubleLinkedList<E> clone(){
        DoubleLinkedList<E> clone;
        try{
            clone = (DoubleLinkedList<E>)super.clone();
        }catch(CloneNotSupportedException ex){
            throw new InternalError(ex);
        }
        clone.header = new Node<>();
        clone.header.next = clone.header;
        clone.header.prev = clone.header;
        Node<E> curNode = clone.header.next;
        for(; curNode != header; curNode = curNode.next){
            clone.add(curNode.val);
        }
        return clone;
    }

    public E get(int index){
        return find(index).val;
    }

    public E remove() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        return remove(0);
    }

    public E remove(int index){
        indexCheck(index);
        Node<E> toRemove = find(index);
        E toReturn = toRemove.val;
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        size--;
        return toReturn;
    }

    public E set(int index, E val){
        indexCheck(index);
        Node<E> toSet = find(index);
        E toReturn = toSet.val;
        toSet.val = val;
        return toReturn;
    }

    public int size(){
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[]");
        Node<E> curNode = header.next;
        for (int i = 0; i < size; curNode = curNode.next, i++) {
            sb.insert(sb.length() - 1, String.valueOf(curNode.val));
            if (i != size - 1) {
                sb.insert(sb.length() - 1, ", ");
            }
        }
        return sb.toString();
    }

    private Node<E> find(int index) {
        Node<E> curNode = header.next;
        int i = 0;
        for (; i < index; curNode = curNode.next, i++) ;
        return curNode;
    }

    private Node<E> find(E elem) {
        Node<E> curNode = header.next;
        for (; curNode != header; curNode = curNode.next) {
            if (curNode.val == null) {
                if (elem == null){
                    return curNode;
                } else continue;
            }
            if (curNode.val.equals(elem)) {
                return curNode;
            }
        }
        return null;
    }

    private void indexCheck(int index){
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> l = new DoubleLinkedList<>();
        l.add(0);
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
        System.out.println(l.set(2, 20));
        System.out.println(l);
//        System.out.println(l.contains(3));
    }
}