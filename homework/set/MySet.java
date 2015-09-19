package Lesson2_12_09_2015.homework.set;

public class MySet<E> {

    private Container<E> container;

    public MySet(Container<E> container) {
        this.container = container;
    }

    public boolean add(E elem) {
        if (!container.contains(elem)) {
            container.add(elem);
            return true;
        }
        return false;
    }

    public boolean remove(E elem) {
        for (int i = 0; i < container.size(); i++) {
            if (container.get(i).equals(elem)) {
                container.remove(i);
                return true;
            }
        }
        return false;
    }

    public MySet<E> union(MySet<E> other) {
        MySet<E> result;
        result = new MySet<>(this.container.clone());
        E curElem;
        for (int i = 0; i < other.container.size(); i++) {
            curElem = other.container.get(i);
            if (!result.container.contains(curElem)) {
                result.container.add(curElem);
            }
        }
        return result;
    }

    public MySet<E> inters(MySet<E> other) {
        MySet<E> result;
        result = new MySet<>(this.container.clone());
        E curElem;
        for (int i = 0; i < result.container.size(); i++) {
            curElem = result.container.get(i);
            if (!other.container.contains(curElem)) {
                result.container.remove(i--);
            }
        }
        return result;
    }

    public MySet<E> minus(MySet<E> other) {
        MySet<E> result;
        result = new MySet<>(this.container.clone());
        E curElem;
        for (int i = 0; i < result.container.size(); i++) {
            curElem = result.container.get(i);
            if (other.container.contains(curElem)) {
                result.container.remove(i--);
            }
        }
        return result;
    }

    public String toString() {
        return container.toString();
    }

    public static void main(String[] args) {
        Container<Integer> c1 = new ArrayContainer<>();
        Container<Integer> c2 = new ArrayListContainer<>();
        Container<Integer> c3 = new DoubleLinkedListContainer<>();
        MySet<Integer> set1 = new MySet<>(c1);
        MySet<Integer> set2 = new MySet<>(c2);
        MySet<Integer> set3 = new MySet<>(c3);
        set1.add(1);
        set1.add(0);
        set1.add(1);
        set1.add(3);
        set2.add(5);
        set2.add(6);
        set2.add(3);
        set2.add(0);
        set3.add(8);
        set3.add(7);
        set3.add(6);
        set3.add(0);
        set3.add(1);
        System.out.println(set1);
        System.out.println(set2);
//        System.out.println(set3);
//        System.out.println(set1.union(set2));
//        System.out.println(set1.minus(set2));
        System.out.println(set1.inters(set2));
    }
}

