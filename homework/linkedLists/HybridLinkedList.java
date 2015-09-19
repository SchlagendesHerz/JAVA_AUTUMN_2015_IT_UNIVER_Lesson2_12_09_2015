package Lesson2_12_09_2015.homework.linkedLists;

public class HybridLinkedList<E> {

    private static class Node<E> {
        static final int DEFAULT_ARRAY_LENGTH = 10;
        static int arLen;

        Node<E> next;
        Node<E> prev;
        E[] data;

        @Override
        public String toString() {
            if (this.data == null) {
                return "null";
            }
            StringBuilder sb = new StringBuilder("[]");
            for (int i = 0; i < arLen; i++) {
                sb.insert(sb.length() - 1, this.data[i]);
                if (i != arLen - 1) {
                    sb.insert(sb.length() - 1, ", ");
                }
            }
            return sb.toString();
        }
    }

    private Node<E> head;
    private int size;

    public HybridLinkedList(int arLen) {
        this.head = new Node<>();
        this.head.next = this.head;
        this.head.prev = this.head;
        this.size = 0;
        Node.arLen = arLen <= 0 ? Node.DEFAULT_ARRAY_LENGTH : arLen;
    }

    @SuppressWarnings("unchecked")
    public void add(E[] ar) {
        Node<E> toAdd = new Node<>();
        if (ar != null) {
            toAdd.data = (E[]) new Object[Node.arLen];
            System.arraycopy(ar, 0, toAdd.data, 0, Math.min(Node.arLen, ar.length));
        } else {
            toAdd.data = null;
        }
        head.prev.next = toAdd;
        toAdd.prev = head.prev;
        toAdd.next = head;
        head.prev = toAdd;
        size++;
    }

    public boolean contains(E[] ar) {
        if (ar != null && ar.length >= Node.arLen) {
            return false;
        }
        Node<E> curNode = head.next;
        for (; curNode != head; curNode = curNode.next) {
            if (curNode.data == null && ar == null) {
                return true;
            }
            if (curNode.data == null || ar == null) continue;
            if (contains(curNode.data, ar)) {
                return true;
            }
        }
        return false;
    }

    public E[] get(int index) {
        indexCheck(index);
        Node<E> toGet = find(index);
        return toGet.data;
    }

    public E get(int nodeIdx, int arIdx) {
        indexCheck(nodeIdx);
        if (arIdx >= Node.arLen || arIdx < 0) {
            throw new IllegalArgumentException();
        }
        Node<E> toGet = find(nodeIdx);
        return toGet.data[arIdx];
    }

    public E[] remove(int index) {
        indexCheck(index);
        Node<E> toRemove = find(index);
        E[] toReturn = toRemove.data;
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
        size--;
        return toReturn;
    }

    public int size() {
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public E[] set(int index, E[] ar) {
        indexCheck(index);
        Node<E> toSet = find(index);
        E[] toReturn = toSet.data;
        if (ar != null) {
            toSet.data = (E[]) new Object[Node.arLen];
            System.arraycopy(ar, 0, toSet.data, 0, Math.min(Node.arLen, ar.length));
        } else {
            toSet.data = null;
        }
        return toReturn;
    }

    public E set(int nodeIdx, int arIdx, E elem) {
        indexCheck(nodeIdx);
        if (arIdx >= Node.arLen || arIdx < 0) {
            throw new IllegalArgumentException();
        }
        Node<E> toSet = find(nodeIdx);
        E toReturn = toSet.data[arIdx];
        toSet.data[arIdx] = elem;
        return toReturn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{}");
        String ls = System.lineSeparator();
        Node<E> curNode = head.next;
        for (int i = 0; i < this.size; curNode = curNode.next, i++) {
            sb.insert(sb.length() - 1, ls);
            sb.insert(sb.length() - 1, curNode.toString());
            if (i == this.size - 1) {
                sb.insert(sb.length() - 1, ls);
            }
        }
        return sb.toString();
    }

    private boolean contains(E[] ar, E[] subAr) {
        for (int i = 0; i < ar.length; i++) {
            if (ar.length - i < subAr.length) {
                break;
            }
            mark:
            {
                for (int j = 0; j < subAr.length; j++) {
                    if (ar[i + j] == null && subAr[j] == null) {
                        continue;
                    }
                    if (ar[i + j] == null || subAr[j] == null) break mark;
                    if (!ar[i + j].equals(subAr[j])) {
                        break mark;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void indexCheck(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
    }

    private Node<E> find(int index) {
        Node<E> curNode = head.next;
        int i = 0;
        for (; i < index; curNode = curNode.next, i++) ;
        return curNode;
    }

    public static void main(String[] args) {
        HybridLinkedList<Integer> l = new HybridLinkedList<>(10);
        l.add(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        l.add(null);
        l.add(new Integer[]{8, 5, 8, 7, 8, 9, 8});
        System.out.println(l);
//        System.out.println(l.contains(new Integer[]{8, null}));
    }
}