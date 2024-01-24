package example.ch17.practice.p11_poly.intermediate.ex6;

public class InterfaceMain {
    public static void main(String[] args) {
        InterfaceA a = new Child();
        a.methodA();
        a.methodCommon();

        InterfaceB b = new Child();
        b.methodB();
        b.methodCommon();

        Child c = new Child();
        c.methodCommon();
    }
}