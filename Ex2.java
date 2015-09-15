package Lesson2_12_09_2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Set {
    private Container c;

    public Set(Container c) {
        this.c = c;
    }

    public Set union(Set s) {
        Set result = new Set(this.c.copy());
        int count = s.c.size();
        for (int i = 0; i < count; i++) {
            int element = s.c.get(i);
            if (!result.c.contains(element)) {
                result.c.add(element);
            }
        }
        return result;
    }

    @Override
    public String toString(){
        return c.toString();
    }

    public static void main(String[] args) {
        Container c1 = new MyArray();
        Container c2 = new MyArray();
        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);
        c2.add(5);
        c2.add(6);
        c2.add(7);
        c2.add(1);
        Set s1 = new Set(c1);
        Set s2 = new Set(c2);
        System.out.println(s1.union(s2));
    }
}

interface Container {
    Container copy();
    int size();
    int get(int index);
    boolean contains(int element);
    void add(int element);
}

class MyArray implements Container{

    private List<Integer> c = new ArrayList<>();

    @Override
    public Container copy() {
        MyArray cp = new MyArray();
        for(int elem : c){
            cp.add(elem);
        }
        return cp;
    }

    @Override
    public int size() {
        return c.size();
    }

    @Override
    public int get(int index) {
        return c.get(index);
    }

    @Override
    public boolean contains(int element) {
        return c.contains(element);
    }

    @Override
    public void add(int element) {
        c.add(element);
    }

    @Override
    public String toString(){
        return c.toString();
    }
}