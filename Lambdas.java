package Lesson2_12_09_2015;

public class Lambdas {
    public static void main(String[] args) {
        A pa = new B();
        pa.f();
        A pa1 = new B()::f; /*Аналог с лямбдой, в этом случае наследование класса B не обязательно*/
        /*A pa1 = new NoName(new B()).f();*/
        pa1.f();
    }
}

interface A{
    void f();
}

class NoName implements A{
    B pb;
    public NoName(B pb){
        this.pb = pb;
    }
    public void f(){
        pb.f();
    }
}

class B implements A{
    public void f(){
        System.out.println("B");
    }
}
